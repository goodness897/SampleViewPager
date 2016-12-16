package com.compet.sampleviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ViewPagerDemoActivity extends AppCompatActivity
                                   implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ImageButton btnNext, btnFinish;

    private ViewPager intro_images;

    private LinearLayout pager_indicator;

    private int dotsCount;

    private ImageView[] dots;

    private ViewPagerDemoAdapter mAdapter;

    private int[] mImageResources = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    private String[] mTextResources = {"측정과 기록을 한번에!", "나의 변화를 한눈에!", "관리와 공유를 하나로!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_demo);

        intro_images = (ViewPager)findViewById(R.id.pager_introduction);


        pager_indicator = (LinearLayout)findViewById(R.id.viewPagerCountDots);

        mAdapter = new ViewPagerDemoAdapter(ViewPagerDemoActivity.this, mImageResources, mTextResources);
        intro_images.setAdapter(mAdapter);
        intro_images.setCurrentItem(0);
        intro_images.setOnPageChangeListener(this);
        setUiPageViewController();
    }

    private void setUiPageViewController() {

        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.non_selected_item_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                                                                             LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(16, 0, 16, 0);

            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selected_item_dot));

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.non_selected_item_dot));
        }

        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selected_item_dot));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {

    }
}
