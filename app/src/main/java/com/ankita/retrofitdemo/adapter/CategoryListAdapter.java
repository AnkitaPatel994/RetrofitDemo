package com.ankita.retrofitdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ankita.retrofitdemo.R;
import com.ankita.retrofitdemo.activity.MainActivity;
import com.ankita.retrofitdemo.model.category;
import com.ankita.retrofitdemo.network.RetrofitInstance;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {

    Context context;
    ArrayList<category> categoryListArray;
    View v;

    public CategoryListAdapter(Context context, ArrayList<category> categoryListArray) {
        this.context = context;
        this.categoryListArray = categoryListArray;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        final String category_id = categoryListArray.get(position).getCategory_id();
        String category_title = categoryListArray.get(position).getCategory_title();
        String category_img = categoryListArray.get(position).getCategory_img();

        viewHolder.txtCatName.setText(category_title);

        Picasso.with(context).load(RetrofitInstance.BASE_URL +category_img).into(viewHolder.ivCatImg);

        /*v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,SubCategoryActivity.class);
                i.putExtra("category_id",category_id);
                context.startActivity(i);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return categoryListArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView ivCatImg;
        TextView txtCatName;

        public ViewHolder(View itemView) {
            super(itemView);

            ivCatImg = (CircleImageView)itemView.findViewById(R.id.ivCatImg);
            txtCatName = (TextView)itemView.findViewById(R.id.txtCatName);
        }
    }
}
