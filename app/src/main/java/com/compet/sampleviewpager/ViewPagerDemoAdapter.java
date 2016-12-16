package com.compet.sampleviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Mu on 2016-12-16.
 */

public class ViewPagerDemoAdapter extends PagerAdapter {

    private Context mContext;

    private int[] mImageResources;

    private String[] mTextResources;

    public ViewPagerDemoAdapter(Context mContext, int[] mImageResources, String[] mTextResources) {
        this.mContext = mContext;
        this.mImageResources = mImageResources;
        this.mTextResources = mTextResources;
    }

    @Override
    public int getCount() {
        return mImageResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View itemView = LayoutInflater.from(mContext).inflate(R.layout.pager_item, container, false);

        ImageView imageView = (ImageView)itemView.findViewById(R.id.img_pager_item);
        imageView.setImageResource(mImageResources[position]);

        TextView textView = (TextView)itemView.findViewById(R.id.text_item);
        textView.setText(mTextResources[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

}
