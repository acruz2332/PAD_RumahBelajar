package com.pad1.padrumahbelajar.fragment;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.api.BaseApiService;
import com.pad1.padrumahbelajar.api.UtilsApi;
import com.pad1.padrumahbelajar.databinding.FragmentClassBinding;
import com.pad1.padrumahbelajar.Adapter.KelasAdapter;
import com.pad1.padrumahbelajar.model.KelasData;
import com.pad1.padrumahbelajar.model.KelasResponse;
import com.pad1.padrumahbelajar.quiz.AddLabelQuiz;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ClassFragment extends Fragment {


    private FragmentClassBinding binding;
    FloatingActionButton fab, fabAddClass;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;
    boolean isOpen = false;
    BaseApiService mApiService;
    RecyclerView recyclerView;
    private KelasAdapter adapter;

    public ClassFragment() {
        // Required empty public constructor
    }

    public static ClassFragment newInstance(String param1, String param2) {
        ClassFragment fragment = new ClassFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mApiService = UtilsApi.getAPIService();
        View view = inflater.inflate(R.layout.fragment_class, container, false);
        fab = view.findViewById(R.id.fab);
        recyclerView = view.findViewById(R.id.rv_kelas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getContext(), AddLabelQuiz.class);
                startActivity(intent);
//                startActivity(new Intent(QuizFragment.this, AddQuestionActivity.class));
            }
        });

        mApiService.kelasRequest().enqueue(new Callback<KelasResponse>() {
            @Override
            public void onResponse(Call<KelasResponse> call, Response<KelasResponse> response) {
                if(response.isSuccessful()){
                    KelasResponse kelasResponse = response.body();
                    ArrayList<KelasData> kelasData = kelasResponse.getData();
                    Log.e("getSuccess", "onFailure: ERROR > " + kelasResponse.getStatus().toString());
                    try{
                        adapter = new KelasAdapter(getContext(), kelasData);
                        recyclerView.setAdapter(adapter);
                    }catch (Exception err) {
                        Log.e(TAG, "Error INIII");
                        err.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<KelasResponse> call, Throwable t) {
                Log.e("debug", "onFailure: ERROR > " + t.toString());
            }
        });
        return view;
    }

    private void animateFab(){
        if(isOpen){
            fab.startAnimation(rotateBackward);
            fabAddClass.startAnimation(fabClose);
            fabAddClass.setClickable(false);
            isOpen = false;

        }
        else{
            fab.startAnimation(rotateForward);
            fabAddClass.startAnimation(fabOpen);
            fabAddClass.setClickable(true);
            isOpen = true;
        }
    }
}
