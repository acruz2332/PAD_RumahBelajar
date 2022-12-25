package com.pad1.padrumahbelajar.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.pad1.padrumahbelajar.api.BaseApiService;
import com.pad1.padrumahbelajar.fragment.MainActivity;
import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.SharedPrefManager;
import com.pad1.padrumahbelajar.api.UtilsApi;
import com.pad1.padrumahbelajar.model.KelasData;
import com.pad1.padrumahbelajar.model.KelasResponse;
import com.pad1.padrumahbelajar.tutorial.TutorialActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    public boolean isLogin;
    EditText editTextUsrnm;
    EditText editTextPw;
    Context mContext;
    BaseApiService mApiService;
    ProgressDialog loading;
    boolean passwordVisible;
    TextView textViewSignup;
    TextView textViewLogin;
    public static SharedPrefManager sharedPrefManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login);
        mApiService = UtilsApi.getAPIService();
        textViewLogin = findViewById(R.id.textViewlgn);

        editTextPw = findViewById(R.id.editTextPw);
        editTextUsrnm = findViewById(R.id.editTextUsrnm);
        textViewSignup = findViewById(R.id.textViewSignup);
        sharedPrefManager = new SharedPrefManager(this);

        textViewSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        editTextPw.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=editTextPw.getRight()-editTextPw.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = editTextPw.getSelectionEnd();
                        if(passwordVisible ){
                            editTextPw.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                            editTextPw.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;

                        }else{
                            editTextPw.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            editTextPw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        editTextPw.setSelection(selection);
                        return true;
                    }
                }

                return false;
            }
        });






        if (sharedPrefManager.getSPSudahLogin()){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }





    }




    public void loginBtn(View view) {
        requestLogin();
    }

    private void requestLogin() {
        mApiService.loginRequest(editTextUsrnm.getText().toString(), editTextPw.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {

                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("status").equals("success")) {

                                    String role = jsonRESULTS.getString("role");
                                    Log.d("role",role);
                                    String nama = jsonRESULTS.getString("nama");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NAMA,nama);
                                    String userName = jsonRESULTS.getString("username");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_USERNAME, userName);
                                    String token = jsonRESULTS.getString("token");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_TOKEN,token);
                                    sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN,true);

                                    Intent intent = new Intent(getApplicationContext(), TutorialActivity.class);
                                    startActivity(intent);
                                    finish();
                                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();


                                } else {

                                    Toast.makeText(getApplicationContext(), "GAGAL LOGIN", Toast.LENGTH_SHORT).show();
                                    String msg = jsonRESULTS.getString("message");
                                    AlertDialog alertDialog = new AlertDialog.Builder(LoginActivity.this).create();
                                    alertDialog.setTitle("Failed to log in");
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
                                Toast.makeText(getApplicationContext(), "GAGAL LOGIN", Toast.LENGTH_SHORT).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());

                    }
                });

    }
    public void logout(){
        sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
    }
}
