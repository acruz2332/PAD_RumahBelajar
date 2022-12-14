package com.pad1.padrumahbelajar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pad1.padrumahbelajar.fragment.ClassFragment;
import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.model.KelasData;

import java.util.ArrayList;

public class KelasAdapter extends RecyclerView.Adapter<KelasAdapter.ViewHolder> {
    private Context context;
    private ArrayList<KelasData> kelasData;

    public KelasAdapter(Context context, ArrayList<KelasData>kelasData) {
        this.kelasData = kelasData;
        this.context = context;
    }

    @NonNull
    @Override
    public KelasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kelas,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KelasAdapter.ViewHolder holder, int position) {
        holder.namaKelas.setText(kelasData.get(position).getNamaKelas());
        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(v.getContext(), ClassFragment.class);
            Bundle bundle = new Bundle();

            bundle.putString("namaKelas", kelasData.get(position).getNamaKelas());

            intent.putExtras(bundle);
            v.getContext().startActivity(intent);

            Toast.makeText(holder.itemView.getContext(), "" + kelasData.get(holder.getAdapterPosition()).getNamaKelas(), Toast.LENGTH_SHORT).show();
        });



    }

    @Override
    public int getItemCount() {
        return kelasData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaKelas, namaGuru;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaKelas = itemView.findViewById(R.id.nama_kelas);
            namaGuru = itemView.findViewById(R.id.nama_guru);
        }
    }
}
