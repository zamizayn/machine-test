package com.example.machinetest.pojo;

import java.util.List;

public class CategoryPojo {

    private String title;
    private List<Products> products;
    private boolean visible = false;

    public CategoryPojo(String title,List<Products> products){
        this.title = title;
        this.products = products;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public String getTitle() {
        return title;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
