package com.example.machinetest.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.machinetest.R;
import com.example.machinetest.pojo.CategoryPojo;
import com.example.machinetest.pojo.ProductPojo;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    private Context context;
    private ProductPojo productCategories;

    public ProductAdapter(Context context,ProductPojo products){
        this.context = context;
        this.productCategories = products;
    }


    public void setDatas(ProductPojo pojo){
        this.productCategories = pojo;
        Log.d("GOTFDTA","hjhv"+this.productCategories.getDatas().size());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.categories,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.MyViewHolder holder, int position) {
        holder.category.setText(this.productCategories.getDatas().get(position).getTitle());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!productCategories.getDatas().get(position).isVisible()){
                    Glide.with(context).load(R.drawable.down_arrow).into(holder.icon);
                    holder.recyclerView.setVisibility(View.VISIBLE);
                }
                else{
                    Glide.with(context).load(R.drawable.right_arrow).into(holder.icon);

                    holder.recyclerView.setVisibility(View.GONE);
                }
                productCategories.getDatas().get(position).setVisible(!productCategories.getDatas().get(position).isVisible());;

            }
        });
        LinearLayoutManager linearLayoutManager = new  GridLayoutManager(context, 2);
        holder.recyclerView.setLayoutManager(linearLayoutManager);
        SinglProductAdapter adapter = new SinglProductAdapter(context,this.productCategories.getDatas().get(position).getProducts());
        holder.recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        if(this.productCategories!=null){
            return this.productCategories.getDatas().size();
        }
        return 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
            TextView category;
            RecyclerView recyclerView;
            ImageView icon;
            CardView cardView;

        public MyViewHolder(View itemView){
            super(itemView);
            category = itemView.findViewById(R.id.category);
            recyclerView = itemView.findViewById(R.id.products);
            icon = itemView.findViewById(R.id.icon);
            cardView = itemView.findViewById(R.id.card);
        }
    }
}
