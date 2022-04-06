package com.example.machinetest.viewmodal;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.machinetest.network.RetrofitInstance;
import com.example.machinetest.network.ServiceClass;
import com.example.machinetest.pojo.ProductPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductViewModal extends ViewModel {

    private final MutableLiveData<ProductPojo> categories;

  public ProductViewModal(){
        categories = new MutableLiveData<>();
    }

    public MutableLiveData<ProductPojo> getDataObserver(){
        return categories;
    }

    public void fetchData(){
        ServiceClass serviceClass = RetrofitInstance.getRetrofit().create(ServiceClass.class);
        Call<ProductPojo> call = serviceClass.getProductList();
        call.enqueue(new Callback<ProductPojo>() {
            @Override
            public void onResponse(@NonNull Call<ProductPojo> call, @NonNull Response<ProductPojo> response) {
                Log.d("RESSS","RESPO"+response.body());
                categories.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ProductPojo> call, Throwable t) {

            }
        });
    }

}
