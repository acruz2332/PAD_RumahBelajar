package com.pad1.padrumahbelajar.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.pad1.padrumahbelajar.api.BaseApiService;
import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.api.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    TextView tvlogin;
    String role;
    EditText editTextName, editTextEmail, editTextUsername, editTextPasswordRegister, editTextConfirm;
    RadioButton radioButton1, radioButton2;
    RadioGroup radioGroupRole;
    BaseApiService mApiService;
    ProgressDialog loading;
    Button buttonRegister;
    boolean passwordVisible;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editTextName = findViewById(R.id.editTextName);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPasswordRegister = findViewById(R.id.editTextPasswordRegister);
        editTextConfirm = findViewById(R.id.editTextConfirm);

         role = "";

         buttonRegister = findViewById(R.id.buttonRegister);

        radioGroupRole = findViewById(R.id.radioGroupRole);

        tvlogin = findViewById(R.id.textViewlogin);
        mApiService = UtilsApi.getAPIService();

        radioGroupRole.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton: role = "guru";
                        Toast.makeText(getApplicationContext(), role, Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.radioButton2: role = "murid";
                        Toast.makeText(getApplicationContext(), role, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        });

        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestSignup();
            }
        });

        editTextPasswordRegister.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2;
                if(event.getAction()== MotionEvent.ACTION_UP){
                    if(event.getRawX()>=editTextPasswordRegister.getRight()-editTextPasswordRegister.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = editTextPasswordRegister.getSelectionEnd();
                        if(passwordVisible ){
                            editTextPasswordRegister.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                            editTextPasswordRegister.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;

                        }else{
                            editTextPasswordRegister.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            editTextPasswordRegister.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        editTextPasswordRegister.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        editTextConfirm.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2;
                if(event.getAction()== MotionEvent.ACTION_UP){
                    if(event.getRawX()>=editTextConfirm.getRight()-editTextConfirm.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = editTextConfirm.getSelectionEnd();
                        if(passwordVisible ){
                            editTextConfirm.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                            editTextConfirm.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;

                        }else{
                            editTextConfirm.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            editTextConfirm.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible= true;
                        }
                        editTextConfirm.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

    }



    private void requestSignup(){
        mApiService.registerRequest(editTextName.getText().toString(), editTextEmail.getText().toString(),
                editTextUsername.getText().toString(), editTextPasswordRegister.getText().toString(), editTextConfirm.getText().toString(),
                role).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
//                            loading.dismiss();
                    try {
                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        if (jsonRESULTS.getString("status").equals("success")) {
                            AlertDialog alertDialog = new AlertDialog.Builder(SignUpActivity.this).create();
                            alertDialog.setMessage("Register Berhasil!");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                            startActivity(intent);
                                        }
                                    });
                            alertDialog.show();

                        } else {
                            Toast.makeText(getApplicationContext(), "GAGAL REGISTER", Toast.LENGTH_SHORT).show();
                            String msg = jsonRESULTS.getString("message");
                            AlertDialog alertDialog = new AlertDialog.Builder(SignUpActivity.this).create();
                            alertDialog.setTitle("Failed to register");
                            alertDialog.setMessage(msg);
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                            alertDialog.show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "GAGAL REGISTER", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
//                            loading.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("debug", "onFailure: ERROR > " + t.toString());
                loading.dismiss();
            }
        });
    }
}