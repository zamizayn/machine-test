package com.example.machinetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.machinetest.databinding.ActivityMainBinding;
import com.example.machinetest.databinding.ActivityProductDetailBinding;
import com.squareup.picasso.Picasso;

public class ProductDetail extends AppCompatActivity {
    ActivityProductDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailBinding.inflate(getLayoutInflater());
        getSupportActionBar().hide();
        View view = binding.getRoot();
        setContentView(view);
        Bundle intent = getIntent().getExtras();
        binding.productname.setText(intent.getString("name"));
        Picasso.get().load(intent.getString("image")).into(binding.productImage);
        binding.productPrice.setText(intent.getString("price"));
        binding.description.setText(intent.getString("description"));
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductDetail.super.onBackPressed();
            }
        });
    }
}