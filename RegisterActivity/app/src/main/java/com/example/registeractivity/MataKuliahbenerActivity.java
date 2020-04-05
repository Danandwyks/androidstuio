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


public class MataKuliahbenerActivity extends AppCompatActivity {
    private EditText tahunakademik;
    private Button btn_thnakademik;
    private TextView kdmk,namamk,sks,statusmk,dosen;
    SessionManager sessionManager;
    String getNim;
    private static final String TAG = ProfileActivity.class.getSimpleName();
    private static String URL_READ1 = "http://192.168.0.9/android_register_login/read_matakuliah.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mata_kuliahbener);
        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();
        tahunakademik = findViewById(R.id.tahunakademik);
        btn_thnakademik = findViewById(R.id.btn_thnakademik);
        kdmk = findViewById(R.id.kdmk);
        namamk = findViewById(R.id.namamk);
        statusmk = findViewById(R.id.statusmk);
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

                                    String skdmk = object.getString("kodemk").trim();
                                    String snamamk = object.getString("namamk").trim();
                                    String sstatus = object.getString("statusmk").trim();
                                    String sskks = object.getString("sks").trim();
                                    String sdosens = object.getString("dosen").trim();

                                    kdmk.setText(skdmk);
                                    namamk.setText(snamamk);
                                    statusmk.setText(sstatus);
                                    sks.setText(sskks);
                                    dosen.setText(sdosens);
                                }

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDialog.dismiss();
                            Toast.makeText(MataKuliahbenerActivity.this, "Error Reading Detail "+e.toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(MataKuliahbenerActivity.this, "Error Reading Detail "+error.toString(), Toast.LENGTH_SHORT).show();
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

