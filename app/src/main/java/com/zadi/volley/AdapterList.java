package com.zadi.volley;

/**
 * Created by Muh. Zadi on 6/9/2017.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder> {
    Context context;
    ArrayList<HashMap<String, String >> list_data;
    public AdapterList(RecycleView mainActivity, ArrayList<HashMap<String, String >>list_data){
        this.context = mainActivity;
        this.list_data = list_data;
    }

    @Override
    public AdapterList.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_images, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterList.ViewHolder holder, int position) {
       /* Picasso.with(context.getApplicationContext())
                .load("http://200.200.200.197/app_blogvolley/img/" + list_data.get(position).get("gambar"))
                .error(R.drawable.no_available)
                .into(holder.imghape);*/
        Glide.with(context)
                .load("http://192.168.43.203/app_blogvolley/img/" + list_data.get(position).get("gambar"))
                .crossFade()
                .placeholder(R.drawable.no_available)
                .into(holder.imghape);
       // holder.txthape.setText(list_data.get(position).get("merk"));
        
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
       // TextView txthape;
        ImageView imghape;

        public ViewHolder(View itemView) {
            super(itemView);

         // txthape = (TextView) itemView.findViewById(R.id.txthape);
            imghape = (ImageView) itemView.findViewById(R.id.imghp);
        }
    }
}