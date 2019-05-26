package com.qaxxia.qaxxia.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.qaxxia.qaxxia.R;

import java.util.ArrayList;

public class SlideShowPagerAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<Integer> images_slide;
    private LayoutInflater layoutInflater;

    public SlideShowPagerAdapter(Context context, ArrayList<Integer> images_slide) {
        this.context = context;
        this.images_slide = images_slide;
        layoutInflater = LayoutInflater.from(context);
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images_slide.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.slideshow_imageholder, container, false);

        ImageView imageView = itemView.findViewById(R.id.imageView_slideshow);
        imageView.setImageResource(images_slide.get(position));

        container.addView(itemView, 0);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You clicked image " + (position + 1), Toast.LENGTH_LONG).show();
            }
        });
        return itemView;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
