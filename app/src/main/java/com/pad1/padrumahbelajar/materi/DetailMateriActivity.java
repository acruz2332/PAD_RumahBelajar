package com.pad1.padrumahbelajar.materi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.pad1.padrumahbelajar.R;
//import com.github.barteksc.pdfviewer.PDFView;
import com.pad1.padrumahbelajar.fragment.HomeFragment;

import java.util.Objects;

public class DetailMateriActivity extends AppCompatActivity {

//    private PDFView pdf_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_materi);

        Intent intent = getIntent();
        String message = intent.getStringExtra(HomeFragment.MESSAGE_EXTRA);
//
//        if(Objects.equals(message, "b1")){
//            pdf_view = findViewById(R.id.pdfView);
//            pdf_view.fromAsset("bab1.pdf")
//                    .enableSwipe(true)
//                    .enableDoubletap(false)
//                    .load();
//        } else if (Objects.equals(message, "b2")){
//            pdf_view = findViewById(R.id.pdfView);
//            pdf_view.fromAsset("bab2.pdf")
//                    .enableSwipe(true)
//                    .enableDoubletap(false)
//                    .load();
//        } else if (Objects.equals(message, "b3")) {
//            pdf_view = findViewById(R.id.pdfView);
//            pdf_view.fromAsset("bab3.pdf")
//                    .enableSwipe(true)
//                    .enableDoubletap(false)
//                    .load();
//        } else if (Objects.equals(message, "b4")) {
//            pdf_view = findViewById(R.id.pdfView);
//            pdf_view.fromAsset("bab4.pdf")
//                    .enableSwipe(true)
//                    .enableDoubletap(false)
//                    .load();
//        }else if (Objects.equals(message, "b5")) {
//            pdf_view = findViewById(R.id.pdfView);
//            pdf_view.fromAsset("bab5.pdf")
//                    .enableSwipe(true)
//                    .enableDoubletap(false)
//                    .load();
//        }else if (Objects.equals(message, "b6")) {
//            pdf_view = findViewById(R.id.pdfView);
//            pdf_view.fromAsset("bab6.pdf")
//                    .enableSwipe(true)
//                    .enableDoubletap(false)
//                    .load();
//        }else if (Objects.equals(message, "b7")) {
//            pdf_view = findViewById(R.id.pdfView);
//            pdf_view.fromAsset("bab7.pdf")
//                    .enableSwipe(true)
//                    .enableDoubletap(false)
//                    .load();
//        } else {
//            Toast.makeText(DetailMateriActivity.this, "Maaf Materi Tidak Tersedia", Toast.LENGTH_LONG).show();
//        }


    }


}