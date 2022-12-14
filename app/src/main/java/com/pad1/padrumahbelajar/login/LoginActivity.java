package com.pad1.padrumahbelajar.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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



//
//        mApiService.kelasRequest()
//                .enqueue(new Callback<KelasResponse>() {
//                    @Override
//                    public void onResponse(Call<KelasResponse> call, Response<KelasResponse> response) {
//                        if (response.isSuccessful()) {
////                            loading.dismiss();
//                            KelasResponse kelasResponse = response.body();
//                            ArrayList<KelasData> kelasData = kelasResponse.getData();
//                            Log.e("getSuccess", "onFailure: ERROR > " + kelasResponse.getStatus().toString());
////                            for (int i = 0; i<kelasData.size();i++){
//                                String Kelas = kelasData.get(0).getNama_kelas().toString();
//                               Log.d("getsucces",Kelas);
//                                textViewLogin.setText(Kelas);
////                            }
//
//
////                            Toast.makeText(mContext, kelasResponse.getStatus(), Toast.LENGTH_SHORT).show();
//                        } else {
////                            loading.dismiss();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<KelasResponse> call, Throwable t) {
//                        Log.e("debug", "onFailure: ERROR > " + t.toString());
////                        Toast.makeText(mContext,"FAIL", Toast.LENGTH_SHORT).show();
//                        loading.dismiss();
//                    }
//                });


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
//                            loading.dismiss();
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

                                    // Jika login berhasil maka data nama yang ada di response API
                                    // akan diparsing ke activity selanjutnya.
                                    Intent intent = new Intent(getApplicationContext(), TutorialActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
//                                    Toast.makeText(mContext, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
//                                    String nama = jsonRESULTS.getJSONObject("user").getString("nama");
////                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NAMA, nama);
////                                    // Shared Pref ini berfungsi untuk menjadi trigger session login
////                                    sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
//                                    startActivity(new Intent(mContext, MainActivity.class)
//                                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
//                                    finish();
                                } else {
                                    // Jika login gagal
//                                    String error_message = jsonRESULTS.getString("error_msg");
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
//                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
//                        loading.dismiss();
                    }
                });

    }
    public static void logout(){
        sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN,false);

    }


}
