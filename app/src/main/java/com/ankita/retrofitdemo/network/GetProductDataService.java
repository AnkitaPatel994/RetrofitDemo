package com.ankita.retrofitdemo.network;

import com.ankita.retrofitdemo.model.CategoryList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetProductDataService {

    @GET("api_android/category.php")
    Call<CategoryList> getCategoryData();
}
