package com.pad1.padrumahbelajar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.model.QuizData;
import com.pad1.padrumahbelajar.quiz.DetailQuizActivity;

import java.util.ArrayList;

public class LabelQuizAdapter extends RecyclerView.Adapter<LabelQuizAdapter.ListViewHolder>{

    private Context context;
    private ArrayList<QuizData> resultList;

    public LabelQuizAdapter(Context context, ArrayList<QuizData> resultList) {
        this.context = context;
        this.resultList = resultList;
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

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(v.getContext(), DetailQuizActivity.class);
            Bundle bundle = new Bundle();

            bundle.putString("mataPelajaran", resultList.get(position).getMataPelajaran());
            bundle.putString("namaQuiz", resultList.get(position).getNamaQuiz());
            bundle.putString("token", resultList.get(position).getToken());
            intent.putExtras(bundle);
            v.getContext().startActivity(intent);

            Toast.makeText(holder.itemView.getContext(), "" + resultList.get(holder.getAdapterPosition()).getMataPelajaran(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        Log.d("jumlah: ", String.valueOf(resultList.size()));
        return resultList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{

        TextView tv1,tv2;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.tvMapel);
            tv2 = itemView.findViewById(R.id.tvQuiz);
        }
    }
}