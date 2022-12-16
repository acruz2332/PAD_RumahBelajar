package com.pad1.padrumahbelajar.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.pad1.padrumahbelajar.api.BaseApiService;
import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.api.UtilsApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddQuestionActivity extends AppCompatActivity {
    EditText etSoal, etA, etB, etC, etD, etE;
    String jawaban, token, mataPelajaran, namaQuiz;
    RadioButton rbA, rbB, rbD, rbC, rbE;
    RadioGroup radioGroupJawaban;
    BaseApiService mApiService;
    Button btnAdd;
    ImageView arrow;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        Intent intent = getIntent();
        etSoal = findViewById(R.id.etSoal);
        etA = findViewById(R.id.tietA);
        etB = findViewById(R.id.tietB);
        etC = findViewById(R.id.tietC);
        etD = findViewById(R.id.tietD);
        etE = findViewById(R.id.tietE);
        jawaban = "";;
        Bundle bundle = getIntent().getExtras();
        mataPelajaran = bundle.getString("mataPelajaran");
        namaQuiz = bundle.getString("namaQuiz");
        token = bundle.getString("token");
        btnAdd = findViewById(R.id.btnAdd);
        arrow = findViewById(R.id.img_back);


        radioGroupJawaban = findViewById(R.id.radioGroupJawab);
        mApiService = UtilsApi.getAPIService();

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        radioGroupJawaban.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButtonA:
                        jawaban = "a";
                        Toast.makeText(getApplicationContext(), jawaban, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonB:
                        jawaban = "b";
                        Toast.makeText(getApplicationContext(), jawaban, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonC:
                        jawaban = "c";
                        Toast.makeText(getApplicationContext(), jawaban, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonD:
                        jawaban = "d";
                        Toast.makeText(getApplicationContext(), jawaban, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonE:
                        jawaban = "e";
                        Toast.makeText(getApplicationContext(), jawaban, Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postQuestion();

            }
        });


    }

    public void postQuestion() {
        mApiService.questionRequest(token, etSoal.getText().toString(), etA.getText().toString(),
                etB.getText().toString(), etC.getText().toString(), etD.getText().toString(),
                etE.getText().toString(), jawaban).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    Toast.makeText(AddQuestionActivity.this, "sukses heheh", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddQuestionActivity.this, DetailQuizActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("mataPelajaran", mataPelajaran);
                    bundle.putString("namaQuiz", namaQuiz);
                    bundle.putString("token", token);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(AddQuestionActivity.this, "gagal nich", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }

        });
    }
}