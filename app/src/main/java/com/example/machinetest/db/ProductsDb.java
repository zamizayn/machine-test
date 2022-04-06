package com.example.machinetest.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.machinetest.pojo.Converters;
import com.example.machinetest.pojo.Products;

import java.util.List;

@Entity
@TypeConverters(Converters.class)
public class ProductsDb {



    @PrimaryKey(autoGenerate = true)
    public int productId;
//
//    @ColumnInfo(name = "product_name")
//    public String productName;
//
//    @ColumnInfo(name = "image")
//    public String image;
//
//    @ColumnInfo(name = "price")
//    public String price;
//
//    @ColumnInfo(name = "description")
//    public String description;

    @ColumnInfo(name = "products")
    public List<Products> products;

    @ColumnInfo(name = "title")
    public String category;


}
