package com.pad1.padrumahbelajar.fragment;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pad1.padrumahbelajar.Adapter.LabelQuizAdapter;
import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.SharedPrefManager;
import com.pad1.padrumahbelajar.api.BaseApiService;
import com.pad1.padrumahbelajar.api.UtilsApi;
import com.pad1.padrumahbelajar.databinding.ActivityMainBinding;
import com.pad1.padrumahbelajar.model.QuizData;
import com.pad1.padrumahbelajar.model.QuizResponse;
import com.pad1.padrumahbelajar.quiz.AddLabelQuiz;
import com.pad1.padrumahbelajar.quiz.LabelQuizActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class QuizFragment extends Fragment {

    FloatingActionButton fab, fabAddClass;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;
    private LabelQuizAdapter adapter;
    RecyclerView recyclerView;
    BaseApiService mApiService;
    String token;
    SharedPrefManager sp;
    boolean isOpen = false;
    SwipeRefreshLayout srl;

    public QuizFragment() {

    }

    public static QuizFragment newInstance(String param1, String param2) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        FloatingActionButton fab, fabAddClass;
        Animation fabOpen, fabClose, rotateForward, rotateBackward;
        sp = new SharedPrefManager(this.getContext());

        boolean isOpen = false;
        ActivityMainBinding binding;

        String token = sp.getSpToken();
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mApiService = UtilsApi.getAPIService();
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        fab = view.findViewById(R.id.fab);
        recyclerView = view.findViewById(R.id.recyclerViewQuiz);
        srl = view.findViewById(R.id.srl);

        if (sp.getSpToken().length() == 5){
            fab.setVisibility(View.GONE);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getContext(), AddLabelQuiz.class);
                startActivity(intent);
            }
        });
        mApiService.quizRequest().enqueue(new Callback<QuizResponse>() {
            @Override
            public void onResponse(Call<QuizResponse> call, Response<QuizResponse> response) {
                if (response.isSuccessful()) {
                    QuizResponse quizResponse = response.body();
                    ArrayList<QuizData> quizData = quizResponse.getData();
                    Log.e("getSuccess", "onFailure: ERROR > " + quizResponse.getStatus().toString());
                    try {
                        adapter = new LabelQuizAdapter(getContext(), quizData, sp.getSpToken());
                        recyclerView.setAdapter(adapter);
                        LinearLayoutManager llm = new LinearLayoutManager(getContext());
                        llm.setOrientation(LinearLayoutManager.VERTICAL);
                        recyclerView.setLayoutManager(llm);
                    } catch (Exception err) {
                        Log.e(TAG, "Error INIII");
                        err.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<QuizResponse> call, Throwable t) {
                Log.e("debug", "onFailure: ERROR > " + t.toString());
            }
        });

        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mApiService.quizRequest().enqueue(new Callback<QuizResponse>() {
                    @Override
                    public void onResponse(Call<QuizResponse> call, Response<QuizResponse> response) {
                        if (response.isSuccessful()) {
                            QuizResponse quizResponse = response.body();
                            ArrayList<QuizData> quizData = quizResponse.getData();
                            Log.e("getSuccess", "onFailure: ERROR > " + quizResponse.getStatus().toString());
                            try {
                                adapter = new LabelQuizAdapter(getContext(), quizData, sp.getSpToken());
                                recyclerView.setAdapter(adapter);
                            } catch (Exception err) {
                                Log.e(TAG, "Error INIII");
                                err.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<QuizResponse> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                    }
                });
            }
        });



        return view;
    }
}