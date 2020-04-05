package com.example.registeractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
private EditText nim,nama,jeniskelamin,programstudi,tempatlahir,tanggallahir,tahunmasuk,status,kelas,password,pembimbing;
private Button btn_regist;
private ProgressBar loading;
private static String URL_REGIST="http://192.168.0.9/android_register_login/register.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loading=findViewById(R.id.loading);
        nama=findViewById(R.id.nama);
        nim=findViewById(R.id.nim);
        jeniskelamin=findViewById(R.id.jeniskelamin);
        programstudi=findViewById(R.id.programstudi);
        tempatlahir=findViewById(R.id.tempatlahir);
        tanggallahir=findViewById(R.id.tanggallahir);
        tahunmasuk=findViewById(R.id.tahunmasuk);
        status=findViewById(R.id.status);
        kelas=findViewById(R.id.kelas);
        pembimbing=findViewById(R.id.pembimbing);
        password=findViewById(R.id.password);
        btn_regist=findViewById(R.id.btn_regist);
        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Regist();
            }
        });



    }
    private void Regist(){
        loading.setVisibility(View.VISIBLE);
        btn_regist.setVisibility(View.GONE);
        final String nama = this.nama.getText().toString().trim();
        final String nim = this.nim.getText().toString().trim();
        final String jeniskelamin = this.jeniskelamin.getText().toString().trim();
        final String programstudi = this.programstudi.getText().toString().trim();
        final String tempatlahir = this.tempatlahir.getText().toString().trim();
        final String tanggallahir = this.tanggallahir.getText().toString().trim();
        final String tahunmasuk = this.tahunmasuk.getText().toString().trim();
        final String status = this.status.getText().toString().trim();
        final String kelas = this.kelas.getText().toString().trim();
        final String pembimbing = this.pembimbing.getText().toString().trim();
        final String password = this.password.getText().toString().trim();

        StringRequest stringRequest =new StringRequest(Request.Method.POST,
                URL_REGIST,new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    if (success.equals("1")) {
                        Toast.makeText(MainActivity.this, "regis ok", Toast.LENGTH_SHORT);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "regis eror"+e.toString(),Toast.LENGTH_SHORT);
loading.setVisibility(View.GONE);
btn_regist.setVisibility(View.VISIBLE);
                }
            }}
               ,new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "regis eror"+error.toString(),Toast.LENGTH_SHORT);
                loading.setVisibility(View.GONE);
                btn_regist.setVisibility(View.VISIBLE);
            }
        })
        {
            @Override
            protected Map<String ,String> getParams() throws AuthFailureError{
              Map<String,String >params =new HashMap<>();
              params.put("nim",nim);
                params.put("nama",nama);
                params.put("jeniskelamin",jeniskelamin);
                params.put("programstudi",programstudi);
                params.put("tempatlahir",tempatlahir);
                params.put("tanggallahir",tanggallahir);
                params.put("tahunmasuk",tahunmasuk);
                params.put("status",status);
                params.put("kelas",kelas);
                params.put("password",password);
                params.put("pembimbing",pembimbing);
               return params;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
