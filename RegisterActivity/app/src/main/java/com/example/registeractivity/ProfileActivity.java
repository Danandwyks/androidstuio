package com.example.registeractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {
    private EditText nim,nama,jeniskelamin,programstudi,tempatlahir,tanggallahir,password;
    SessionManager sessionManager;
    String getNim;private static final String TAG = ProfileActivity.class.getSimpleName();
    private static String URL_READ = "http://192.168.0.9/android_register_login/read_detail.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        nama = findViewById(R.id.nama);
        nim = findViewById(R.id.nim);
        jeniskelamin = findViewById(R.id.jeniskelamin);
        programstudi = findViewById(R.id.programstudi);
        tempatlahir = findViewById(R.id.tempatlahir);
        tanggallahir = findViewById(R.id.tanggallahir);
        password = findViewById(R.id.password);

        HashMap<String, String> user = sessionManager.getUserDetail();
        getNim = user.get(sessionManager.NIM);
    }
    private void getUserDetail(){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_READ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        Log.i(TAG, response.toString());

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("read");

                            if (success.equals("1")){

                                for (int i =0; i < jsonArray.length(); i++){

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String sNim = object.getString("nim").trim();
                                    String sNama = object.getString("nama").trim();
                                    String sjeniskelamin = object.getString("jeniskelamin").trim();
                                    String sProgramstudi = object.getString("programstudi").trim();
                                    String sTempatlahir = object.getString("tempatlahir").trim();
                                    String sTanggallahir = object.getString("tanggallahir").trim();
                                    String sPassword = object.getString("password").trim();

                                    nim.setText(sNim);
                                    nama.setText(sNama);
                                    jeniskelamin.setText(sjeniskelamin);
                                    programstudi.setText(sProgramstudi);
                                    tanggallahir.setText(sTanggallahir);
                                    tempatlahir.setText(sTempatlahir);
                                    password.setText(sPassword);
                                }

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDialog.dismiss();
                            Toast.makeText(ProfileActivity.this, "Error Reading Detail "+e.toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(ProfileActivity.this, "Error Reading Detail "+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String > params = new HashMap<>();
                params.put("nim", getNim);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getUserDetail();
    }
    }

