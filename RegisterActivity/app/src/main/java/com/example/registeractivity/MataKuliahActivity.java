package com.example.registeractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class MataKuliahActivity extends AppCompatActivity {
    private EditText tahunakademik;
    private Button btn_thnakademik;
    private TextView uts,uas,tugas,kuis,mk,sks,dosen;
    SessionManager sessionManager;
    String getNim;private static final String TAG = ProfileActivity.class.getSimpleName();
    private static String URL_READ1 = "http://192.168.0.9/android_register_login/read_matakuliah.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_mata_kuliah);
            sessionManager = new SessionManager(this);
            sessionManager.checkLogin();

        tahunakademik = findViewById(R.id.tahunakademik);
        btn_thnakademik = findViewById(R.id.btn_thnakademik);
        uts = findViewById(R.id.uts);
        uas = findViewById(R.id.uas);
        tugas = findViewById(R.id.tugas);
        kuis = findViewById(R.id.kuis);
        mk = findViewById(R.id.mk);
        sks = findViewById(R.id.sks);
        dosen = findViewById(R.id.dosen);

        HashMap<String, String> user = sessionManager.getUserDetail();
        getNim = user.get(sessionManager.NIM);
    }
    private void getUserDetail(){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_READ1,
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

                                    String suts = object.getString("uts").trim();
                                    String suas = object.getString("uas").trim();
                                    String stugas = object.getString("tugas").trim();
                                    String skuis = object.getString("kuis").trim();
                                    String smk = object.getString("namamk").trim();
                                    String ssks = object.getString("sks").trim();
                                    String sdosen = object.getString("dosen").trim();

                                    uts.setText(suts);
                                    uas.setText(suas);
                                    tugas.setText(stugas);
                                    kuis.setText(skuis);
                                    mk.setText(smk);
                                    sks.setText(ssks);
                                    dosen.setText(sdosen);
                                }

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDialog.dismiss();
                            Toast.makeText(MataKuliahActivity.this, "Error Reading Detail "+e.toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(MataKuliahActivity.this, "Error Reading Detail "+error.toString(), Toast.LENGTH_SHORT).show();
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
