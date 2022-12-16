package com.pad1.padrumahbelajar.materi;

import androidx.appcompat.app.AppCompatActivity;
import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.fragment.HomeFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AddLabelMateriActivity extends AppCompatActivity {

    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_label_materi);

        imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddLabelMateriActivity.this, HomeFragment.class));
            }
        });
    }
}