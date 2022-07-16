package com.example.thebakepot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.thebakepot.Adapters.MainAdapters;
import com.example.thebakepot.Models.MainModel;
import com.example.thebakepot.Adapters.MainAdapters;
import com.example.thebakepot.databinding.ActivityHomeBinding;
import com.example.thebakepot.databinding.ActivityMainBinding;
import java.util.ArrayList;
public class Home extends AppCompatActivity {
    ActivityHomeBinding binding;
    RecyclerView recyclerView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
        binding=ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<MainModel> list=new ArrayList<>();
        list.add(new MainModel(R.drawable.cake,"Cake","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.browniecake,"Cake","6","Cake with extra egg"));
        list.add(new MainModel(R.drawable.chocolatecake,"Cake","7","Cake with extra egg"));
        list.add(new MainModel(R.drawable.ferrerorochercake,"Cake","8","Cake with extra egg"));
        list.add(new MainModel(R.drawable.oreo,"Cake","9","Cake with extra egg"));
        list.add(new MainModel(R.drawable.plumcake,"Cake","10","Cake with extra egg"));
        list.add(new MainModel(R.drawable.redvelvetcake,"Cake","11","Cake with extra egg"));


        list.add(new MainModel(R.drawable.chocolatecookie,"Cookie","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.chocolatechip,"Cookie","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.chocolatecrinkle,"Cookie","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.monstercookies,"Cookie","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.peanutbutter,"Cookie","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.rasperry,"Cookie","5","Cake with extra egg"));

        list.add(new MainModel(R.drawable.apple,"Biscuit","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.butter,"Biscuit","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.cream,"Biscuit","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.cheesybiscuits,"Biscuit","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.parmesansweeet,"Biscuit","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.parmesan,"Biscuit","5","Cake with extra egg"));

        list.add(new MainModel(R.drawable.almond,"Chocolate","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.darkchocolate,"Chocolate","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.german,"Chocolate","5","Cake with extra egg"));


        list.add(new MainModel(R.drawable.carrotcakecupcakes,"Cupcake","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.chocolatecupcakes,"Cupcake","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.cookiesandcreamcupcake,"Cupcake","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.redvelvetcakecupcakes,"Cupcake","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.strawberrycupcakes,"Cupcake","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.vanilla,"Cupcake","5","Cake with extra egg"));

        list.add(new MainModel(R.drawable.chocolatedonuts,"DoughNuts","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.filleddonut,"DoughNuts","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.regular,"DoughNuts","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.specialdonuts,"DoughNuts","5","Cake with extra egg"));
        list.add(new MainModel(R.drawable.icecream,"Icecream","5","Cake with extra egg"));
        MainAdapters adapter= new MainAdapters(list,this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
         switch (item.getItemId()){
             case R.id.orders:
                 startActivity(new Intent(Home.this,orderactivity.class));
                 break;
         }
         return super.onOptionsItemSelected(item);
    }
}