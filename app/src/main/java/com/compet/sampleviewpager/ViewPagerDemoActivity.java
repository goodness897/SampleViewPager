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

    private int[] mImageResources = {R.mipmap.ic_launcher,
                                     R.mipmap.ic_launcher,
                                     R.mipmap.ic_launcher,
                                     R.mipmap.ic_launcher,
                                     R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_demo);

        intro_images = (ViewPager)findViewById(R.id.pager_introduction);
        btnNext = (ImageButton)findViewById(R.id.btn_next);
        btnFinish = (ImageButton)findViewById(R.id.btn_finish);

        pager_indicator = (LinearLayout)findViewById(R.id.viewPagerCountDots);

        btnNext.setOnClickListener(this);
        btnFinish.setOnClickListener(this);

        mAdapter = new ViewPagerDemoAdapter(ViewPagerDemoActivity.this, mImageResources);
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

            params.setMargins(4, 0, 4, 0);

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
        switch (view.getId()) {
            case R.id.btn_next:
                intro_images.setCurrentItem((intro_images.getCurrentItem() < dotsCount) ? intro_images.getCurrentItem()
                                                                                          + 1
                                                                                        : 0);
                break;

            case R.id.btn_finish:
                intro_images.setCurrentItem((intro_images.getCurrentItem() < dotsCount) ? intro_images.getCurrentItem() - 1 : 0);
                break;
        }
    }
}
