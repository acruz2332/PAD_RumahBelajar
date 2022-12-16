package com.pad1.padrumahbelajar.fragment;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.databinding.FragmentHome2Binding;
import com.pad1.padrumahbelajar.materi.AddLabelMateriActivity;
import com.pad1.padrumahbelajar.materi.DetailMateriActivity;


public class HomeFragment extends Fragment {

    private FragmentHome2Binding viewBinding;


    FloatingActionButton fab, fabAddClass;
    ImageView imgBack;
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
        viewBinding = FragmentHome2Binding.inflate(inflater, container, false);

        viewBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), AddLabelMateriActivity.class));
            }
        });

        viewBinding.llBab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readMateriB1(view);
            }
        });

        viewBinding.llBab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readMateriB2(view);
            }
        });


        return viewBinding.getRoot();
    }

    public void readMateriB1(View view) {
        Intent intent = new Intent(getContext(), DetailMateriActivity.class);
        String message = "b1";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB2(View view) {
        Intent intent = new Intent(getContext(), DetailMateriActivity.class);
        String message = "b2";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB3(View view) {
        Intent intent = new Intent(getContext(), DetailMateriActivity.class);
        String message = "b3";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB4(View view) {
        Intent intent = new Intent(getContext(), DetailMateriActivity.class);
        String message = "b4";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB5(View view) {
        Intent intent = new Intent(getContext(), DetailMateriActivity.class);
        String message = "b5";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB6(View view) {
        Intent intent = new Intent(getContext(), DetailMateriActivity.class);
        String message = "b6";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB7(View view) {
        Intent intent = new Intent(getContext(), DetailMateriActivity.class);
        String message = "b7";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

}