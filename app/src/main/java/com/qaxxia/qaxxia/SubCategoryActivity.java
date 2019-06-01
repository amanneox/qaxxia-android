package com.qaxxia.qaxxia;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.qaxxia.qaxxia.Adapters.SubCategoryPagerAdapter;
import com.qaxxia.qaxxia.Models.SubCategoryModel;

import java.util.ArrayList;
import java.util.List;

public class SubCategoryActivity extends FragmentActivity {

    public List<SubCategoryModel> subcategorylist = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory);

        ViewPager viewPager = findViewById(R.id.subcategory_pager);
        TabLayout tabLayout = findViewById(R.id.subcategory_tabs);
        tabLayout.setupWithViewPager(viewPager);
        getSubCategories();
        PagerAdapter pagerAdapter = new SubCategoryPagerAdapter(getSupportFragmentManager(), subcategorylist);
        viewPager.setAdapter(pagerAdapter);
    }

    private void getSubCategories() {
        SubCategoryModel subCategoryModel = new SubCategoryModel("Jeans");
        subcategorylist.add(subCategoryModel);
        subCategoryModel = new SubCategoryModel("T-Shirts");
        subcategorylist.add(subCategoryModel);
        subCategoryModel = new SubCategoryModel("Shirts");
        subcategorylist.add(subCategoryModel);
        subCategoryModel = new SubCategoryModel("Shorts");
        subcategorylist.add(subCategoryModel);
        subCategoryModel = new SubCategoryModel("Shoes");
        subcategorylist.add(subCategoryModel);
        subCategoryModel = new SubCategoryModel("Trousers");
        subcategorylist.add(subCategoryModel);
        subCategoryModel = new SubCategoryModel("Baggage");
        subcategorylist.add(subCategoryModel);
        subCategoryModel = new SubCategoryModel("Accessories");
        subcategorylist.add(subCategoryModel);
    }
}
