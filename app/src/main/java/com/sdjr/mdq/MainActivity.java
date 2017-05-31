package com.sdjr.mdq;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sdjr.mdq.ui.qyxx.LXR2;
import com.sdjr.mdq.ui.rz.GDRZFragment;
import com.sdjr.mdq.ui.hyzx.HYZXFragment;
import com.sdjr.mdq.ui.sqjk.sqjkFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.main_framelayout)
    FrameLayout mainFramelayout;
    @Bind(R.id.main_home)
    ImageView mainHome;
    @Bind(R.id.main_home_text)
    TextView mainHomeText;
    @Bind(R.id.main_home_lin)
    LinearLayout mainHomeLin;
    @Bind(R.id.main_my)
    ImageView mainMy;
    @Bind(R.id.main_my_text)
    TextView mainMyText;
    @Bind(R.id.main_my_lin)
    LinearLayout mainMyLin;
    @Bind(R.id.main_linear)
    LinearLayout mainLinear;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;
    @Bind(R.id.main_adcice)
    ImageView mainAdcice;
    @Bind(R.id.main_adcice_text)
    TextView mainAdciceText;
    @Bind(R.id.main_advice_lin)
    LinearLayout mainAdviceLin;
    private FragmentManager manager;
    private long time;
    private Context mContext;
    private sqjkFragment sqjkFragment;
    private HYZXFragment hyzxFragment;
    private GDRZFragment gdrzFragment;

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
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = getApplicationContext();
        InitView();
    }

    private void InitView() {
        manager = getSupportFragmentManager();
        Switchfragment(0);
    }

    //切换碎片的方法,根据索引对碎片进行切换
    private void Switchfragment(int index) {
        //创建碎片管理器
        FragmentTransaction transaction = manager.beginTransaction();
        AddTransaction(transaction);
        //根据id对碎片进行切换 ,如果碎片开始为空 进行创建
        switch (index) {
            case 0:
                if (sqjkFragment == null) {
                    sqjkFragment = new sqjkFragment();
                    transaction.add(R.id.main_framelayout, sqjkFragment);
                } else {
                    transaction.show(sqjkFragment);
                }
                break;
            case 1:
                if (gdrzFragment == null) {
                    gdrzFragment = new GDRZFragment();
                    transaction.add(R.id.main_framelayout, gdrzFragment);
                } else {
                    transaction.show(gdrzFragment);
                }
                break;
            case 2:
                if (hyzxFragment == null) {
                    hyzxFragment = new HYZXFragment();
                    transaction.add(R.id.main_framelayout, hyzxFragment);
                } else {
                    transaction.show(hyzxFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void AddTransaction(FragmentTransaction transaction) {
        if (sqjkFragment != null) {
            if (sqjkFragment.isVisible()) {
                transaction.hide(sqjkFragment);
            }
        }
        if (hyzxFragment != null) {
            transaction.hide(hyzxFragment);
        }
        if (gdrzFragment != null) {
            transaction.hide(gdrzFragment);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long time2 = System.currentTimeMillis();
            if (time2 - time > 3000) {
                Toast.makeText(this, "再次点击退出", Toast.LENGTH_SHORT).show();
                time = System.currentTimeMillis();
            } else {
                finish();
            }
        }
        return true;
    }

    @OnClick({R.id.main_home, R.id.main_home_text, R.id.main_home_lin, R.id.main_adcice, R.id.main_adcice_text, R.id.main_advice_lin, R.id.main_my, R.id.main_my_text, R.id.main_my_lin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_home:
                mainHome.setImageResource(R.mipmap.jiekuan);
                mainAdcice.setImageResource(R.mipmap.renzhenghui);
                mainMy.setImageResource(R.mipmap.userhui);
                mainHomeText.setTextColor(mContext.getResources().getColor(R.color.home));
                mainAdciceText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainMyText.setTextColor(mContext.getResources().getColor(R.color.home1));
                Switchfragment(0);
                break;
            case R.id.main_home_text:
                mainHome.setImageResource(R.mipmap.jiekuan);
                mainAdcice.setImageResource(R.mipmap.renzhenghui);
                mainMy.setImageResource(R.mipmap.userhui);
                mainHomeText.setTextColor(mContext.getResources().getColor(R.color.home));
                mainAdciceText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainMyText.setTextColor(mContext.getResources().getColor(R.color.home1));
                Switchfragment(0);
                break;
            case R.id.main_home_lin:
                mainHome.setImageResource(R.mipmap.jiekuan);
                mainAdcice.setImageResource(R.mipmap.renzhenghui);
                mainMy.setImageResource(R.mipmap.userhui);
                mainHomeText.setTextColor(mContext.getResources().getColor(R.color.home));
                mainAdciceText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainMyText.setTextColor(mContext.getResources().getColor(R.color.home1));
                Switchfragment(0);
                break;
            case R.id.main_adcice:
                mainHome.setImageResource(R.mipmap.jiekuanhui);
                mainAdcice.setImageResource(R.mipmap.renzheng);
                mainMy.setImageResource(R.mipmap.userhui);
                mainHomeText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainAdciceText.setTextColor(mContext.getResources().getColor(R.color.home));
                mainMyText.setTextColor(mContext.getResources().getColor(R.color.home1));
                Switchfragment(1);
                break;
            case R.id.main_adcice_text:
                mainHome.setImageResource(R.mipmap.jiekuanhui);
                mainAdcice.setImageResource(R.mipmap.renzheng);
                mainMy.setImageResource(R.mipmap.userhui);
                mainHomeText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainAdciceText.setTextColor(mContext.getResources().getColor(R.color.home));
                mainMyText.setTextColor(mContext.getResources().getColor(R.color.home1));
                Switchfragment(1);
                break;
            case R.id.main_advice_lin:
                mainHome.setImageResource(R.mipmap.jiekuanhui);
                mainAdcice.setImageResource(R.mipmap.renzheng);
                mainMy.setImageResource(R.mipmap.userhui);
                mainHomeText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainAdciceText.setTextColor(mContext.getResources().getColor(R.color.home));
                mainMyText.setTextColor(mContext.getResources().getColor(R.color.home1));
                Switchfragment(1);
                break;
            case R.id.main_my:
                mainHome.setImageResource(R.mipmap.jiekuanhui);
                mainAdcice.setImageResource(R.mipmap.renzhenghui);
                mainMy.setImageResource(R.drawable.userlan);
                mainHomeText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainAdciceText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainMyText.setTextColor(mContext.getResources().getColor(R.color.home));
                Switchfragment(2);
                break;
            case R.id.main_my_text:
                mainHome.setImageResource(R.mipmap.jiekuanhui);
                mainAdcice.setImageResource(R.mipmap.renzhenghui);
                mainMy.setImageResource(R.drawable.userlan);
                mainHomeText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainAdciceText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainMyText.setTextColor(mContext.getResources().getColor(R.color.home));
                Switchfragment(2);
                break;
            case R.id.main_my_lin:
                mainHome.setImageResource(R.mipmap.jiekuanhui);
                mainAdcice.setImageResource(R.mipmap.renzhenghui);
                mainMy.setImageResource(R.drawable.userlan);
                mainHomeText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainAdciceText.setTextColor(mContext.getResources().getColor(R.color.home1));
                mainMyText.setTextColor(mContext.getResources().getColor(R.color.home));
                Switchfragment(2);
                break;
        }
    }

    //黄油刀解绑
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
