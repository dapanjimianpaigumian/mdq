package com.sdjr.mdq.ui.jdr;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
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

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JDRActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

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
    private int lin1 = 1;
    private int lin2 = 1;
    private int lin3 = 1;
    private int []imageIdArray;//图片资源的数组
    private List<View> viewList;//图片资源的集合
    private ViewGroup vg;//放置圆点

    //实例化原点View
    private ImageView iv_point;
    private ImageView []ivPointArray;
    private boolean isLooper;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isLooper = false;
    }

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
        jdrImg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JDRActivity.this.finish();
            }
        });

        //加载ViewPager
        initViewPager();

        //加载底部圆点
        initPoint();

        //修改添加设置ViewPager的当前页，为了保证左右轮播
        jdrViewpager.setCurrentItem(0);
        //开启一个线程，用于循环
        new Thread(new Runnable() {
            @Override
            public void run() {
                isLooper = true;
                while (isLooper){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //这里是设置当前页的下一页
                            if (jdrViewpager!=null){
                                jdrViewpager.setCurrentItem(jdrViewpager.getCurrentItem() + 1);
                            }
                        }
                    });
                }
            }
        }).start();
    }
    /**
     * 加载底部圆点
     */
    private void initPoint() {
        //这里实例化LinearLayout
        vg = (ViewGroup) findViewById(R.id.guide_ll_point);
        //根据ViewPager的item数量实例化数组
        ivPointArray = new ImageView[viewList.size()];
        //循环新建底部圆点ImageView，将生成的ImageView保存到数组中
        int size = viewList.size();
        for (int i = 0;i<size;i++){
            iv_point = new ImageView(this);
            iv_point.setLayoutParams(new ViewGroup.LayoutParams(20,20));
            iv_point.setPadding(30,0,30,0);//left,top,right,bottom
            ivPointArray[i] = iv_point;
            //第一个页面需要设置为选中状态，这里采用两张不同的图片
            if (i == 0){
                iv_point.setBackgroundResource(R.mipmap.full_holo);
            }else{
                iv_point.setBackgroundResource(R.mipmap.empty_holo);
            }
            //将数组中的ImageView加入到ViewGroup
            vg.addView(ivPointArray[i]);
        }
    }

    /**
     * 加载图片ViewPager
     */
    private void initViewPager() {
        //实例化图片资源
        imageIdArray = new int[]{R.drawable.viewpager1,R.drawable.viewpager2,R.drawable.viewpager3};
        viewList = new ArrayList<>();
        //获取一个Layout参数，设置为全屏
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);

        //循环创建View并加入到集合中
        int len = imageIdArray.length;
        for (int i = 0;i<len;i++){
            //new ImageView并设置全屏和图片资源
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(params);
            imageView.setBackgroundResource(imageIdArray[i]);

            //将ImageView加入到集合中
            viewList.add(imageView);
        }

        //View集合初始化好后，设置Adapter
        jdrViewpager.setAdapter(new GuidePageAdapter(viewList));
        //设置滑动监听
        jdrViewpager.setOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * 滑动后的监听
     * @param position
     */
    @Override
    public void onPageSelected(int position) {
        //修改全部的position长度
        int newPosition = position % viewList.size();

        //循环设置当前页的标记图
        int length = imageIdArray.length;
        for (int i = 0; i < length; i++) {
            ivPointArray[newPosition].setBackgroundResource(R.mipmap.full_holo);
            if (newPosition != i) {
                ivPointArray[i].setBackgroundResource(R.mipmap.empty_holo);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

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
