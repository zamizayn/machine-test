package com.example.machinetest.pojo;

import java.util.List;

public class ProductPojo {
    private List<CategoryPojo> categories;
    public ProductPojo(List<CategoryPojo> categoryPojos){
        this.categories = categoryPojos;
    }

    public List<CategoryPojo> getDatas() {
        return categories;
    }

    public void setDatas(List<CategoryPojo> datas) {
        this.categories = datas;
    }
}
