package com.example.machinetest.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface ProductsDAO {

    @Query("SELECT * FROM ProductsDb")
    List<ProductsDb> getAllProducts();

    @Insert
    void insert(ProductsDb... productsDbs);

    @Query("DELETE FROM ProductsDb")
    void deleteAll();

}
