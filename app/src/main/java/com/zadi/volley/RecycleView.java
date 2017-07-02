package com.zadi.volley;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class RecycleView extends AppCompatActivity {

    private ProgressDialog pDialog;
    private ImageView imghp;
    private TextView  txtmerk, txttipe, txtketerangan;
    private RecyclerView lvhape;
    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    ArrayList<HashMap<String, String>> list_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        String url = "http://192.168.43.228/app_blogvolley/getdata.php";
        lvhape = (RecyclerView)findViewById(R.id.lvhape);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        lvhape.setLayoutManager(llm);
       /* imghp = (ImageView)findViewById(R.id.imghp);
        txtmerk = (TextView)findViewById(R.id.txtmerk);
        txttipe = (TextView)findViewById(R.id.txttipe);
        txtketerangan = (TextView)findViewById(R.id.txtketerangan);*/
        requestQueue = Volley.newRequestQueue(RecycleView.this);
        list_data = new ArrayList<HashMap<String, String>>();


        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                Log.d("response ", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("handphone");
                    for (int a = 0; a < jsonArray.length(); a++){
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("id", json.getString("idhp"));
                        map.put("merk", json.getString("merk"));
                        map.put("tipe", json.getString("tipe"));
                        map.put("gambar", json.getString("gambar"));
                        map.put("keterangan", json.getString("keterangan"));
                        list_data.add(map);
                        AdapterList adapter =  new AdapterList(RecycleView.this, list_data);
                        lvhape.setAdapter(adapter);

                    }
                    }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RecycleView.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest);
    }
}