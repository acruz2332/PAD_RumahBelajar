package com.pad1.padrumahbelajar;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

public class SharedPrefManager {
    public static final String SP_RUMAH_BELAJAR="spRumahBelajar";
    public static final String SP_NAMA ="spNama";
    public static final String SP_USERNAME = "spUsername";
    public static final String SP_TOKEN = "spToken";
    public static final String SP_SUDAH_LOGIN = "spSudahLogin";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;
    private static SharedPrefManager instance = null;

    public SharedPrefManager(Context context){
        sp = context.getSharedPreferences(SP_RUMAH_BELAJAR, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }



    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }
    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();

    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

//    public static SharedPrefManager getInstance() {
//        if (instance == null) {
//            instance = new SharedPrefManager();
//        }
//        return instance;
//    }

    public void clearSharedPref(@NonNull Context context) {
        SharedPreferences pref = context.getSharedPreferences(SP_NAMA, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }

    public Boolean getSPLogout(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }

    public String getSpNama(){
        return sp.getString(SP_NAMA,"");
    }

    public String getSpUsername(){
        return sp.getString(SP_USERNAME,"");
    }

    public String getSpToken(){
        return sp.getString(SP_TOKEN,"");
    }

    public Boolean getSPSudahLogin(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }

}
