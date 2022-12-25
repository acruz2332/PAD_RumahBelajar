package com.pad1.padrumahbelajar.tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pad1.padrumahbelajar.Adapter.TutorialAdapter;
import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.fragment.MainActivity;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

public class TutorialActivity extends AppCompatActivity {

    Button buttonGetstrt;
    public static ViewPager viewPager;
    TutorialAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);


        buttonGetstrt = findViewById(R.id.buttonGetstrt);

        buttonGetstrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorialActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        SpringDotsIndicator springDotsIndicator = findViewById(R.id.spring_dots_indicator);

        //Init dotIndicator and PagerAdapter
        viewPager = findViewById(R.id.viewPager);
        adapter = new TutorialAdapter(this);
        viewPager.setAdapter(adapter);
        springDotsIndicator.setViewPager(viewPager);
    }



}