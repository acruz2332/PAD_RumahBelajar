// Generated by view binder compiler. Do not edit!
package com.pad1.padrumahbelajar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.pad1.padrumahbelajar.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonLgn;

  @NonNull
  public final EditText editTextPw;

  @NonNull
  public final EditText editTextUsrnm;

  @NonNull
  public final TextView forgetPw;

  @NonNull
  public final ImageView imageViewlgn;

  @NonNull
  public final TextView textViewDont;

  @NonNull
  public final TextView textViewSignup;

  @NonNull
  public final TextView textViewlgn;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView, @NonNull Button buttonLgn,
      @NonNull EditText editTextPw, @NonNull EditText editTextUsrnm, @NonNull TextView forgetPw,
      @NonNull ImageView imageViewlgn, @NonNull TextView textViewDont,
      @NonNull TextView textViewSignup, @NonNull TextView textViewlgn) {
    this.rootView = rootView;
    this.buttonLgn = buttonLgn;
    this.editTextPw = editTextPw;
    this.editTextUsrnm = editTextUsrnm;
    this.forgetPw = forgetPw;
    this.imageViewlgn = imageViewlgn;
    this.textViewDont = textViewDont;
    this.textViewSignup = textViewSignup;
    this.textViewlgn = textViewlgn;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonLgn;
      Button buttonLgn = ViewBindings.findChildViewById(rootView, id);
      if (buttonLgn == null) {
        break missingId;
      }

      id = R.id.editTextPw;
      EditText editTextPw = ViewBindings.findChildViewById(rootView, id);
      if (editTextPw == null) {
        break missingId;
      }

      id = R.id.editTextUsrnm;
      EditText editTextUsrnm = ViewBindings.findChildViewById(rootView, id);
      if (editTextUsrnm == null) {
        break missingId;
      }

      id = R.id.forgetPw;
      TextView forgetPw = ViewBindings.findChildViewById(rootView, id);
      if (forgetPw == null) {
        break missingId;
      }

      id = R.id.imageViewlgn;
      ImageView imageViewlgn = ViewBindings.findChildViewById(rootView, id);
      if (imageViewlgn == null) {
        break missingId;
      }

      id = R.id.textViewDont;
      TextView textViewDont = ViewBindings.findChildViewById(rootView, id);
      if (textViewDont == null) {
        break missingId;
      }

      id = R.id.textViewSignup;
      TextView textViewSignup = ViewBindings.findChildViewById(rootView, id);
      if (textViewSignup == null) {
        break missingId;
      }

      id = R.id.textViewlgn;
      TextView textViewlgn = ViewBindings.findChildViewById(rootView, id);
      if (textViewlgn == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ConstraintLayout) rootView, buttonLgn, editTextPw,
          editTextUsrnm, forgetPw, imageViewlgn, textViewDont, textViewSignup, textViewlgn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
