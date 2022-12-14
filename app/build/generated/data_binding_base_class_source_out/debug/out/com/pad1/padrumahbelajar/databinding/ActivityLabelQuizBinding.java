// Generated by view binder compiler. Do not edit!
package com.pad1.padrumahbelajar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pad1.padrumahbelajar.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLabelQuizBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final FloatingActionButton fab;

  @NonNull
  public final ImageView imageViewQuizOption;

  @NonNull
  public final RecyclerView rv1;

  @NonNull
  public final TextView tv1;

  @NonNull
  public final TextView tv2;

  private ActivityLabelQuizBinding(@NonNull ConstraintLayout rootView,
      @NonNull FloatingActionButton fab, @NonNull ImageView imageViewQuizOption,
      @NonNull RecyclerView rv1, @NonNull TextView tv1, @NonNull TextView tv2) {
    this.rootView = rootView;
    this.fab = fab;
    this.imageViewQuizOption = imageViewQuizOption;
    this.rv1 = rv1;
    this.tv1 = tv1;
    this.tv2 = tv2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLabelQuizBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLabelQuizBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_label_quiz, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLabelQuizBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.fab;
      FloatingActionButton fab = ViewBindings.findChildViewById(rootView, id);
      if (fab == null) {
        break missingId;
      }

      id = R.id.imageViewQuizOption;
      ImageView imageViewQuizOption = ViewBindings.findChildViewById(rootView, id);
      if (imageViewQuizOption == null) {
        break missingId;
      }

      id = R.id.rv1;
      RecyclerView rv1 = ViewBindings.findChildViewById(rootView, id);
      if (rv1 == null) {
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

      return new ActivityLabelQuizBinding((ConstraintLayout) rootView, fab, imageViewQuizOption,
          rv1, tv1, tv2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
