package com.example.registeractivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE = 0;

    public static final String PREF_NAMA = "LOGIN";
    public static final String LOGIN = "IS_LOGIN";
    public static final String NAMA = "NAMA";
    public static final String NIM = "NIM";
    public static final String JENISKELAMIN = "JENISKELAMIN";
    public static final String TEMPATLAHIR = "TEMPATLAHIR";
    public static final String PROGRAMSTUDI = "PROGRAMSTUDI";
    public static final String TANGGALLAHIR = "TANGGALLAHIR";
    public static final String TAHUNMASUK = "TAHUNMASUK";
    public static final String STATUS = "STATUS";
    public static final String KELAS = "KELAS";
    public static final String PASSWORD = "PASSWORD";
    public static final String  PEMBIMBING = "PEMBIMBING";
    public static final String  UTS = "UTS";



    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAMA, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createSession(String nama, String nim){
        editor.putBoolean(LOGIN, true);
        editor.putString(NAMA, nama);
        editor.putString(NIM, nim);



        editor.apply();

    }

    public boolean isLogin(){
        return sharedPreferences.getBoolean(LOGIN, false);
    }
    public void checkLogin(){
        if (!this.isLogin()){
            Intent i = new Intent(context, LoginActivity.class);
            context.startActivity(i);
            ((HomeActivity) context).finish();
        }
    }

    public HashMap<String, String> getUserDetail(){
        HashMap<String, String> user = new HashMap<>();
        user.put(NAMA, sharedPreferences.getString(NAMA, null));
        user.put(NIM, sharedPreferences.getString(NIM, null));
        user.put(JENISKELAMIN, sharedPreferences.getString(JENISKELAMIN, null));
        user.put(STATUS, sharedPreferences.getString(STATUS, null));
        user.put(TEMPATLAHIR, sharedPreferences.getString(TEMPATLAHIR, null));
        user.put(PROGRAMSTUDI, sharedPreferences.getString(PROGRAMSTUDI, null));
        user.put(TANGGALLAHIR, sharedPreferences.getString(TANGGALLAHIR, null));
        user.put(TAHUNMASUK, sharedPreferences.getString(TAHUNMASUK, null));
        user.put(KELAS, sharedPreferences.getString(KELAS, null));
        user.put(PASSWORD, sharedPreferences.getString(PASSWORD, null));
        user.put(PEMBIMBING, sharedPreferences.getString(PEMBIMBING, null));
        user.put(UTS, sharedPreferences.getString(UTS, null));
        return user;
    }

    public void  logout(){
        editor.clear();
        editor.commit();
        Intent i = new Intent(context, LoginActivity.class);
        context.startActivity(i);
        ((HomeActivity) context).finish();

    }
}
