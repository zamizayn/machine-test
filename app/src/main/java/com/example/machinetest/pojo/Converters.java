package com.example.machinetest.pojo;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Converters {

    @TypeConverter
    public static String measurementsToString(List<Products> list) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Products>>() {}.getType();
        String json = gson.toJson(list, type);
        return json;
    }

    @TypeConverter
    public static List<Products> stringToMeasurements(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Products>>() {}.getType();
        List<Products> measurements = gson.fromJson(json, type);
        return measurements;
    }
}
