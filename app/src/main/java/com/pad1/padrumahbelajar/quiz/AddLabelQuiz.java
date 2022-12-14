package com.pad1.padrumahbelajar.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.pad1.padrumahbelajar.api.BaseApiService;
import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.api.UtilsApi;
import com.pad1.padrumahbelajar.fragment.QuizFragment;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddLabelQuiz extends AppCompatActivity {
    EditText namaMapel, namaQuiz;
    Button tambah;
    BaseApiService mApiService;
    ImageView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_label);
        namaMapel = findViewById(R.id.tiet1);
        namaQuiz = findViewById(R.id.tiet2);
        tambah = findViewById(R.id.btn_tambah);
        mApiService = UtilsApi.getAPIService();
        arrow = findViewById(R.id.imgBack);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestQuiz();
            }
        });
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddLabelQuiz.this, QuizFragment.class);
                startActivity(intent);
            }
        });

    }

    public void requestQuiz(){
        mApiService.quizRequest(namaQuiz.getText().toString(), namaMapel.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(AddLabelQuiz.this, "sukses heheh", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(AddLabelQuiz.this, "gagal nich", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
    }
}