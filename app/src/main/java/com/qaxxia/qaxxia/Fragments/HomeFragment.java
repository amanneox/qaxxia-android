package com.qaxxia.qaxxia.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qaxxia.qaxxia.Adapters.CategoryAdapter;
import com.qaxxia.qaxxia.Adapters.ProductAdapter;
import com.qaxxia.qaxxia.Adapters.SlideShowPagerAdapter;
import com.qaxxia.qaxxia.Models.CategoryModel;
import com.qaxxia.qaxxia.Models.ProductModel;
import com.qaxxia.qaxxia.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {

    private static final int[] images = {R.drawable.dummy_image, R.drawable.dummy_image, R.drawable.dummy_image, R.drawable.dummy_image, R.drawable.dummy_image};
    private ArrayList<Integer> slide_images = new ArrayList<Integer>();
    private static int currentPage = 0;
    private ViewPager slideshowpager;

    private List<CategoryModel> categorylist = new ArrayList<>();
    private List<ProductModel> productlist = new ArrayList<>();


    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {

        View view = layoutInflater.inflate(R.layout.activity_homefragment, container, false);
        for (int i = 0; i < images.length; ++i) {
            slide_images.add(images[i]);
        }

        slideshowpager = view.findViewById(R.id.pager_slideshow);
        slideshowpager.setAdapter(new SlideShowPagerAdapter(getActivity(), slide_images));

        CircleIndicator circleIndicator = view.findViewById(R.id.indicator_slideshow);
        circleIndicator.setViewPager(slideshowpager);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currentPage == images.length) {
                    currentPage = 0;
                }
                slideshowpager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 1500, 1500);

        RecyclerView mRecylerView = view.findViewById(R.id.recyclerview_categories);
        mRecylerView.setNestedScrollingEnabled(false);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecylerView.setLayoutManager(mLayoutManager);
        RecyclerView.Adapter mAdapter = new CategoryAdapter(categorylist);
        mRecylerView.setAdapter(mAdapter);

        getCategories();

        RecyclerView pRecylerView = view.findViewById(R.id.recyclerview_products);
        pRecylerView.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager pLayoutManager = new GridLayoutManager(getActivity(), 2);
        pRecylerView.setLayoutManager(pLayoutManager);
        RecyclerView.Adapter pAdapter = new ProductAdapter(productlist);
        pAdapter.setHasStableIds(true);
        pRecylerView.setAdapter(pAdapter);

        getProducts();

        return view;
    }

    private void getCategories() {
        CategoryModel categoryModel = new CategoryModel("https://www.lg.com/cz/content/img/support/img-dummy-product.jpg", "Men");
        categorylist.add(categoryModel);
        categoryModel = new CategoryModel("https://www.lg.com/cz/content/img/support/img-dummy-product.jpg", "Women");
        categorylist.add(categoryModel);
        categoryModel = new CategoryModel("https://www.lg.com/cz/content/img/support/img-dummy-product.jpg", "Children");
        categorylist.add(categoryModel);
        categoryModel = new CategoryModel("https://www.lg.com/cz/content/img/support/img-dummy-product.jpg", "Household");
        categorylist.add(categoryModel);
        categoryModel = new CategoryModel("https://www.lg.com/cz/content/img/support/img-dummy-product.jpg", "Mobile");
        categorylist.add(categoryModel);
        categoryModel = new CategoryModel("https://www.lg.com/cz/content/img/support/img-dummy-product.jpg", "Electronics");
        categorylist.add(categoryModel);
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
