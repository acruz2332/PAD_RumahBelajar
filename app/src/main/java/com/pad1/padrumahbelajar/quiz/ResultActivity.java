package com.pad1.padrumahbelajar.quiz;

import androidx.appcompat.app.AppCompatActivity;
import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.fragment.HomeFragment;
import com.pad1.padrumahbelajar.fragment.QuizFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    String benar, salah, kosong, percobaan;
    String nilai;
    ImageView back;
    Button btnFinish;
    TextView tvBenar, tvSalah, tvKosong, tvNilai, tvPercobaan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle bundle = getIntent().getExtras();
        benar = bundle.getString("benar");
        salah = bundle.getString("salah");
        kosong = bundle.getString("kosong");
        nilai = bundle.getString("nilai");
        percobaan = bundle.getString("percobaanKe");

        tvBenar = findViewById(R.id.tvBenar);
        tvSalah = findViewById(R.id.tvSalah);
        tvKosong = findViewById(R.id.tvKosong);
        tvNilai = findViewById(R.id.tvNilai);
        tvPercobaan = findViewById(R.id.tvPercobaan);
        back = findViewById(R.id.img_back);
        btnFinish = findViewById(R.id.btnFinish);


        tvBenar.setText(benar);
        tvSalah.setText(salah);
        tvKosong.setText(kosong);
        tvNilai.setText(nilai);
        tvPercobaan.setText(percobaan);


        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}