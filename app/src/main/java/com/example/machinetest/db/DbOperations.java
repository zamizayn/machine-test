package com.example.machinetest.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ProductsDb.class},version = 1)
public abstract class DbOperations extends RoomDatabase {

    public abstract ProductsDAO productsDAO();

    private static DbOperations INSTANCE;

    public static DbOperations getInstanec(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),DbOperations.class,"machine_test4").allowMainThreadQueries().build();
        }

        return  INSTANCE;
    }

}
