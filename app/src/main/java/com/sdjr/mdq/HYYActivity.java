package com.sdjr.mdq;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.ui.YDYActivity;

public class HYYActivity extends AppCompatActivity {
    private SharedPreferences login_sp;

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
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_hyy);
        login_sp = getSharedPreferences("userInfo", 0);
        String name = login_sp.getString("YDY", "");
        login_sp = getSharedPreferences("userInfo", 0);
        UrlConfig.login = login_sp.getInt("loginid", 0);
        if (name.equals("")){
            Intent intent = new Intent(HYYActivity.this, YDYActivity.class);
            startActivity(intent);
        }else{
            Handler handler = new Handler();
            //当计时结束,跳转至主界面
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(HYYActivity.this, MainActivity.class);
                    HYYActivity.this.finish();
                    startActivity(intent);
                }
            }, 3000);
        }
        }
    }
