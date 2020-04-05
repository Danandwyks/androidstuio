package com.example.registeractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {
    private TextView nama, nim;
    private ImageView logout;
    private ImageView info;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        nama = findViewById(R.id.nama);
        nim = findViewById(R.id.nim);
logout=findViewById(R.id.logout);

        HashMap<String, String> user = sessionManager.getUserDetail();
        String mNama = user.get(sessionManager.NAMA);
        String mNim = user.get(sessionManager.NIM);

        nama.setText(mNama);
        nim.setText(mNim);

        //ImageView info = (ImageView) findViewById(R.id.info);
       // info.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {
              //  Intent i = new Intent(HomeActivity.this, MainActivity.class);
                //startActivity(i);

           // }
        //});
    }


    public void profil(View view) {
        startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
    }

    public void Matakuliah(View view) {
        startActivity(new Intent(HomeActivity.this, MataKuliahActivity.class));
    }

    public void infopoltek(View view) {
        startActivity(new Intent(HomeActivity.this, InfoGtActivity.class));
    }

    public void matakuliah1(View view) {
        startActivity(new Intent(HomeActivity.this, MataKuliahbenerActivity.class));
    }

    public void kondite(View view) { startActivity(new Intent(HomeActivity.this, KonditeActivity.class));
    }
}
