package com.pad1.padrumahbelajar.Adapter;

import static android.content.ContentValues.TAG;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.api.BaseApiService;
import com.pad1.padrumahbelajar.api.UtilsApi;
import com.pad1.padrumahbelajar.model.QuizData;
import com.pad1.padrumahbelajar.quiz.DetailQuizActivity;
import com.pad1.padrumahbelajar.quiz.HistoryActivity;
import com.pad1.padrumahbelajar.quiz.HistoryData;
import com.pad1.padrumahbelajar.quiz.HistoryResponse;
import com.pad1.padrumahbelajar.quiz.LabelQuizActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LabelQuizAdapter extends RecyclerView.Adapter<LabelQuizAdapter.ListViewHolder>{

    private Context context;
    private ArrayList<QuizData> resultList;
    private String token;

    public LabelQuizAdapter(Context context, ArrayList<QuizData> resultList, String token) {
        this.context = context;
        this.resultList = resultList;
        this.token = token;
    }


    @NonNull
    @Override
    public LabelQuizAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_label_quiz, parent, false);

        LabelQuizAdapter.ListViewHolder viewHolder = new LabelQuizAdapter.ListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.tv1.setText(resultList.get(position).getMataPelajaran().toString());
        holder.tv2.setText(resultList.get(position).getNamaQuiz().toString());
//        Glide.with(holder.imgPoster.getContext()).
//                load("https://image.tmdb.org/t/p/w185" + resultList.get(position).getPosterPath()).
//                into(holder.imgPoster);
        int state = position;

        if (this.token.length() == 5){
            holder.btnHapusQuiz.setVisibility(View.GONE);
        }

        holder.btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), HistoryActivity.class);
                intent.putExtra("token", resultList.get(position).getToken());
                view.getContext().startActivity(intent);
            }
        });

        holder.btnHapusQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        holder.mApiService2.quizListDelete(resultList.get(state).getToken()).enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                if (response.isSuccessful()){
                                    try{
                                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                        if (jsonRESULTS.getString("status").equals("success")) {
                                            Toast.makeText(context, "Berhasil Menghapus", Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException | IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {

                            }
                        });
                    }
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).setMessage("Apakah yaking hapus data?");
                builder.show();
            }
        });

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(v.getContext(), DetailQuizActivity.class);
            Bundle bundle = new Bundle();

            bundle.putString("mataPelajaran", resultList.get(position).getMataPelajaran());
            bundle.putString("namaQuiz", resultList.get(position).getNamaQuiz());
            bundle.putString("token", resultList.get(position).getToken());
            intent.putExtras(bundle);
            v.getContext().startActivity(intent);

//            Toast.makeText(holder.itemView.getContext(), "" + resultList.get(holder.getAdapterPosition()).getMataPelajaran(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        Log.d("jumlah: ", String.valueOf(resultList.size()));
        return resultList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{

        TextView tv1,tv2;
        Button btnHapusQuiz, btnHistory;
        BaseApiService mApiService2;
        private HistoryAdapter adapter;
        RecyclerView recyclerView;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.tvMapel);
            tv2 = itemView.findViewById(R.id.tvQuiz);
            btnHapusQuiz = itemView.findViewById(R.id.btnHapusQuiz);
            btnHistory = itemView.findViewById(R.id.btnHistory);
            mApiService2 = UtilsApi.getAPIService();
            recyclerView = itemView.findViewById(R.id.rvHistory);
//            recyclerView.setLayoutManager(new LinearLayoutManager(context.getApplicationContext()));
        }
    }
}