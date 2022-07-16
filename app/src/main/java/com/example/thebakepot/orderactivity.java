package com.example.thebakepot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.thebakepot.Adapters.OrderADapter;
import com.example.thebakepot.Models.OrderModel;
import com.example.thebakepot.databinding.ActivityOrderactivityBinding;

import java.util.ArrayList;

public class orderactivity extends AppCompatActivity {
    ActivityOrderactivityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrderactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DBHelper dbHelper=new DBHelper(this);
        ArrayList<OrderModel>list=dbHelper.getOrders();
        OrderADapter adapter=new OrderADapter(list,this);
        binding.ordersRecyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.ordersRecyclerView.setLayoutManager(layoutManager  );
    }
}