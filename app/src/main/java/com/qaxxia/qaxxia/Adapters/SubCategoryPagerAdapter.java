package com.qaxxia.qaxxia.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.qaxxia.qaxxia.Fragments.ProductFragment;
import com.qaxxia.qaxxia.Models.SubCategoryModel;

import java.util.ArrayList;
import java.util.List;

public class SubCategoryPagerAdapter extends FragmentStatePagerAdapter {

    private List<SubCategoryModel> subcategorylist;

    public SubCategoryPagerAdapter(FragmentManager fm, List<SubCategoryModel> subcategorylist) {
        super(fm);
        this.subcategorylist = subcategorylist;
    }

    @Override
    public Fragment getItem(int position) {
        return new ProductFragment();
    }

    @Override
    public int getCount() {
        return subcategorylist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return subcategorylist.get(position).getSubcategoryname();
    }
}
