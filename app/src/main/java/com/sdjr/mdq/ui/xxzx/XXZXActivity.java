package com.sdjr.mdq.ui.xxzx;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.sdjr.mdq.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class XXZXActivity extends AppCompatActivity {
    @Bind(R.id.xxzx_img01)
    ImageView xxzxImg01;
//    @Bind(R.id.xxzx_tab)
//    TabLayout xxzxTab;
//    @Bind(R.id.xxzx_pager)
//    ViewPager xxzxPager;
//    private String[] arrTabTitle = null;
//    private List<Fragment> fragmentlist = new ArrayList<>();
//    private HYXXPagerAdapter adapter;

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
        setContentView(R.layout.activity_xxzx);
        ButterKnife.bind(this);
        xxzxImg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XXZXActivity.this.finish();
            }
        });
    }


//    private void initDate() {
//        arrTabTitle = getResources().getStringArray(R.array.wdysdTab);
//        XTGGFragment xtggFragment = new XTGGFragment();
//        JKTZFragment jktzFragment = new JKTZFragment();
//        fragmentlist.add(xtggFragment);
//        fragmentlist.add(jktzFragment);
//        xxzxTab.setTabMode(xxzxTab.MODE_FIXED);
//        xxzxTab.addTab(xxzxTab.newTab().setTag(arrTabTitle[0]));
//        xxzxTab.addTab(xxzxTab.newTab().setTag(arrTabTitle[1]));
//        adapter = new HYXXPagerAdapter(getSupportFragmentManager(), fragmentlist, arrTabTitle);
//        xxzxPager.setAdapter(adapter);
//        xxzxTab.setupWithViewPager(xxzxPager);
//    }
}
