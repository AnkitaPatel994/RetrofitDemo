package com.ankita.retrofitdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.ankita.retrofitdemo.R;
import com.ankita.retrofitdemo.adapter.CategoryListAdapter;
import com.ankita.retrofitdemo.model.CategoryList;
import com.ankita.retrofitdemo.model.category;
import com.ankita.retrofitdemo.network.GetProductDataService;
import com.ankita.retrofitdemo.network.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvCategoryList;
    CategoryListAdapter categoryListAdapter;
    ArrayList<category> categoryListArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategoryList = (RecyclerView)findViewById(R.id.rvCategoryList);
        rvCategoryList.setHasFixedSize(true);

        RecyclerView.LayoutManager manager = new GridLayoutManager(getApplicationContext(),2);
        rvCategoryList.setLayoutManager(manager);

        GetProductDataService productDataService = RetrofitInstance.getRetrofitInstance().create(GetProductDataService.class);
        Call<CategoryList> categoryListCall = productDataService.getCategoryData();

        Log.wtf("URL Called", categoryListCall.request().url() + "");

        TextView url = (TextView)findViewById(R.id.url);
        url.setText(""+categoryListCall.request().url());

        categoryListCall.enqueue(new Callback<CategoryList>() {
            @Override
            public void onResponse(Call<CategoryList> call, Response<CategoryList> response) {
                categoryListArray = response.body().getCategoryArrayList();
                categoryListAdapter = new CategoryListAdapter(MainActivity.this,categoryListArray);
                rvCategoryList.setAdapter(categoryListAdapter);
            }

            @Override
            public void onFailure(Call<CategoryList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
