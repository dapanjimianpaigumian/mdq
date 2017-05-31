package com.sdjr.mdq.ui.xykrz;

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
import com.sdjr.mdq.bean.XYKRZ2Bean;
import com.sdjr.mdq.bean.XYKRZ3Bean;
import com.sdjr.mdq.bean.XYKRZBean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.ui.gywm.GYWMActivity;
import com.sdjr.mdq.ui.jdrz.JDRZActivity;
import com.sdjr.mdq.ui.sfrz.SFRZActivity;
import com.sdjr.mdq.ui.sqjk.DTBDContract;
import com.sdjr.mdq.ui.sqjk.DTBDPresreter;
import com.sdjr.mdq.ui.tbrz.TBRZActivity;
import com.sdjr.mdq.ui.xlrz.XLRZActivity;
import com.sdjr.mdq.ui.xzlx.XZLXActivity;
import com.sdjr.mdq.ui.yhrz.YHRZActivity;
import com.sdjr.mdq.ui.yys.YYSActivity;
import com.sdjr.mdq.ui.zm.ZMFActivity;
import com.sdjr.mdq.widget.LoadingDialog;
import com.sdjr.mdq.widget.Zz;

import butterknife.Bind;
import butterknife.ButterKnife;

public class XYKRZActivity extends AppCompatActivity implements XYKRZContract.View, DTBDContract.View {
    @Bind(R.id.xykrz_btn)
    Button xykrzBtn;
    @Bind(R.id.xykrz_edt1)
    EditText xykrzEdt1;
    @Bind(R.id.xykrz_edt2)
    EditText xykrzEdt2;
    @Bind(R.id.xykrz_edt3)
    EditText xykrzEdt3;
    @Bind(R.id.xykrz_text1)
    TextView xykrzText1;
    private ImageView xykrzimg01;
    private String tel, pw, code;
    private String params, token;
    private int stat = 8;
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
        setContentView(R.layout.activity_xykrz);
        ButterKnife.bind(this);
        xykrzimg01 = (ImageView) findViewById(R.id.xykrz_img01);
        loadingDialog = new LoadingDialog(this);
        initView();
    }

    public void initView() {
        xykrzText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UrlConfig.web = 2;
                Intent intent = new Intent(XYKRZActivity.this, GYWMActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id",46);
                bundle.putString("name","常见问题");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        xykrzimg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XYKRZActivity.this.finish();
            }
        });
        xykrzBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stat == 8) {
                    login();
                } else if (stat == 1) {
                    login2();
                }
            }
        });
    }

    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
            tel = xykrzEdt1.getText().toString().trim();    //获取当前输入的用户名和密码信息
            pw = xykrzEdt2.getText().toString().trim();
            if (Zz.isMobileNO(tel)) {

            }
            loadingDialog.show();
            XYKRZPresreter presreter = new XYKRZPresreter(this, tel, pw, params, token, code);
            presreter.getData();
        }
    }

    public void login2() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid2()) {
            tel = xykrzEdt1.getText().toString().trim();    //获取当前输入的用户名和密码信息
            pw = xykrzEdt2.getText().toString().trim();
            code = xykrzEdt3.getText().toString().trim();
            if (Zz.isMobileNO(tel)) {

            }
            loadingDialog.show();
            XYKRZPresreter presreter = new XYKRZPresreter(this, tel, pw, params, token, code);
            presreter.getData3();
        }
    }

    public boolean isUserNameAndPwdValid() {
        if (xykrzEdt1.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入账号",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (xykrzEdt2.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入密码",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public boolean isUserNameAndPwdValid2() {
        if (xykrzEdt1.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入账号",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (xykrzEdt2.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入密码",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (xykrzEdt3.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入验证码",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onResponse(XYKRZBean xykrzBean) {
        params = xykrzBean.getInfo().getParams();
        token = xykrzBean.getInfo().getToken();
        XYKRZPresreter presreter = new XYKRZPresreter(this, tel, pw, params, token, code);
        presreter.getData2();
    }

    @Override
    public void onResponse2(XYKRZ2Bean xykrz2Bean) {
        stat = Integer.parseInt(xykrz2Bean.getStat());
        if (xykrz2Bean.getStat().equals("3")) {
            XYKRZPresreter presreter = new XYKRZPresreter(this, tel, pw, params, token, code);
            presreter.getData2();
        } else if (xykrz2Bean.getStat().equals("1")) {
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            xykrzEdt3.setVisibility(View.VISIBLE);
        } else if (xykrz2Bean.getStat().equals("2")) {
            DTBDPresreter presreter = new DTBDPresreter(XYKRZActivity.this, activity);
            presreter.getData();
            Toast.makeText(this, "恭喜您，认证成功", Toast.LENGTH_SHORT).show();
        }else if (xykrz2Bean.getStat().equals("0")){
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            stat = 8;
            Toast.makeText(this, "用户名或密码不匹配，请重新输入", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse3(XYKRZ3Bean xykrz3Bean) {

    }

    @Override
    public void onResponse(DTBDBean dtbdBean) {
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
        UrlConfig.start = Integer.parseInt(dtbdBean.getInfo());
        switch (UrlConfig.start) {
            case 1:
                Intent intent = new Intent(this, XZLXActivity.class);
                XYKRZActivity.this.finish();
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, SFRZActivity.class);
                XYKRZActivity.this.finish();
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(this, ZMFActivity.class);
                XYKRZActivity.this.finish();
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(this, YYSActivity.class);
                XYKRZActivity.this.finish();
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(this, TBRZActivity.class);
                XYKRZActivity.this.finish();
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(this, JDRZActivity.class);
                XYKRZActivity.this.finish();
                startActivity(intent);
                break;
            case 7:
                intent = new Intent(this, XLRZActivity.class);
                XYKRZActivity.this.finish();
                startActivity(intent);
                break;
            case 8:
                intent = new Intent(this, YHRZActivity.class);
                XYKRZActivity.this.finish();
                startActivity(intent);
                break;
            case 9:
                intent = new Intent(this, XYKRZActivity.class);
                XYKRZActivity.this.finish();
                startActivity(intent);
                break;
            case 10:
                Toast.makeText(this, "认证成功", Toast.LENGTH_SHORT).show();
                XYKRZActivity.this.finish();
                break;
        }
    }

    @Override
    public void onFailure(String s) {

    }
}
