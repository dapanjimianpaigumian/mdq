package com.sdjr.mdq.ui.yhrz;

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
import com.sdjr.mdq.bean.YHRZ2Bean;
import com.sdjr.mdq.bean.YHRZBean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.ui.gywm.GYWMActivity;
import com.sdjr.mdq.ui.jdrz.JDRZActivity;
import com.sdjr.mdq.ui.sfrz.SFRZActivity;
import com.sdjr.mdq.ui.sqjk.DTBDContract;
import com.sdjr.mdq.ui.sqjk.DTBDPresreter;
import com.sdjr.mdq.ui.tbrz.TBRZActivity;
import com.sdjr.mdq.ui.xlrz.XLRZActivity;
import com.sdjr.mdq.ui.xykrz.XYKRZActivity;
import com.sdjr.mdq.ui.xzlx.XZLXActivity;
import com.sdjr.mdq.ui.yys.YYSActivity;
import com.sdjr.mdq.ui.zm.ZMFActivity;
import com.sdjr.mdq.widget.LoadingDialog;
import com.sdjr.mdq.widget.Zz;

import butterknife.Bind;
import butterknife.ButterKnife;

public class YHRZActivity extends AppCompatActivity implements YHRZContract.View, DTBDContract.View {
    @Bind(R.id.yhrz_btn)
    Button yhrzBtn;
    @Bind(R.id.yhrz_edt1)
    EditText yhrzEdt1;
    @Bind(R.id.yhrz_edt2)
    EditText yhrzEdt2;
    @Bind(R.id.yhrz_edt3)
    EditText yhrzEdt3;
    @Bind(R.id.yhrz_text1)
    TextView yhrzText1;
    private ImageView yhrzimg01;
    private String tel, pw, idcode;
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
        setContentView(R.layout.activity_yhrz);
        ButterKnife.bind(this);
        loadingDialog = new LoadingDialog(this);
        yhrzimg01 = (ImageView) findViewById(R.id.yhrz_img01);

        initView();
    }

    public void initView() {
        yhrzText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UrlConfig.web = 2;
                Intent intent = new Intent(YHRZActivity.this, GYWMActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id",29);
                bundle.putString("name","常见问题");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        yhrzimg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YHRZActivity.this.finish();
            }
        });
        yhrzBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stat == 8) {
                    login2();
                } else if (stat == 1) {

                }
            }
        });
    }

    public void login2() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid2()) {
            tel = yhrzEdt1.getText().toString().trim();    //获取当前输入的用户名和密码信息
            pw = yhrzEdt2.getText().toString().trim();
            idcode = yhrzEdt3.getText().toString().trim();
            if (Zz.isMobileNO(tel)) {

            }
            loadingDialog.show();
            YHRZPresreter presreter = new YHRZPresreter(this, tel, pw, params, token, idcode);
            presreter.getData();
        }
    }

    public boolean isUserNameAndPwdValid2() {
        if (yhrzEdt1.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入央行账号",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (yhrzEdt2.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入央行密码",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (yhrzEdt3.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入验证码",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onResponse(YHRZBean yhrzBean) {
        params = yhrzBean.getInfo().getParams();
        token = yhrzBean.getInfo().getToken();
        YHRZPresreter presreter = new YHRZPresreter(this, tel, pw, params, token, idcode);
        presreter.getData2();
    }

    @Override
    public void onResponse2(YHRZ2Bean yhrz2bean) {
        stat = Integer.parseInt(yhrz2bean.getStat());
        if (yhrz2bean.getStat().equals("3")) {
            YHRZPresreter presreter = new YHRZPresreter(this, tel, pw, params, token, idcode);
            presreter.getData2();
        } else if (yhrz2bean.getStat().equals("2")) {
            DTBDPresreter presreter = new DTBDPresreter(YHRZActivity.this, activity);
            presreter.getData();
        }else if (yhrz2bean.getStat().equals("0")){
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            stat = 8;
            Toast.makeText(this, "用户名或密码不匹配，请重新输入", Toast.LENGTH_SHORT).show();
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
                YHRZActivity.this.finish();
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, SFRZActivity.class);
                YHRZActivity.this.finish();
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(this, ZMFActivity.class);
                YHRZActivity.this.finish();
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(this, YYSActivity.class);
                YHRZActivity.this.finish();
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(this, TBRZActivity.class);
                YHRZActivity.this.finish();
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(this, JDRZActivity.class);
                YHRZActivity.this.finish();
                startActivity(intent);
                break;
            case 7:
                intent = new Intent(this, XLRZActivity.class);
                YHRZActivity.this.finish();
                startActivity(intent);
                break;
            case 8:
                intent = new Intent(this, YHRZActivity.class);
                YHRZActivity.this.finish();
                startActivity(intent);
                break;
            case 9:
                intent = new Intent(this, XYKRZActivity.class);
                YHRZActivity.this.finish();
                startActivity(intent);
                break;
            case 10:
                Toast.makeText(this, "您的基本认证已完成", Toast.LENGTH_SHORT).show();
                YHRZActivity.this.finish();
                break;
        }
    }

    @Override
    public void onFailure(String s) {

    }
}
