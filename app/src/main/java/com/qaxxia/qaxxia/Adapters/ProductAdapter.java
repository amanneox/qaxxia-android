package com.qaxxia.qaxxia.Adapters;

import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qaxxia.qaxxia.Models.ProductModel;
import com.qaxxia.qaxxia.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MainViewHolder> {

    private List<ProductModel> productlist;

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        private TextView productname_textview;
        private TextView productprice_textview;
        private ImageView productimage_imageview;
        private CoordinatorLayout container;

        private MainViewHolder(View view) {
            super(view);
            productimage_imageview = view.findViewById(R.id.productimage_holder);
            productname_textview = view.findViewById(R.id.productname_holder);
            productprice_textview = view.findViewById(R.id.productprice_holder);
            container = view.findViewById(R.id.product_container);
        }
    }

    public ProductAdapter(List<ProductModel> productlist) {
        this.productlist = productlist;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productview = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_holder, parent, false);
        return new MainViewHolder(productview);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        ProductModel productModel = productlist.get(position);
        holder.productname_textview.setText(productModel.getProduct_name());
        holder.productprice_textview.setText(productModel.getProduct_price());
        Glide.with(holder.productimage_imageview.getContext()).load(productModel.getProduct_imageurl()).into(holder.productimage_imageview);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent in = new Intent(view.getContext(), );
                //view.getContext().startActivity(in);
            }
        });
    }
    @Override
    public int getItemCount() {
        return productlist.size();
    }
}
