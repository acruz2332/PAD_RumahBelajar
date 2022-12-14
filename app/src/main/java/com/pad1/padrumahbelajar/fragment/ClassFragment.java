package com.pad1.padrumahbelajar.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.api.BaseApiService;
import com.pad1.padrumahbelajar.databinding.FragmentClassBinding;
import com.pad1.padrumahbelajar.Adapter.KelasAdapter;
import com.pad1.padrumahbelajar.quiz.AddLabelQuiz;


public class ClassFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FragmentClassBinding binding;
    FloatingActionButton fab, fabAddClass;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;
    boolean isOpen = false;
    Button btn;
    BaseApiService mApiService;
//    KelasData kelas;
    RecyclerView recyclerView;
    KelasAdapter kelasAdapter;


    private String mParam1;
    private String mParam2;

    public ClassFragment() {
        // Required empty public constructor
    }

    public static ClassFragment newInstance(String param1, String param2) {
        ClassFragment fragment = new ClassFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_class, container, false);
        fab = view.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getContext(), AddLabelQuiz.class);
                startActivity(intent);
//                startActivity(new Intent(QuizFragment.this, AddQuestionActivity.class));
            }
        });

        return view;
    }
}
