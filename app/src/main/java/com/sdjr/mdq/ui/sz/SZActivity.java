package com.sdjr.mdq.ui.sz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sdjr.mdq.R;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.ui.login.LoginActivity;
import com.sdjr.mdq.ui.zc.ZCActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SZActivity extends AppCompatActivity {
    @Bind(R.id.sz_text1)
    TextView szText1;
    @Bind(R.id.sz_tcdl)
    Button szTcdl;
    private ImageView szimg01;
    private String page;
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
        setContentView(R.layout.activity_sz);
        ButterKnife.bind(this);
        szimg01 = (ImageView) findViewById(R.id.sz_img01);
        initView();
        szTcdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UrlConfig.login = 0;
                login_sp = getSharedPreferences("userInfo", 0);
                SharedPreferences.Editor editor =login_sp.edit();
                //保存用户名和密码

                editor.putInt("loginid", UrlConfig.login);
                editor.commit();
                Intent intent = new Intent(SZActivity.this, LoginActivity.class);
                SZActivity.this.finish();
                startActivity(intent);
            }
        });
    }

    public void initView() {
        szimg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SZActivity.this.finish();
            }
        });
        szText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page = "wj";
                Intent intent = new Intent(SZActivity.this, ZCActivity.class);
                SZActivity.this.finish();
                Bundle bundle = new Bundle();
                bundle.putString("page", page);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
