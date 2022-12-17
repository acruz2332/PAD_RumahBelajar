package com.pad1.padrumahbelajar.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pad1.padrumahbelajar.SharedPrefManager;
import com.pad1.padrumahbelajar.databinding.FragmentHomeBinding;
import com.pad1.padrumahbelajar.materi.DetailMateriActivity;
import com.pad1.padrumahbelajar.materi.MateriActivity;
import com.pad1.padrumahbelajar.materi.VideoActivity;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding viewBinding;
    TextView tvNama;
    SharedPrefManager sp;
    FloatingActionButton fab;
    public static final String MESSAGE_EXTRA = "MESSAGE_KEY";
    Animation fabOpen, fabClose, rotateForward, rotateBackward;


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

        viewBinding = FragmentHomeBinding.inflate(inflater, container, false);
        sp = new SharedPrefManager(this.getContext());
        viewBinding.tvNama.setText("Halo " + sp.getSpUsername());

        viewBinding.cvMateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MateriActivity.class));
            }
        });

        viewBinding.tvSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MateriActivity.class));
            }
        });

        viewBinding.cvPR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Fitur ini sedang dalam pengembangan", Toast.LENGTH_LONG).show();
            }
        });

        viewBinding.cvPK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Fitur ini sedang dalam pengembangan", Toast.LENGTH_LONG).show();
            }
        });

        viewBinding.cvSejarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), VideoActivity.class);
                String message = "sejarah";
                intent.putExtra(MESSAGE_EXTRA, message);
                startActivityForResult(intent, 1);
            }
        });

        viewBinding.cvMatematika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), VideoActivity.class);
                String message = "matematika";
                intent.putExtra(MESSAGE_EXTRA, message);
                startActivityForResult(intent, 1);
            }
        });

        viewBinding.cvKimia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), VideoActivity.class);
                String message = "kimia";
                intent.putExtra(MESSAGE_EXTRA, message);
                startActivityForResult(intent, 1);
            }
        });

        viewBinding.cvFisika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), VideoActivity.class);
                String message = "fisika";
                intent.putExtra(MESSAGE_EXTRA, message);
                startActivityForResult(intent, 1);
            }
        });

        viewBinding.cvAgama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), VideoActivity.class);
                String message = "agama";
                intent.putExtra(MESSAGE_EXTRA, message);
                startActivityForResult(intent, 1);
            }
        });




        return viewBinding.getRoot();
    }




}