package com.example.thebakepot.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thebakepot.DetailActivity;
import com.example.thebakepot.Models.MainModel;
import com.example.thebakepot.R;

import java.util.ArrayList;

public class MainAdapters extends RecyclerView.Adapter<MainAdapters.viewholder>{

    public MainAdapters(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    ArrayList<MainModel>list;
    Context context;


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_mainfood,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final MainModel model=list.get(position);
        holder.foodimage.setImageResource(model.getImages());
        holder.mainName.setText(model.getName());
        holder.description.setText(model.getDescription());
        holder.price.setText(model.getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(context, DetailActivity.class);
                i.putExtra("name",model.getName());
                i.putExtra("price",model.getPrice());
                i.putExtra("image",model.getImages());
                i.putExtra("desc",model.getDescription());
                i.putExtra("type",1);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        ImageView foodimage;
        TextView mainName,price,description;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            foodimage=(ImageView) itemView.findViewById(R.id.orderImage);
            mainName=(TextView) itemView.findViewById(R.id.solditemname);
            price=(TextView) itemView.findViewById(R.id.orderPrice);
            description=(TextView) itemView.findViewById(R.id.description);


        }
    }
}
