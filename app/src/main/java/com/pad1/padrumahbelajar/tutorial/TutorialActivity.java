package com.pad1.padrumahbelajar.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pad1.padrumahbelajar.R;

public class TutorialActivity extends AppCompatActivity {

    Button buttonGetstrt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        buttonGetstrt = findViewById(R.id.buttonGetstrt);

        buttonGetstrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorialActivity.this, TutorialActivity2.class);
                startActivity(intent);
            }
        });
    }



}