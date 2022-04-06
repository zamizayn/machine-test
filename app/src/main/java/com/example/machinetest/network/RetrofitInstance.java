package com.example.machinetest.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static String BASEURL = "http://www.mocky.io/v2/";

    public static Retrofit retrofit;

    public static Retrofit getRetrofit(){
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
