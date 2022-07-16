package com.example.thebakepot;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.thebakepot.databinding.ActivityDetailedOrderBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailedOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailedOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.insertBtn.setText("Order now");
        Integer quantity=Integer.parseInt(binding.quantity.getText().toString());
        final DBHelper helper = new DBHelper(this);
        if (getIntent().getIntExtra("type", 0) == 1) {
            int image = getIntent().getIntExtra("image", 0);
            int price = Integer.parseInt(getIntent().getStringExtra("price"));
            String name = getIntent().getStringExtra("name");
            String description = getIntent().getStringExtra("desc");

            binding.detailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d", price));
            binding.namelbl.setText(name);
            binding.detailsDescription.setText(description);

            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isInserted = helper.insertOrder(binding.nameBox.getText().toString(), binding.phoneBox.getText().toString(), price, Integer.parseInt(binding.quantity.getText().toString()), image, name, description);
                    if (isInserted) {
                        Toast.makeText(DetailActivity.this, "Succesfully added", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "failed to add", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else{
            binding.insertBtn.setText("Update now");
            //name text,phone text,price Integer,quantity Integer,image Integer,description text,foodname text
            int id=getIntent().getIntExtra("id",0);
            Cursor c=helper.getOrderById(id);
            binding.detailImage.setImageResource(c.getInt(5));
            binding.priceLbl.setText(String.format("%d", c.getInt(3)));
            binding.namelbl.setText(c.getString(7));
            binding.detailsDescription.setText(c.getString(6));
            binding.nameBox.setText(c.getString(1));
            binding.phoneBox.setText(c.getString(2));
            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isInserted = helper.updateOrder(binding.nameBox.getText().toString(), binding.phoneBox.getText().toString(),Integer.parseInt(String.format("%d", c.getInt(3))), Integer.parseInt(binding.quantity.getText().toString()), c.getInt(5),c.getString(7),c.getString(6),id);
                    if (isInserted) {
                        Toast.makeText(DetailActivity.this, "Succesfully updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "failed to update", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
}