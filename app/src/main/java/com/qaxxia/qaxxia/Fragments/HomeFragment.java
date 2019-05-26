package com.qaxxia.qaxxia.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qaxxia.qaxxia.Adapters.CategoryAdapter;
import com.qaxxia.qaxxia.Adapters.SlideShowPagerAdapter;
import com.qaxxia.qaxxia.Models.CategoryModel;
import com.qaxxia.qaxxia.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    private static final int[] images = {R.drawable.dummy_image, R.drawable.dummy_image, R.drawable.dummy_image, R.drawable.dummy_image, R.drawable.dummy_image};
    private ArrayList<Integer> slide_images = new ArrayList<Integer>();
    private static int currentPage = 0;
    private ViewPager slideshowpager;

    private List<CategoryModel> categorylist = new ArrayList<>();
    private RecyclerView mRecylerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {

        View view = layoutInflater.inflate(R.layout.activity_homefragment, container, false);
        for (int i = 0; i < images.length; ++i) {
            slide_images.add(images[i]);
        }

        slideshowpager = view.findViewById(R.id.pager_slideshow);
        slideshowpager.setAdapter(new SlideShowPagerAdapter(getActivity(), slide_images));

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
        }, 2500, 2500);

        mRecylerView = view.findViewById(R.id.recyclerview_categories);
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecylerView.setLayoutManager(mLayoutManager);
        mAdapter = new CategoryAdapter(categorylist);
        mRecylerView.setAdapter(mAdapter);

        getCategories();

        return view;
    }

    private void getCategories() {
        CategoryModel categoryModel = new CategoryModel("https://cdn.shopify.com/s/files/1/1658/9717/products/dummy_2048x.png", "Men");
        categorylist.add(categoryModel);
        categoryModel = new CategoryModel("https://cdn.shopify.com/s/files/1/1658/9717/products/dummy_2048x.png", "Women");
        categorylist.add(categoryModel);
        categoryModel = new CategoryModel("https://cdn.shopify.com/s/files/1/1658/9717/products/dummy_2048x.png", "Children");
        categorylist.add(categoryModel);
        categoryModel = new CategoryModel("https://cdn.shopify.com/s/files/1/1658/9717/products/dummy_2048x.png", "Household");
        categorylist.add(categoryModel);
        categoryModel = new CategoryModel("https://cdn.shopify.com/s/files/1/1658/9717/products/dummy_2048x.png", "Mobile");
        categorylist.add(categoryModel);
        categoryModel = new CategoryModel("https://cdn.shopify.com/s/files/1/1658/9717/products/dummy_2048x.png", "Electronics");
        categorylist.add(categoryModel);
    }
}
