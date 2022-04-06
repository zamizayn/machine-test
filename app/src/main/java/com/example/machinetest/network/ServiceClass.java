package com.example.machinetest.network;

import com.example.machinetest.pojo.ProductPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceClass {

    @GET("5ec39cba300000720039c1f6")
    Call<ProductPojo> getProductList();

}
