package com.sdjr.mdq.ui.jdrz;

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
import com.sdjr.mdq.bean.JDRZ2Bean;
import com.sdjr.mdq.bean.JDRZ3Bean;
import com.sdjr.mdq.bean.JDRZBean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.ui.gywm.GYWMActivity;
import com.sdjr.mdq.ui.sfrz.SFRZActivity;
import com.sdjr.mdq.ui.sqjk.DTBDContract;
import com.sdjr.mdq.ui.sqjk.DTBDPresreter;
import com.sdjr.mdq.ui.tbrz.TBRZActivity;
import com.sdjr.mdq.ui.xlrz.XLRZActivity;
import com.sdjr.mdq.ui.xykrz.XYKRZActivity;
import com.sdjr.mdq.ui.xzlx.XZLXActivity;
import com.sdjr.mdq.ui.yhrz.YHRZActivity;
import com.sdjr.mdq.ui.yys.YYSActivity;
import com.sdjr.mdq.ui.zm.ZMFActivity;
import com.sdjr.mdq.widget.LoadingDialog;
import com.sdjr.mdq.widget.Zz;

import butterknife.Bind;
import butterknife.ButterKnife;

public class JDRZActivity extends AppCompatActivity implements JDRZContract.View, DTBDContract.View {
    @Bind(R.id.jdrz_btn)
    Button jdrzBtn;
    @Bind(R.id.jdrz_edt1)
    EditText jdrzEdt1;
    @Bind(R.id.jdrz_edt2)
    EditText jdrzEdt2;
    @Bind(R.id.jdrz_edt3)
    EditText jdrzEdt3;
    @Bind(R.id.jdrz_text1)
    TextView jdrzText1;
    private ImageView jdrzimg01;
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
        setContentView(R.layout.activity_jdrz);
        ButterKnife.bind(this);
        loadingDialog = new LoadingDialog(this);
        jdrzimg01 = (ImageView) findViewById(R.id.jdrz_img01);
        initView();

    }

    public void initView() {
        jdrzText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UrlConfig.web = 2;
                Intent intent = new Intent(JDRZActivity.this, GYWMActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id",28);
                bundle.putString("name","常见问题");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        jdrzimg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JDRZActivity.this.finish();
            }
        });
        jdrzBtn.setOnClickListener(new View.OnClickListener() {
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
            tel = jdrzEdt1.getText().toString().trim();    //获取当前输入的用户名和密码信息
            pw = jdrzEdt2.getText().toString().trim();
            if (Zz.isMobileNO(tel)) {

            }
            loadingDialog.show();
            JDRZPresreter presreter = new JDRZPresreter(this, tel, pw, params, token, code);
            presreter.getData();
        }
    }

    public void login2() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid2()) {
            tel = jdrzEdt1.getText().toString().trim();    //获取当前输入的用户名和密码信息
            pw = jdrzEdt2.getText().toString().trim();
            code = jdrzEdt3.getText().toString().trim();
            if (Zz.isMobileNO(tel)) {

            }
            loadingDialog.show();
            JDRZPresreter presreter = new JDRZPresreter(this, tel, pw, params, token, code);
            presreter.getData3();
        }
    }

    public boolean isUserNameAndPwdValid() {
        if (jdrzEdt1.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入账号",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (jdrzEdt2.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入密码",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public boolean isUserNameAndPwdValid2() {
        if (jdrzEdt1.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入账号",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (jdrzEdt2.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入密码",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (jdrzEdt3.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入验证码",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onResponse(JDRZBean jdrzBean) {
        params = jdrzBean.getInfo().getParams();
        token = jdrzBean.getInfo().getToken();
        JDRZPresreter presreter = new JDRZPresreter(this, tel, pw, params, token, code);
        presreter.getData2();
    }

    @Override
    public void onResponse2(JDRZ2Bean jdrz2Bean) {
        stat = Integer.parseInt(jdrz2Bean.getStat());
        if (jdrz2Bean.getStat().equals("3")) {
            JDRZPresreter presreter = new JDRZPresreter(this, tel, pw, params, token, code);
            presreter.getData2();
        } else if (jdrz2Bean.getStat().equals("1")) {
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            jdrzEdt3.setVisibility(View.VISIBLE);
        } else if (jdrz2Bean.getStat().equals("2")) {
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            DTBDPresreter presreter = new DTBDPresreter(JDRZActivity.this, activity);
            presreter.getData();
            Toast.makeText(this, "恭喜您，认证成功", Toast.LENGTH_SHORT).show();
        }else if (jdrz2Bean.getStat().equals("0")){
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            stat = 8;
            Toast.makeText(this, "用户名或密码不匹配，请重新输入", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse3(JDRZ3Bean jdrz3Bean) {
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
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
                JDRZActivity.this.finish();
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, SFRZActivity.class);
                JDRZActivity.this.finish();
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(this, ZMFActivity.class);
                JDRZActivity.this.finish();
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(this, YYSActivity.class);
                JDRZActivity.this.finish();
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(this, TBRZActivity.class);
                JDRZActivity.this.finish();
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(this, JDRZActivity.class);
                JDRZActivity.this.finish();
                startActivity(intent);
                break;
            case 7:
                intent = new Intent(this, XLRZActivity.class);
                JDRZActivity.this.finish();
                startActivity(intent);
                break;
            case 8:
                intent = new Intent(this, YHRZActivity.class);
                JDRZActivity.this.finish();
                startActivity(intent);
                break;
            case 9:
                intent = new Intent(this, XYKRZActivity.class);
                JDRZActivity.this.finish();
                startActivity(intent);
                break;
            case 10:
                JDRZActivity.this.finish();
                break;
        }
    }

    @Override
    public void onFailure(String s) {

    }
}
