package com.pad1.padrumahbelajar.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.SharedPrefManager;
import com.pad1.padrumahbelajar.login.LoginActivity;


public class ProfileFragment extends Fragment {


    Button btnLogout;
    TextView token, username;
    SharedPrefManager sp;


    public ProfileFragment() {

    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        btnLogout = view.findViewById(R.id.btn_logout);
        sp = new SharedPrefManager(this.getContext());
        token = view.findViewById(R.id.tvtoken);
        username = view.findViewById(R.id.tvusername);


        token.setText(sp.getSpToken());
        username.setText(sp.getSpUsername());


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginActivity activity = new LoginActivity();
                activity.logout();
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
                activity.finish();
                System.exit(0);
            }
        });
        return view;
    }
}

