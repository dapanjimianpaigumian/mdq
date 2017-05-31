package com.sdjr.mdq.ui.xlrz;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sdjr.mdq.R;
import com.sdjr.mdq.bean.DTBDBean;
import com.sdjr.mdq.bean.XLRZ2Bean;
import com.sdjr.mdq.bean.XLRZBean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.ui.gywm.GYWMActivity;
import com.sdjr.mdq.ui.jdrz.JDRZActivity;
import com.sdjr.mdq.ui.sfrz.SFRZActivity;
import com.sdjr.mdq.ui.sqjk.DTBDContract;
import com.sdjr.mdq.ui.sqjk.DTBDPresreter;
import com.sdjr.mdq.ui.tbrz.TBRZActivity;
import com.sdjr.mdq.ui.xykrz.XYKRZActivity;
import com.sdjr.mdq.ui.xzlx.XZLXActivity;
import com.sdjr.mdq.ui.yhrz.YHRZActivity;
import com.sdjr.mdq.ui.yys.YYSActivity;
import com.sdjr.mdq.ui.zm.ZMFActivity;
import com.sdjr.mdq.widget.LoadingDialog;
import com.sdjr.mdq.widget.Zz;

import butterknife.Bind;
import butterknife.ButterKnife;

public class XLRZActivity extends AppCompatActivity implements XLRZContract.View, DTBDContract.View {
    @Bind(R.id.xlrz_btn)
    Button xlrzBtn;
    @Bind(R.id.xlrz_edt1)
    EditText xlrzEdt1;
    @Bind(R.id.xlrz_edt2)
    EditText xlrzEdt2;
    @Bind(R.id.xlrz_text1)
    TextView xlrzText1;
    private ImageView xlrzimg01;
    private String tel, pw;
    private String params, token;
    private LoadingDialog loadingDialog;
    private Context activity;

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
        setContentView(R.layout.activity_xlrz);
        ButterKnife.bind(this);
        loadingDialog = new LoadingDialog(this);
        xlrzimg01 = (ImageView) findViewById(R.id.xlrz_img01);
        initView();
    }

    public void initView() {
        xlrzText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UrlConfig.web = 2;
                Intent intent = new Intent(XLRZActivity.this, GYWMActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id",50);
                bundle.putString("name","常见问题");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        xlrzimg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XLRZActivity.this.finish();
            }
        });
        xlrzBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
            tel = xlrzEdt1.getText().toString().trim();    //获取当前输入的用户名和密码信息
            pw = xlrzEdt2.getText().toString().trim();
            if (Zz.isMobileNO(tel)) {

            }
            loadingDialog.show();
            XLRZPresreter presreter = new XLRZPresreter(this, tel, pw, params, token);
            presreter.getData();
        }
    }

    public boolean isUserNameAndPwdValid() {
        if (xlrzEdt1.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入账号",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (xlrzEdt2.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入密码",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onResponse(XLRZBean xlrzBean) {
        params = xlrzBean.getInfo().getParams();
        token = xlrzBean.getInfo().getToken();
        XLRZPresreter presreter = new XLRZPresreter(this, tel, pw, params, token);
        presreter.getData2();
    }

    @Override
    public void onResponse2(XLRZ2Bean xlrz2Bean) {
        if (xlrz2Bean.getStat().equals("3")) {
            XLRZPresreter presreter = new XLRZPresreter(this, tel, pw, params, token);
            presreter.getData2();
        } else if (xlrz2Bean.getStat().equals("2")) {
            DTBDPresreter presreter = new DTBDPresreter(XLRZActivity.this, activity);
            presreter.getData();
        }else if (xlrz2Bean.getStat().equals("0")){
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            Toast.makeText(this, "用户名或密码不匹配，请重新输入", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse(DTBDBean dtbdBean) {
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
        UrlConfig.start = Integer.parseInt(dtbdBean.getInfo());
        switch (UrlConfig.start){
            case 1:
                Intent intent = new Intent(this, XZLXActivity.class);
                XLRZActivity.this.finish();
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, SFRZActivity.class);
                XLRZActivity.this.finish();
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(this, ZMFActivity.class);
                XLRZActivity.this.finish();
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(this, YYSActivity.class);
                XLRZActivity.this.finish();
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(this, TBRZActivity.class);
                XLRZActivity.this.finish();
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(this, JDRZActivity.class);
                XLRZActivity.this.finish();
                startActivity(intent);
                break;
            case 7:
                intent = new Intent(this, XLRZActivity.class);
                XLRZActivity.this.finish();
                startActivity(intent);
                break;
            case 8:
                intent = new Intent(this, YHRZActivity.class);
                XLRZActivity.this.finish();
                startActivity(intent);
                break;
            case 9:
                intent = new Intent(this, XYKRZActivity.class);
                XLRZActivity.this.finish();
                startActivity(intent);
                break;
            case 10:
                XLRZActivity.this.finish();
                Toast.makeText(this, "认证成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onFailure(String s) {

    }
}
