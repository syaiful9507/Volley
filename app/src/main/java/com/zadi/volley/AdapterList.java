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
    ImageSwitcher imageSwitcher;
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
    public void onBindViewHolder(AdapterList.ViewHolder holder, final int position) {
       /* Picasso.with(context.getApplicationContext())
                .load("http://200.200.200.197/app_blogvolley/img/" + list_data.get(position).get("gambar"))
                .error(R.drawable.no_available)
                .into(holder.imghape);*/
        Glide.with(context)
                .load("http://192.168.43.228/app_blogvolley/img/" + list_data.get(position).get("gambar"))
                .crossFade()
                .placeholder(R.drawable.no_available)
                .into(holder.imghape);
       // holder.txthape.setText(list_data.get(position).get("merk"));
        /*holder.imghape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "satu" +list_data.get(position), Toast.LENGTH_SHORT).show();
               // imageSwitcher.setImageResource(list_data.get(position));

            }
        });*/
        HashMap<String, String> data = list_data.get(position);
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
       // TextView txthape;
        ImageView imghape;
        ImageSwitcher imageSwitcher;

        public ViewHolder(final View itemView) {
            super(itemView);
            LayoutInflater lInflater = LayoutInflater.from(context);
            View v = lInflater.inflate(R.layout.main, null);

         // txthape = (TextView) itemView.findViewById(R.id.txthape);
            imghape = (ImageView) itemView.findViewById(R.id.imghp);
            imageSwitcher = (ImageSwitcher)v.findViewById(R.id.switcher);
            imghape.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                       // imageSwitcher.setImageResource(list_data.get());
                    int position = list_data.size();
                    String a = String.valueOf(position);
                  // String pst = list_data.get(position);
                    klick(a);

                }
            });

        }
        public void klick (String list){
            int position = list_data.indexOf(list);
            HashMap<String, String> data = list_data.get(position);
            int dt = Integer.parseInt(String.valueOf(data));
            imageSwitcher.setImageResource(dt);

        }
    }



//updated

}
