package com.pad1.padrumahbelajar.quiz;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pad1.padrumahbelajar.Adapter.HistoryAdapter;
import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.SharedPrefManager;
import com.pad1.padrumahbelajar.api.BaseApiService;
import com.pad1.padrumahbelajar.api.UtilsApi;
import com.pad1.padrumahbelajar.model.HistoryResponse;
import com.pad1.padrumahbelajar.model.HistoryData;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryActivity extends AppCompatActivity {

    private HistoryAdapter adapter;
    RecyclerView recyclerView;
    BaseApiService mApiService;
    ImageView imgHistBack;
    private ArrayList<HistoryData> resultList;
    SharedPrefManager sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        sp = new SharedPrefManager(this);
        Intent intent = getIntent();
        String token = intent.getStringExtra("token");
        recyclerView = findViewById(R.id.rvHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(HistoryActivity.this));
        mApiService = UtilsApi.getAPIService();
        imgHistBack = findViewById(R.id.imgHistBack);

        imgHistBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mApiService.historyRequest(token).enqueue(new Callback<HistoryResponse>() {
            @Override
            public void onResponse(Call<HistoryResponse> call, Response<HistoryResponse> response) {
                if (response.isSuccessful()) {
                    HistoryResponse historyResponse = response.body();
                    ArrayList<HistoryData> historyData = historyResponse.getData();

                    ArrayList<HistoryData> historyFilter = new ArrayList();
                    if (sp.getSpToken().length() == 5) {
                        for (HistoryData data : historyData) {
                            if (sp.getSpToken().equals( data.getTokenMurid())) {
                                Log.e("Masuk", "");
                                historyFilter.add(data);
                            }
                            Log.e("Token", sp.getSpToken() + " " +data.getTokenMurid());
                        }
                    }else {
                        historyFilter.addAll(historyData);
                    }
                    Log.e("Token", sp.getSpToken());
                    Log.e("Data", historyFilter.toString());
                    Log.e("getSuccess", "onFailure: ERROR > " + historyResponse.getStatus().toString());
                    try {
                        adapter = new HistoryAdapter(HistoryActivity.this, historyFilter, sp.getSpToken());
                        recyclerView.setAdapter(adapter);
                    } catch (Exception err) {
                        Log.e(TAG, "Error INIII");
                        err.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<HistoryResponse> call, Throwable t) {
                Log.e("debug", "onFailure: ERROR > " + t.toString());
             }
            }
        );

    }
}