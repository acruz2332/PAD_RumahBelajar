package com.pad1.padrumahbelajar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pad1.padrumahbelajar.R;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class TutorialAdapter extends PagerAdapter {

    Context ctx;

    public TutorialAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        LayoutInflater layoutInflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_tutorial,container,false);

        ImageView img = view.findViewById(R.id.img);
        TextView tv1 = view.findViewById(R.id.tv1);
        TextView tv2 = view.findViewById(R.id.tv2);
        TextView tv3 = view.findViewById(R.id.tv3);
        Button btnGetStrt = view.findViewById(R.id.buttonGetstrt);
        SpringDotsIndicator springDotsIndicator = view.findViewById(R.id.spring_dots_indicator);

        switch (position)
        {
            case 0:
                img.setImageResource(R.drawable.imgtutor1);
                tv1.setText(R.string.tutorial_head);
                tv2.setText(R.string.tutorial_title);
                tv3.setText(R.string.tutorial_desc);
                springDotsIndicator.setVisibility(View.INVISIBLE);
                btnGetStrt.setVisibility(View.INVISIBLE);
                break;
            case 1:
                img.setImageResource(R.drawable.imgtutor2);
                tv1.setText(R.string.tutorial_head);
                tv2.setText(R.string.tutorial_title2);
                tv3.setText(R.string.tutorial_desc2);
                springDotsIndicator.setVisibility(View.INVISIBLE);
                btnGetStrt.setVisibility(View.INVISIBLE);
                break;
            case 2:
                img.setImageResource(R.drawable.imgtutor3);
                tv1.setText(R.string.tutorial_head);
                tv2.setText(R.string.tutorial_title2);
                tv3.setText(R.string.tutorial_desc3);
                springDotsIndicator.setVisibility(View.INVISIBLE);
                btnGetStrt.setVisibility(View.INVISIBLE);
                break;
        }
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
