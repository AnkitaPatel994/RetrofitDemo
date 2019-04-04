package com.ankita.retrofitdemo.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CategoryList {
    @SerializedName("category")
    private ArrayList<category> categoryList;

    public ArrayList<category> getCategoryArrayList() {
        return categoryList;
    }

    public void setCategoryList(ArrayList<category> categoryList) {
        this.categoryList = categoryList;
    }
}
