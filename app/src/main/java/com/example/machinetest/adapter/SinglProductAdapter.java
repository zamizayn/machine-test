package com.example.machinetest.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.machinetest.ProductDetail;
import com.example.machinetest.R;
import com.example.machinetest.pojo.Products;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SinglProductAdapter extends RecyclerView.Adapter<SinglProductAdapter.MyViewHolder>{

    private Context context;
    private List<Products> products;
   public SinglProductAdapter(Context context,List<Products> data){
        this.context = context;
        this.products = data;
    }

    @NonNull
    @Override
    public SinglProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_list,parent,false);
        return new SinglProductAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SinglProductAdapter.MyViewHolder holder, int position) {
       // Glide.with(context).load(this.products.get(position).getImageUrl()).into(holder.imageView);
        Picasso.get().load(this.products.get(position).getImageUrl()).into(holder.imageView);
        holder.title.setText(this.products.get(position).getTitle());
        holder.price.setText(this.products.get(position).getPrice());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductDetail.class);
                intent.putExtra("name",products.get(position).getTitle());
                intent.putExtra("image",products.get(position).getImageUrl());
                intent.putExtra("price",products.get(position).getPrice());
                intent.putExtra("description",products.get(position).getDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
       if(this.products!=null){
           return this.products.size();
       }
        return 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title,price;
        ImageView imageView;

        public MyViewHolder(View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            imageView = itemView.findViewById(R.id.image);

        }
    }
}
