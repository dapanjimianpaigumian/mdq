package com.sdjr.mdq.ui.jdr;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.sdjr.mdq.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JDRActivity extends AppCompatActivity {

    @Bind(R.id.jdr_lin1_img1)
    ImageView jdrLin1Img1;
    @Bind(R.id.jdr_lin1_img2)
    ImageView jdrLin1Img2;
    @Bind(R.id.jdr_lin1)
    RelativeLayout jdrLin1;
    @Bind(R.id.jdr_lin2)
    LinearLayout jdrLin2;
    @Bind(R.id.jdr_lin3_img1)
    ImageView jdrLin3Img1;
    @Bind(R.id.jdr_lin3_img2)
    ImageView jdrLin3Img2;
    @Bind(R.id.jdr_lin3)
    RelativeLayout jdrLin3;
    @Bind(R.id.jdr_lin4)
    LinearLayout jdrLin4;
    @Bind(R.id.jdr_lin5_img1)
    ImageView jdrLin5Img1;
    @Bind(R.id.jdr_lin5_img2)
    ImageView jdrLin5Img2;
    @Bind(R.id.jdr_lin5)
    RelativeLayout jdrLin5;
    @Bind(R.id.jdr_lin6)
    LinearLayout jdrLin6;
    @Bind(R.id.jdr_img01)
    ImageView jdrImg01;
    @Bind(R.id.jdr_viewpager)
    ViewPager jdrViewpager;
    @Bind(R.id.dot_0)
    View dot0;
    @Bind(R.id.dot_1)
    View dot1;
    @Bind(R.id.dot_2)
    View dot2;
    private int lin1 = 1;
    private int lin2 = 1;
    private int lin3 = 1;
    int oldPosition;

    private int[] imageIds = new int[]{R.drawable.viewpager1,
            R.drawable.viewpager2,
            R.drawable.viewpager3};

    private List<ImageView> mImageViewList;
    private List<View> dots;
    private int currentItem;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            jdrViewpager.setCurrentItem(currentItem, true);
        }
    };
    private ScheduledExecutorService scheduledExecutorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_jdr);
        ButterKnife.bind(this);

        mImageViewList = new ArrayList<>();
        for (int i = 0; i < imageIds.length; i++) {
            ImageView mImageView = new ImageView(this);
            mImageView.setBackgroundResource(imageIds[i]);
            mImageViewList.add(mImageView);
        }

        dots = new ArrayList<>();
        dots.add(dot0);
        dots.add(dot1);
        dots.add(dot2);

        ViewPagerAdapter mAdapter = new ViewPagerAdapter();
        jdrViewpager.setAdapter(mAdapter);

        jdrViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                dots.get(position).setBackgroundResource(R.mipmap.full_holo);
                dots.get(oldPosition).setBackgroundResource(R.mipmap.empty_holo);

                oldPosition = position;

                currentItem=position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageIds.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mImageViewList.get(position));
            return mImageViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mImageViewList.get(position));
        }
    }

    private class ViewPagerTask implements Runnable {
        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;

            mHandler.sendEmptyMessage(0);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPagerTask(),
                2,
                2,
                TimeUnit.SECONDS
        );
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.jdr_lin1, R.id.jdr_lin3, R.id.jdr_lin5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jdr_lin1:
                if (lin1 == 1) {
                    jdrLin1Img2.setVisibility(View.VISIBLE);
                    jdrLin1Img1.setVisibility(View.GONE);
                    jdrLin2.setVisibility(View.VISIBLE);
                    lin1 = 2;
                } else if (lin1 == 2) {
                    jdrLin1Img2.setVisibility(View.GONE);
                    jdrLin1Img1.setVisibility(View.VISIBLE);
                    jdrLin2.setVisibility(View.GONE);
                    lin1 = 1;
                }
                break;
            case R.id.jdr_lin3:
                if (lin2 == 1) {
                    jdrLin3Img2.setVisibility(View.VISIBLE);
                    jdrLin3Img1.setVisibility(View.GONE);
                    jdrLin4.setVisibility(View.VISIBLE);
                    lin2 = 2;
                } else if (lin2 == 2) {
                    jdrLin3Img2.setVisibility(View.GONE);
                    jdrLin3Img1.setVisibility(View.VISIBLE);
                    jdrLin4.setVisibility(View.GONE);
                    lin2 = 1;
                }
                break;
            case R.id.jdr_lin5:
                if (lin3 == 1) {
                    jdrLin5Img2.setVisibility(View.VISIBLE);
                    jdrLin5Img1.setVisibility(View.GONE);
                    jdrLin6.setVisibility(View.VISIBLE);
                    lin3 = 2;
                } else if (lin3 == 2) {
                    jdrLin5Img2.setVisibility(View.GONE);
                    jdrLin5Img1.setVisibility(View.VISIBLE);
                    jdrLin6.setVisibility(View.GONE);
                    lin3 = 1;
                }
                break;
        }
    }
}
