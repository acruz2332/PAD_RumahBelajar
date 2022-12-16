package com.pad1.padrumahbelajar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.model.QuizData;
import com.pad1.padrumahbelajar.quiz.HistoryData;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ListViewHolder> {

    private Context context;
    private ArrayList<HistoryData> resultList;
    private String token;

    public HistoryAdapter(Context context, ArrayList<HistoryData> resultList, String token) {
        this.context = context;
        this.resultList = resultList;
        this.token = token;
    }


    @NonNull
    @Override
    public HistoryAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_history, parent, false);

        HistoryAdapter.ListViewHolder viewHolder = new HistoryAdapter.ListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        Toast.makeText(context, token, Toast.LENGTH_SHORT).show();
        Toast.makeText(context, resultList.get(0).getTokenMurid(), Toast.LENGTH_SHORT).show();

        holder.tvNama.setText(resultList.get(position).getNama().toString());
        holder.tvBenar.setText("Benar: " + resultList.get(position).getBenar().toString());
        holder.tvSalah.setText("Salah: " + resultList.get(position).getSalah().toString());
        holder.tvKosong.setText("Kosong: " + resultList.get(position).getKosong().toString());
        holder.tvPercobaanKe.setText("Percobaan ke-" + resultList.get(position).getPercobaanKe().toString());
        holder.tvNilai.setText("Nilai: " + resultList.get(position).getNilai().toString());
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvBenar, tvSalah, tvKosong, tvNilai, tvPercobaanKe;
        CardView cvHist;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvHistNama);
            tvBenar = itemView.findViewById(R.id.tvHistBenar);
            tvKosong = itemView.findViewById(R.id.tvHistKosong);
            tvNilai = itemView.findViewById(R.id.tvHistNilai);
            tvPercobaanKe = itemView.findViewById(R.id.tvHistPercobaan);
            tvSalah = itemView.findViewById(R.id.tvHistSalah);
            cvHist = itemView.findViewById(R.id.cvHist);
        }
    }
}
