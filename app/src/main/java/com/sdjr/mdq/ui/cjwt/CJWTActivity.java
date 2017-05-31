package com.sdjr.mdq.ui.cjwt;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.sdjr.mdq.R;
import com.sdjr.mdq.bean.CJWTBean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.ui.gywm.GYWMActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CJWTActivity extends AppCompatActivity implements CJWTContract.View{
    @Bind(R.id.cjwt)
    TextView cjwt;
    @Bind(R.id.cjwt_list)
    ListView cjwtList;
    private ImageView cjwtimg01;
    private List<CJWTBean.InfoBean> list = new ArrayList<>();
    private CJWTAdapter adapter;

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
        setContentView(R.layout.activity_cjwt);
        ButterKnife.bind(this);
        cjwtimg01 = (ImageView) findViewById(R.id.cjwt_img01);
        initView();
        CJWTPresreter presreter = new CJWTPresreter(this);
        presreter.getData();
        adapter = new CJWTAdapter(this, list);
        cjwtList.setAdapter(adapter);
        cjwtList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                UrlConfig.web = 1 ;
                Intent intent = new Intent(CJWTActivity.this, GYWMActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("URL",list.get(i).getUrl());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    public void initView() {
        cjwtimg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CJWTActivity.this.finish();
            }
        });
    }

    @Override
    public void onResponse(CJWTBean cjwtBean) {
        adapter.reload(cjwtBean.getInfo());
    }

    @Override
    public void onFailure(String s) {

    }
}
