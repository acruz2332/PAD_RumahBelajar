package com.pad1.padrumahbelajar.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.pad1.padrumahbelajar.fragment.MainActivity;
import com.pad1.padrumahbelajar.R;

public class TutorialActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial3);

        findViewById(R.id.buttonGetstrt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorialActivity3.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }



}