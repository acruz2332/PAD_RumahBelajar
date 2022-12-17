package com.pad1.padrumahbelajar.materi;

import androidx.appcompat.app.AppCompatActivity;
import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.databinding.ActivityMateriBinding;
import com.pad1.padrumahbelajar.databinding.FragmentHomeBinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MateriActivity extends AppCompatActivity {

    private ActivityMateriBinding viewBinding;
    public static final String MESSAGE_EXTRA = "MESSAGE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMateriBinding.inflate(getLayoutInflater());
        View view = viewBinding.getRoot();
        setContentView(view);

        viewBinding.llBab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readMateriB1();
            }
        });

        viewBinding.llBab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readMateriB2();
            }
        });

        viewBinding.llBab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readMateriB3();
            }
        });

        viewBinding.llBab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readMateriB4();
            }
        });

        viewBinding.llBab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readMateriB5();
            }
        });

        viewBinding.llBab6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readMateriB6();
            }
        });

        viewBinding.llBab7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readMateriB7();
            }
        });

    }

    public void readMateriB1() {
        Intent intent = new Intent(MateriActivity.this, DetailMateriActivity.class);
        String message = "b1";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB2() {
        Intent intent = new Intent(MateriActivity.this, DetailMateriActivity.class);
        String message = "b2";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB3() {
        Intent intent = new Intent(MateriActivity.this, DetailMateriActivity.class);
        String message = "b3";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB4() {
        Intent intent = new Intent(MateriActivity.this, DetailMateriActivity.class);
        String message = "b4";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB5() {
        Intent intent = new Intent(MateriActivity.this, DetailMateriActivity.class);
        String message = "b5";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB6() {
        Intent intent = new Intent(MateriActivity.this, DetailMateriActivity.class);
        String message = "b6";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB7() {
        Intent intent = new Intent(MateriActivity.this, DetailMateriActivity.class);
        String message = "b7";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

}