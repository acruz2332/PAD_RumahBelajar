package com.pad1.padrumahbelajar.Adapter;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.SharedPrefManager;
import com.pad1.padrumahbelajar.api.BaseApiService;
import com.pad1.padrumahbelajar.api.UtilsApi;
import com.pad1.padrumahbelajar.model.QuestionData;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailQuizAdapter extends RecyclerView.Adapter<DetailQuizAdapter.ListViewHolder>{

    private final Context context;
    private final ArrayList<QuestionData> resultList;

    public Character[] jwb;
    private String token, tokenUser;
    private Activity activity;
    public DetailQuizAdapter(Context context, ArrayList<QuestionData> resultList, String token, String tokenUser) {
        this.context = context;
        this.resultList = resultList;

        this.tokenUser = tokenUser;
        this.token = token;
        this.jwb = new Character[resultList.size()];
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_question, parent, false);

        DetailQuizAdapter.ListViewHolder viewHolder = new DetailQuizAdapter.ListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

//        Toast.makeText(context.getApplicationContext(), ""+resultList.get(position).getQuestion(), Toast.LENGTH_LONG).show();
        if(resultList.get(position).getQuestion().equals("")){
            holder.cv.setVisibility(View.GONE);
        }

        if (tokenUser.length() == 5){
            holder.btnHapus.setVisibility(View.GONE);
        } else if (tokenUser.length() == 6) {
            holder.btnClear.setVisibility(View.GONE);
        }
        try {
            holder.tvQuestion.setText(resultList.get(position).getQuestion());
            ArrayList<String> ans = resultList.get(position).getAnswer();
            holder.rbA.setText(ans.get(0));
            holder.rbB.setText(ans.get(1));
            holder.rbC.setText(ans.get(2));
            holder.rbD.setText(ans.get(3));
            holder.rbE.setText(ans.get(4));
        }catch (Exception err){

            holder.rbB.setText("Silahkan tambah soal");
            holder.rbC.setText("Silahkan tambah soal");
            holder.rbD.setText("Silahkan tambah soal");
            holder.rbE.setText("Silahkan tambah soal");
            Log.e(TAG, "Error INIII");
            err.printStackTrace();
        }

        int state = position;

        holder.btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        holder.mApiService2.quizDelete(token, state).enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                if (response.isSuccessful()){
                                    try{
                                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                        if (jsonRESULTS.getString("status").equals("success")) {
                                            Toast.makeText(context, "Berhasil Menghapus", Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    } catch (IOException e) {
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
        
        holder.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.rdg.clearCheck();
                jwb[state] = null;
            }
        });

        holder.rbA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jwb[state] = 'a';
            }
        });

        holder.rbB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jwb[state] = 'b';
            }
        });

        holder.rbC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jwb[state] = 'c';
            }
        });

        holder.rbD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jwb[state] = 'd';
            }
        });

        holder.rbE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jwb[state] = 'e';
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("jumlah baru: ", String.valueOf(resultList.size()));
        return resultList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuestion, tv1, tv2;
        RadioGroup rdg;
        RadioButton rbA,rbB,rbC,rbD,rbE;
        Button btnClear, btnHapus;
        BaseApiService mApiService2;
        CardView cv;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tvQuestion = itemView.findViewById(R.id.tvQuestion);
            rdg = itemView.findViewById(R.id.rg);
            rbA = itemView.findViewById(R.id.rbA);
            rbB = itemView.findViewById(R.id.rbB);
            rbC = itemView.findViewById(R.id.rbC);
            rbD = itemView.findViewById(R.id.rbD);
            rbE = itemView.findViewById(R.id.rbE);
            btnClear = itemView.findViewById(R.id.btnClear);
            btnHapus = itemView.findViewById(R.id.btnHapus);
            mApiService2 = UtilsApi.getAPIService();
            cv = itemView.findViewById(R.id.cv);

        }
    }

    public Character[] getJwb() {
        return jwb;
    }
}
