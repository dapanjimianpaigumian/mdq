package com.sdjr.mdq.ui.sfrz;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sdjr.mdq.R;
import com.sdjr.mdq.bean.DTBDBean;
import com.sdjr.mdq.bean.JDBean;
import com.sdjr.mdq.bean.WSBean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.ui.grxx.GRXXActivity;
import com.sdjr.mdq.ui.grxx2.GRXX2Activity;
import com.sdjr.mdq.ui.jdrz.JDRZActivity;
import com.sdjr.mdq.ui.qyxx.QYXXActivity;
import com.sdjr.mdq.ui.sfrz2.SFRZ2Activity;
import com.sdjr.mdq.ui.sqjk.DTBDContract;
import com.sdjr.mdq.ui.sqjk.DTBDPresreter;
import com.sdjr.mdq.ui.tbrz.TBRZActivity;
import com.sdjr.mdq.ui.ws.WSContract;
import com.sdjr.mdq.ui.ws.WSPresreter;
import com.sdjr.mdq.ui.xlrz.XLRZActivity;
import com.sdjr.mdq.ui.xykrz.XYKRZActivity;
import com.sdjr.mdq.ui.xzlx.XZLXActivity;
import com.sdjr.mdq.ui.yhrz.YHRZActivity;
import com.sdjr.mdq.ui.yys.YYSActivity;
import com.sdjr.mdq.ui.zm.ZMFActivity;
import com.sdjr.mdq.widget.LoadingDialog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SFRZActivity extends AppCompatActivity implements DTBDContract.View, WSContract.View,JieDianContract.View {
    @Bind(R.id.sfrz_lin1)
    RelativeLayout sfrzLin1;
    @Bind(R.id.sfrz_lin2)
    RelativeLayout sfrzLin2;
    @Bind(R.id.sfrz_lin3)
    RelativeLayout sfrzLin3;
    @Bind(R.id.sfrz_lin4)
    RelativeLayout sfrzLin4;
    @Bind(R.id.xzlx_btn4)
    Button xzlxBtn4;
    @Bind(R.id.sfrz_text3)
    TextView sfrzText3;
    @Bind(R.id.sfrz_img2)
    ImageView sfrzImg2;
    @Bind(R.id.sfrz_text_ws3)
    TextView sfrzTextWs3;
    @Bind(R.id.sfrz_img2_ws2)
    ImageView sfrzImg2Ws2;
    @Bind(R.id.sfrz_text6)
    TextView sfrzText6;
    @Bind(R.id.sfrz_img4)
    ImageView sfrzImg4;
    @Bind(R.id.sfrz_text_ws6)
    TextView sfrzTextWs6;
    @Bind(R.id.sfrz_img2_ws4)
    ImageView sfrzImg2Ws4;
    @Bind(R.id.sfrz_text9)
    TextView sfrzText9;
    @Bind(R.id.sfrz_img6)
    ImageView sfrzImg6;
    @Bind(R.id.sfrz_text_ws9)
    TextView sfrzTextWs9;
    @Bind(R.id.sfrz_img_ws6)
    ImageView sfrzImgWs6;
    @Bind(R.id.sfrz_text12)
    TextView sfrzText12;
    @Bind(R.id.sfrz_img8)
    ImageView sfrzImg8;
    @Bind(R.id.sfrz_text_ws12)
    TextView sfrzTextWs12;
    @Bind(R.id.sfrz_img_ws8)
    ImageView sfrzImgWs8;
    private ImageView sfrzimg01;
    private String grxx, qyxx, gzxx, zpsc;
    private LoadingDialog loadingDialog;
    private Context activity;
    private int s1,s2,s3,s4;

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
        setContentView(R.layout.activity_sfrz);
        ButterKnife.bind(this);
        loadingDialog = new LoadingDialog(this);
        WSPresreter presreter = new WSPresreter(this);
        presreter.getData();
        sfrzimg01 = (ImageView) findViewById(R.id.sfrz_img01);
        if (UrlConfig.step1 == 1) {
            sfrzLin1.setVisibility(View.GONE);
        }
        if (UrlConfig.step2 == 1) {
            sfrzLin2.setVisibility(View.GONE);
        }
        if (UrlConfig.step3 == 1) {
            sfrzLin4.setVisibility(View.GONE);
        }
        if (UrlConfig.step4 == 1) {
            sfrzLin3.setVisibility(View.GONE);
        }
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        WSPresreter presreter = new WSPresreter(this);
        presreter.getData();
    }

    public void initView() {
        sfrzimg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SFRZActivity.this.finish();
            }
        });
        sfrzLin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (s1 == 1){
                    Intent intent = new Intent(SFRZActivity.this, GRXX2Activity.class);
                    startActivity(intent);
                }else if (s1 == 2){
                    Toast.makeText(SFRZActivity.this, "信息已完善，不可重复提交", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sfrzLin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (s3 == 1){
                    Intent intent = new Intent(SFRZActivity.this, SFRZ2Activity.class);
                    startActivity(intent);
                }else if (s3 == 2){
                    Toast.makeText(SFRZActivity.this, "信息已完善，不可重复提交", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sfrzLin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (s2 == 1){
                    Intent intent = new Intent(SFRZActivity.this, QYXXActivity.class);
                    startActivity(intent);
                }else if (s2 == 2){
                    Toast.makeText(SFRZActivity.this, "信息已完善，不可重复提交", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sfrzLin4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (s4 == 1){
                    Intent intent = new Intent(SFRZActivity.this, GRXXActivity.class);
                    startActivity(intent);
                }else if (s4 == 2){
                    Toast.makeText(SFRZActivity.this, "信息已完善，不可重复提交", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @OnClick({ R.id.xzlx_btn4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xzlx_btn4:
                loadingDialog.show();
                JieDianPresreter presreter = new JieDianPresreter(this);
                presreter.getData();
                break;
        }
    }

    @Override
    public void onResponse(DTBDBean dtbdBean) {
        loadingDialog.show();
        UrlConfig.start = Integer.parseInt(dtbdBean.getInfo());
        switch (UrlConfig.start) {
            case 1:
                Intent intent = new Intent(this, XZLXActivity.class);
                SFRZActivity.this.finish();
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, SFRZActivity.class);
                SFRZActivity.this.finish();
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(this, ZMFActivity.class);
                SFRZActivity.this.finish();
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(this, YYSActivity.class);
                SFRZActivity.this.finish();
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(this, TBRZActivity.class);
                SFRZActivity.this.finish();
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(this, JDRZActivity.class);
                SFRZActivity.this.finish();
                startActivity(intent);
                break;
            case 7:
                intent = new Intent(this, XLRZActivity.class);
                SFRZActivity.this.finish();
                startActivity(intent);
                break;
            case 8:
                intent = new Intent(this, YHRZActivity.class);
                SFRZActivity.this.finish();
                startActivity(intent);
                break;
            case 9:
                intent = new Intent(this, XYKRZActivity.class);
                SFRZActivity.this.finish();
                startActivity(intent);
                break;
            case 10:
                Toast.makeText(this, "您的基本认证已完成", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onResponse(WSBean wsBean) {
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
        String str = wsBean.getInfo();
        char[] chs = str.toCharArray();
        grxx = String.valueOf(chs[0]);
        qyxx = String.valueOf(chs[1]);
        gzxx = String.valueOf(chs[2]);
        zpsc = String.valueOf(chs[3]);
        if (UrlConfig.step1 == 1) {
            sfrzLin1.setVisibility(View.GONE);
        } else {
            if (grxx.equals("1")) {
                s1 = 1;
                sfrzText3.setVisibility(View.VISIBLE);
                sfrzImg2.setVisibility(View.VISIBLE);
                sfrzTextWs3.setVisibility(View.GONE);
                sfrzImg2Ws2.setVisibility(View.GONE);
            }else {
                s1 = 2;
                sfrzText3.setVisibility(View.GONE);
                sfrzImg2.setVisibility(View.GONE);
                sfrzTextWs3.setVisibility(View.VISIBLE);
                sfrzImg2Ws2.setVisibility(View.VISIBLE);
            }
        }
        if (UrlConfig.step2 == 1) {
            sfrzLin2.setVisibility(View.GONE);
        }else {
            if (qyxx.equals("1")){
                s2 = 1;
                sfrzText6.setVisibility(View.VISIBLE);
                sfrzImg4.setVisibility(View.VISIBLE);
                sfrzTextWs6.setVisibility(View.GONE);
                sfrzImg2Ws4.setVisibility(View.GONE);
            }else {
                s2 = 2;
                sfrzText6.setVisibility(View.GONE);
                sfrzImg4.setVisibility(View.GONE);
                sfrzTextWs6.setVisibility(View.VISIBLE);
                sfrzImg2Ws4.setVisibility(View.VISIBLE);
            }
        }
        if (UrlConfig.step3 == 1) {
            sfrzLin4.setVisibility(View.GONE);
        }else {
            if (zpsc.equals("1")){
                s3 = 1;
                sfrzText9.setVisibility(View.VISIBLE);
                sfrzImg6.setVisibility(View.VISIBLE);
                sfrzTextWs9.setVisibility(View.GONE);
                sfrzImgWs6.setVisibility(View.GONE);
            }else {
                s3 = 2;
                sfrzText9.setVisibility(View.GONE);
                sfrzImg6.setVisibility(View.GONE);
                sfrzTextWs9.setVisibility(View.VISIBLE);
                sfrzImgWs6.setVisibility(View.VISIBLE);
            }
        }
        if (UrlConfig.step4 == 1) {
            sfrzLin3.setVisibility(View.GONE);
        }else {
            if (gzxx.equals("1")){
                s4 = 1;
                sfrzText12.setVisibility(View.VISIBLE);
                sfrzImg8.setVisibility(View.VISIBLE);
                sfrzTextWs12.setVisibility(View.GONE);
                sfrzImgWs8.setVisibility(View.GONE);
            }else {
                s4 = 2;
                sfrzText12.setVisibility(View.GONE);
                sfrzImg8.setVisibility(View.GONE);
                sfrzTextWs12.setVisibility(View.VISIBLE);
                sfrzImgWs8.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onResponse(JDBean jdBean) {
        DTBDPresreter presreter = new DTBDPresreter(SFRZActivity.this,activity);
        presreter.getData();
    }

    @Override
    public void onFailure(String s) {

    }
}