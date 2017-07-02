package com.zadi.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ImageView extends AppCompatActivity {

    private android.widget.ImageView imghp;
    private android.widget.ImageView img[];
    private TextView  txtmerk, txttipe, txtketerangan;
   // private RecyclerView lvhape;
    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    ArrayList<HashMap<String, String>> list_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview);

        String url = "http://192.168.43.203/app_blogvolley/getdata.php";

        imghp = (android.widget.ImageView)findViewById(R.id.imghp);
        txtmerk = (TextView)findViewById(R.id.txtmerk);
        txttipe = (TextView)findViewById(R.id.txttipe);
        txtketerangan = (TextView)findViewById(R.id.txtketerangan);

        requestQueue = Volley.newRequestQueue(ImageView.this);

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


                    }
                    //Memasukkan image ke imageview
                     Picasso.with(getApplicationContext())
                .load("http://192.168.43.53/app_blogvolley/img/" + list_data.get(2).get("gambar"))
                .error(R.drawable.no_available)
                .into(imghp);
                   /* Glide.with(getApplicationContext())
                            .load("http://192.168.43.53/app_blogvolley/img" + list_data.get(0).get("gambar"))
                            .crossFade()
                            .placeholder(R.mipmap.ic_launcher)
                            .into(imghp);*/
                    txtmerk.setText(list_data.get(3).get("merk"));
                    txttipe.setText(list_data.get(3).get("tipe"));
                    txtketerangan.setText(list_data.get(3).get("keterangan"));
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ImageView.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest);
    }
}