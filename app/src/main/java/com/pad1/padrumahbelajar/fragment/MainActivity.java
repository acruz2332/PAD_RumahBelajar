package com.pad1.padrumahbelajar.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.databinding.ActivityMainBinding;
import com.pad1.padrumahbelajar.quiz.AddQuestionActivity;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab, fabAddClass;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;


    boolean isOpen = false;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());
//
        fab = findViewById(R.id.fab);
//        fabAddClass = findViewById(R.id.fabAddClass);
//
//        fabOpen = AnimationUtils.loadAnimation(this,R.anim.tab_open);
//        fabClose = AnimationUtils.loadAnimation(this,R.anim.tab_close);
//
//        rotateForward = AnimationUtils.loadAnimation(this,R.anim.rotate_forward);
//        rotateBackward = AnimationUtils.loadAnimation(this,R.anim.rotate_backward);
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                animateFab();
//
//            }
//        });
//        fabAddClass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"CLICKED!!",Toast.LENGTH_SHORT).show();
//            }
//        });

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =  new Intent(MainActivity.this, AddQuestionActivity.class);
//                startActivity(intent);
//            }
//        });

        binding.bottomNavigationView.setOnItemSelectedListener(item ->{
            switch (item.getItemId()){
                case R.id.materi:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.kelas:
                    replaceFragment(new ClassFragment());
                    break;
                case R.id.quiz:
                    replaceFragment(new QuizFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;
            }
            return true;
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_nav_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.materi:
                replaceFragment(new HomeFragment());
                break;
            case R.id.kelas:
                replaceFragment(new ClassFragment());
                break;
            case R.id.quiz:
                replaceFragment(new QuizFragment());
                break;
            case R.id.profile:
                replaceFragment(new ProfileFragment());
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout1, fragment);
        fragmentTransaction.commit();
    }


//    private void animateFab(){
//        if(isOpen){
//            fab.startAnimation(rotateBackward);
//            fabAddClass.startAnimation(fabClose);
//            fabAddClass.setClickable(false);
//            isOpen = false;
//
//        }
//        else{
//            fab.startAnimation(rotateForward);
//            fabAddClass.startAnimation(fabOpen);
//            fabAddClass.setClickable(true);
//            isOpen = true;
//        }
//    }






}