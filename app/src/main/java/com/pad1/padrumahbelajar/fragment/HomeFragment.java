package com.pad1.padrumahbelajar.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.materi.DetailMateriActivity;


public class HomeFragment extends Fragment {
    FloatingActionButton fab, fabAddClass;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;
    public static final String MESSAGE_EXTRA = "MESSAGE_KEY";

    public HomeFragment() {

    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view =  inflater.inflate(R.layout.fragment_home2, container, false);




        return view;
    }

    public void readMateriB1(View view){
        Intent intent = new Intent(getContext(), DetailMateriActivity.class);
        String message = "b1";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB2(View view){
        Intent intent = new Intent(getContext(), DetailMateriActivity.class);
        String message = "b2";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB3(View view){
        Intent intent = new Intent(getContext(), DetailMateriActivity.class);
        String message = "b3";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB4(View view){
        Intent intent = new Intent(getContext(), DetailMateriActivity.class);
        String message = "b4";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB5(View view){
        Intent intent = new Intent(getContext(), DetailMateriActivity.class);
        String message = "b5";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB6(View view){
        Intent intent = new Intent(getContext(), DetailMateriActivity.class);
        String message = "b6";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB7(View view){
        Intent intent = new Intent(getContext(), DetailMateriActivity.class);
        String message = "b7";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

}