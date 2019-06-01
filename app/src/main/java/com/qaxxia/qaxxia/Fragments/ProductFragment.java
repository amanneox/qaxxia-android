package com.qaxxia.qaxxia.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qaxxia.qaxxia.Adapters.ProductAdapter;
import com.qaxxia.qaxxia.Models.ProductModel;
import com.qaxxia.qaxxia.R;

import java.util.ArrayList;
import java.util.List;

public class ProductFragment extends Fragment {

    public List<ProductModel> productlist = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_productfragment, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.product_recyclerview);
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter pAdapter = new ProductAdapter(productlist);
        recyclerView.setAdapter(pAdapter);

        getProducts();

        return rootView;
    }

    private void getProducts() {
        ProductModel productModel = new ProductModel("https://www.lg.com/cz/content/img/support/img-dummy-product.jpg", "Product 1", "$50.00");
        productlist.add(productModel);
        productModel = new ProductModel("https://www.lg.com/cz/content/img/support/img-dummy-product.jpg", "Product 2", "$50.00");
        productlist.add(productModel);
        productModel = new ProductModel("https://www.lg.com/cz/content/img/support/img-dummy-product.jpg", "Product 3", "$50.00");
        productlist.add(productModel);
        productModel = new ProductModel("https://www.lg.com/cz/content/img/support/img-dummy-product.jpg", "Product 4", "$50.00");
        productlist.add(productModel);
        productModel = new ProductModel("https://www.lg.com/cz/content/img/support/img-dummy-product.jpg", "Product 5", "$50.00");
        productlist.add(productModel);
        productModel = new ProductModel("https://www.lg.com/cz/content/img/support/img-dummy-product.jpg", "Product 6", "$50.00");
        productlist.add(productModel);
        productModel = new ProductModel("https://www.lg.com/cz/content/img/support/img-dummy-product.jpg", "Product 7", "$50.00");
        productlist.add(productModel);
        productModel = new ProductModel("https://www.lg.com/cz/content/img/support/img-dummy-product.jpg", "Product 8", "$50.00");
        productlist.add(productModel);
    }
}
