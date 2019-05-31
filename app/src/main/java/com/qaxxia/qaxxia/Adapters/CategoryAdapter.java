package com.qaxxia.qaxxia.Adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qaxxia.qaxxia.Models.CategoryModel;
import com.qaxxia.qaxxia.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MainViewHolder> {

    private List<CategoryModel> categorylist;

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        private TextView category_textview;
        private ImageView category_imageview;
        private CoordinatorLayout container;

        private MainViewHolder(View view) {
            super(view);
            category_imageview = view.findViewById(R.id.category_imageholder);
            category_textview = view.findViewById(R.id.category_textholder);
            container = view.findViewById(R.id.category_container);
        }
    }

    public CategoryAdapter(List<CategoryModel> categorylist) {
        this.categorylist = categorylist;
    }

    @NonNull @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryview = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_holder, parent, false);
        return new MainViewHolder(categoryview);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        CategoryModel categoryModel = categorylist.get(position);
        holder.category_textview.setText(categoryModel.getCategory_name());
        Glide.with(holder.category_imageview.getContext()).load(categoryModel.getImage_url()).into(holder.category_imageview);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent in = new Intent(view.getContext(), SubCategoryActivity.class);
                //view.getContext().startActivity(in);
            }
        });
    }
    @Override
    public int getItemCount() {
        return categorylist.size();
    }
}