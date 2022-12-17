package com.pad1.padrumahbelajar.quiz;

import static android.content.ContentValues.TAG;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pad1.padrumahbelajar.Adapter.DetailQuizAdapter;
import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.SharedPrefManager;
import com.pad1.padrumahbelajar.api.BaseApiService;
import com.pad1.padrumahbelajar.api.UtilsApi;
import com.pad1.padrumahbelajar.fragment.QuizFragment;
import com.pad1.padrumahbelajar.model.QuestionData;
import com.pad1.padrumahbelajar.model.QuestionResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailQuizActivity extends AppCompatActivity {
    private DetailQuizAdapter adapter;
    RecyclerView recyclerView;
    BaseApiService mApiService2;
    TextView tv1, tv2;
    String mataPelajaran, namaQuiz, token;
    ImageView arrow;
    Character[] jwb;
    String jawabanString = "";
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_quiz);

        mApiService2 = UtilsApi.getAPIService();
        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Bundle bundle = getIntent().getExtras();
        mataPelajaran = bundle.getString("mataPelajaran");
        namaQuiz = bundle.getString("namaQuiz");
        token = bundle.getString("token");
        SharedPrefManager sp = new SharedPrefManager(this);
        btnSubmit = findViewById(R.id.btnSubmit);
        arrow = findViewById(R.id.imgBack);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv1.setText(mataPelajaran);
        tv2.setText(namaQuiz);
        FloatingActionButton fab = findViewById(R.id.fab);
        jawabanString = "";

        if (sp.getSpToken().length() == 6){
            btnSubmit.setVisibility(View.GONE);
            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        }else if (sp.getSpToken().length() == 5){
            fab.setVisibility(View.GONE);
            arrow.setVisibility(View.GONE);
            onBackPressed();
        }


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailQuizActivity.this, AddQuestionActivity.class);
                Bundle bundle = new Bundle();

                bundle.putString("mataPelajaran", mataPelajaran);
                bundle.putString("namaQuiz", namaQuiz);
                bundle.putString("token", token);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });



        mApiService2.questionRequest(token).enqueue(new Callback<QuestionResponse>() {
            @Override
            public void onResponse(Call<QuestionResponse> call, Response<QuestionResponse> response) {
                if (response.isSuccessful()) {
                    QuestionResponse questionResponse = response.body();
                    ArrayList<QuestionData> questionData = questionResponse.getData();
                    Log.e("getSuccess", "onFailure: ERROR > " + questionResponse.getStatus().toString());
                    try {
                        String nama = questionData.get(0).getJawaban().toString();
                        Log.d("getsucces",nama);
                        adapter = new DetailQuizAdapter(DetailQuizActivity.this, questionData, token, sp.getSpToken());
                        recyclerView.setAdapter(adapter);
//                        LinearLayoutManager llm = new LinearLayoutManager(DetailQuizActivity.this);
//                        llm.setOrientation(LinearLayoutManager.VERTICAL);
//                        recyclerView.setLayoutManager(llm);
                        jwb = adapter.jwb;
                    } catch (Exception err) {
                        Log.e(TAG, "Error INIII");
                        err.printStackTrace();
                    }
                } else {
                    tv1.setText("Error woy");
                }
            }

            @Override
            public void onFailure(Call<QuestionResponse> call, Throwable t) {

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < jwb.length -1; i++) {
                    jawabanString += jwb[i] + ",";
                }
                jawabanString += jwb[jwb.length - 1];
                mApiService2.storeNilai(sp.getSpToken(), token, jawabanString).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()){
                            try{
                                JSONObject jsonRESULT = new JSONObject(response.body().string());
                                if(jsonRESULT.getString("status").equals("success")){
                                    String benar = jsonRESULT.getString("benar");
                                    String salah = jsonRESULT.getString("salah");
                                    String kosong = jsonRESULT.getString("kosong");
                                    String nilai = jsonRESULT.getString("nilai");
                                    String percobaan = jsonRESULT.getString("percobaanKe");

                                    Bundle bundle = new Bundle();
                                    bundle.putString("benar", benar);
                                    bundle.putString("salah", salah);
                                    bundle.putString("kosong", kosong);
                                    bundle.putString("nilai", nilai);
                                    bundle.putString("percobaanKe", percobaan);
                                    Intent intent = new Intent(DetailQuizActivity.this, ResultActivity.class);
                                    intent.putExtras(bundle);
                                    startActivity(intent);
                                    finish();

                                }
                            } catch (JSONException | IOException e){
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
                jawabanString = "";
            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(false);
        Toast.makeText(DetailQuizActivity.this, "Anda Harus Menyelesaikan Kuis Ini!", Toast.LENGTH_LONG).show();
    }


}