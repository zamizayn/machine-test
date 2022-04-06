package com.example.machinetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.machinetest.adapter.ProductAdapter;
import com.example.machinetest.databinding.ActivityMainBinding;
import com.example.machinetest.db.DbOperations;
import com.example.machinetest.db.ProductsDb;
import com.example.machinetest.pojo.CategoryPojo;
import com.example.machinetest.pojo.ProductPojo;
import com.example.machinetest.pojo.Products;
import com.example.machinetest.viewmodal.ProductViewModal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ProductAdapter adapter;
    ProductPojo datas;
    ProductViewModal viewModal;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        getSupportActionBar().setTitle("Categories");
         dialog = ProgressDialog.show(MainActivity.this, "",
                "Loading. Please wait...", true);
        dialog.show();
        setContentView(view);
        initialize();



    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public void saveToDb(ProductPojo pojo, List<Products> products){
        DbOperations db = DbOperations.getInstanec(getApplicationContext());
        ProductsDb datas = new ProductsDb();
        db.productsDAO().deleteAll();
        for (int i =0;i<pojo.getDatas().size();i++){
            datas.category = pojo.getDatas().get(i).getTitle();
            datas.products = pojo.getDatas().get(i).getProducts();
            db.productsDAO().insert(datas);
        }




    }

    public void loadDataFromDb(){
        DbOperations db = DbOperations.getInstanec(getApplicationContext());
        List<ProductsDb> datasDb =  db.productsDAO().getAllProducts();
        List<CategoryPojo> pojo = new ArrayList<CategoryPojo>();
        datas = new ProductPojo(pojo);
        for (int i = 0;i<datasDb.size();i++){
          pojo.add(new CategoryPojo(datasDb.get(i).category,datasDb.get(i).products));
        }


        datas.setDatas(pojo);
        adapter.setDatas(datas);
        dialog.dismiss();
    }

    public void initialize(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ProductAdapter(this, datas);
        binding.recyclerView.setAdapter(adapter);
        Log.d("REACHED HERE","hjvhjv");
        if(isNetworkAvailable()){
            viewModal = new ViewModelProvider(this).get(ProductViewModal.class);
            viewModal.getDataObserver().observe(this, new Observer<ProductPojo>() {
                @Override
                public void onChanged(ProductPojo pojos) {


                    datas = pojos;
                    Log.d("Data not obtained", "ghcg" + datas.getDatas().get(0).getTitle());
                    saveToDb(datas,datas.getDatas().get(0).getProducts());
                    adapter.setDatas(datas);
                    dialog.dismiss();

                }
            });
            viewModal.fetchData();
        }
        else{
            loadDataFromDb();
        }

    }
}