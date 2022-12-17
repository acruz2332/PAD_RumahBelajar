// Generated by view binder compiler. Do not edit!
package com.pad1.padrumahbelajar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.pad1.padrumahbelajar.R;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityTutorialBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonGetstrt;

  @NonNull
  public final ImageView img;

  @NonNull
  public final SpringDotsIndicator springDotsIndicator;

  @NonNull
  public final TextView tv1;

  @NonNull
  public final TextView tv2;

  @NonNull
  public final TextView tv3;

  @NonNull
  public final ViewPager viewPager;

  private ActivityTutorialBinding(@NonNull ConstraintLayout rootView, @NonNull Button buttonGetstrt,
      @NonNull ImageView img, @NonNull SpringDotsIndicator springDotsIndicator,
      @NonNull TextView tv1, @NonNull TextView tv2, @NonNull TextView tv3,
      @NonNull ViewPager viewPager) {
    this.rootView = rootView;
    this.buttonGetstrt = buttonGetstrt;
    this.img = img;
    this.springDotsIndicator = springDotsIndicator;
    this.tv1 = tv1;
    this.tv2 = tv2;
    this.tv3 = tv3;
    this.viewPager = viewPager;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTutorialBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTutorialBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_tutorial, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTutorialBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonGetstrt;
      Button buttonGetstrt = ViewBindings.findChildViewById(rootView, id);
      if (buttonGetstrt == null) {
        break missingId;
      }

      id = R.id.img;
      ImageView img = ViewBindings.findChildViewById(rootView, id);
      if (img == null) {
        break missingId;
      }

      id = R.id.spring_dots_indicator;
      SpringDotsIndicator springDotsIndicator = ViewBindings.findChildViewById(rootView, id);
      if (springDotsIndicator == null) {
        break missingId;
      }

      id = R.id.tv1;
      TextView tv1 = ViewBindings.findChildViewById(rootView, id);
      if (tv1 == null) {
        break missingId;
      }

      id = R.id.tv2;
      TextView tv2 = ViewBindings.findChildViewById(rootView, id);
      if (tv2 == null) {
        break missingId;
      }

      id = R.id.tv3;
      TextView tv3 = ViewBindings.findChildViewById(rootView, id);
      if (tv3 == null) {
        break missingId;
      }

      id = R.id.viewPager;
      ViewPager viewPager = ViewBindings.findChildViewById(rootView, id);
      if (viewPager == null) {
        break missingId;
      }

      return new ActivityTutorialBinding((ConstraintLayout) rootView, buttonGetstrt, img,
          springDotsIndicator, tv1, tv2, tv3, viewPager);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
