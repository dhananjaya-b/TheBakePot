package com.example.thebakepot.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.text.TextRunShaper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thebakepot.DBHelper;
import com.example.thebakepot.DetailActivity;
import com.example.thebakepot.Models.OrderModel;
import com.example.thebakepot.R;
import com.example.thebakepot.orderactivity;

import java.util.ArrayList;

public class OrderADapter extends RecyclerView.Adapter<OrderADapter.viewHolder>{
    ArrayList<OrderModel>list;
    Context context1;
    public OrderADapter(ArrayList<OrderModel> list, Context context) {
        this.list = list;
        this.context1 = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context1).inflate(R.layout.order_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final  OrderModel model =list.get(position);
        holder.OrderImage.setImageResource(model.getOrderImage());
        holder.soldItemName.setText(model.getSoldItemName());
        holder.orderNumber.setText(model.getOrderNumber());
        holder.price.setText(model.getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context1, DetailActivity.class);
                i.putExtra("id",Integer.parseInt(model.getOrderNumber()));
                i.putExtra("type",2);
                context1.startActivity(i);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new AlertDialog.Builder(context1)
                        .setTitle("Delete Item")
                        .setMessage("Are you sure to delete this item?")
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                DBHelper helper = new DBHelper(context1);
                                if (helper.deleteOrder(model.getOrderNumber())>0){
                                    Toast.makeText(context1, "Order Deleted", Toast.LENGTH_SHORT).show();
                                    context1.startActivity(new Intent(context1, orderactivity.class));
                                }
                                else {
                                    Toast.makeText(context1, "Failed to delete", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        }) .show();

                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size()  ;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView OrderImage;
        TextView soldItemName,orderNumber,price;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            OrderImage=itemView.findViewById(R.id.orderImage);
            soldItemName=itemView.findViewById(R.id.solditemname);
            orderNumber=itemView.findViewById(R.id.ordernumber);
            price=itemView.findViewById(R.id.OrderPrice);

        }
    }
}
