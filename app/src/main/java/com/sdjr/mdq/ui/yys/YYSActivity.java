package com.sdjr.mdq.ui.yys;

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
import com.sdjr.mdq.bean.YYS2Bean;
import com.sdjr.mdq.bean.YYS3Bean;
import com.sdjr.mdq.bean.YYSBean;
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
import com.sdjr.mdq.ui.yhrz.YHRZActivity;
import com.sdjr.mdq.ui.zm.ZMFActivity;
import com.sdjr.mdq.widget.LoadingDialog;
import com.sdjr.mdq.widget.Zz;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YYSActivity extends AppCompatActivity implements YYSContract.View, DTBDContract.View {

    @Bind(R.id.yys_img01)
    ImageView yysImg01;
    @Bind(R.id.yys_edt1)
    EditText yysEdt1;
    @Bind(R.id.yys_edt2)
    EditText yysEdt2;
    @Bind(R.id.yys_edt3)
    EditText yysEdt3;
    @Bind(R.id.jdrz_btn)
    Button jdrzBtn;
    @Bind(R.id.yys_edt4)
    EditText yysEdt4;
    @Bind(R.id.yys_edt5)
    EditText yysEdt5;
    @Bind(R.id.yys_text1)
    TextView yysText1;
    private String tel, pw, code, otherInfo;
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
        setContentView(R.layout.activity_yys);
        ButterKnife.bind(this);
        loadingDialog = new LoadingDialog(this);
        yysText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UrlConfig.web = 2;
                Intent intent = new Intent(YYSActivity.this, GYWMActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id",45);
                bundle.putString("name","常见问题");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @OnClick({R.id.yys_img01, R.id.jdrz_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.yys_img01:
                YYSActivity.this.finish();
                break;
            case R.id.jdrz_btn:
                if (stat == 8) {
                    login();
                } else if (stat == 1) {
                    login2();
                } else if (stat == 4) {
                    login3();
                } else if (stat == 5) {
                    login4();
                }
                break;
        }
    }

    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
            tel = yysEdt1.getText().toString().trim();    //获取当前输入的用户名和密码信息
            pw = yysEdt2.getText().toString().trim();
            if (Zz.isMobileNO(tel)) {

            }
            loadingDialog.show();
            YYSPresreter presreter = new YYSPresreter(this, tel, pw, params, token, code, otherInfo);
            presreter.getData();
        }
    }

    public void login2() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid2()) {
            tel = yysEdt1.getText().toString().trim();    //获取当前输入的用户名和密码信息
            pw = yysEdt2.getText().toString().trim();
            code = yysEdt3.getText().toString().trim();
            if (Zz.isMobileNO(tel)) {

            }
            loadingDialog.show();
            YYSPresreter presreter = new YYSPresreter(this, tel, pw, params, token, code, otherInfo);
            presreter.getData3();
        }
    }

    public void login3() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid3()) {
            tel = yysEdt1.getText().toString().trim();    //获取当前输入的用户名和密码信息
            pw = yysEdt2.getText().toString().trim();
            otherInfo = yysEdt4.getText().toString().trim();
            if (Zz.isMobileNO(tel)) {

            }
            loadingDialog.show();
            YYSPresreter presreter = new YYSPresreter(this, tel, pw, params, token, code, otherInfo);
            presreter.getData();
        }
    }

    public void login4() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid4()) {
            tel = yysEdt1.getText().toString().trim();    //获取当前输入的用户名和密码信息
            pw = yysEdt2.getText().toString().trim();
            otherInfo = yysEdt5.getText().toString().trim();
            if (Zz.isMobileNO(tel)) {

            }
            loadingDialog.show();
            YYSPresreter presreter = new YYSPresreter(this, tel, pw, params, token, code, otherInfo);
            presreter.getData();
        }
    }

    public boolean isUserNameAndPwdValid() {
        if (yysEdt1.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入手机号",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (yysEdt2.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入服务商密码",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public boolean isUserNameAndPwdValid2() {
        if (yysEdt1.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入手机号",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (yysEdt2.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入服务商密码",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (yysEdt3.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入验证码",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public boolean isUserNameAndPwdValid3() {
        if (yysEdt1.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入手机号",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (yysEdt2.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入服务商密码",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (yysEdt4.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入身份证号码",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public boolean isUserNameAndPwdValid4() {
        if (yysEdt1.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入手机号",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (yysEdt2.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入服务商密码",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (yysEdt5.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入客服密码",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onResponse(YYSBean yysBean) {
        params = yysBean.getInfo().getParams();
        token = yysBean.getInfo().getToken();
        YYSPresreter presreter = new YYSPresreter(this, tel, pw, params, token, code, otherInfo);
        presreter.getData2();
    }

    @Override
    public void onResponse2(YYS2Bean yys2Bean) {
        stat = Integer.parseInt(yys2Bean.getStat());
        if (yys2Bean.getStat().equals("3")) {
            YYSPresreter presreter = new YYSPresreter(this, tel, pw, params, token, code, otherInfo);
            presreter.getData2();
        } else if (yys2Bean.getStat().equals("1")) {
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            yysEdt3.setVisibility(View.VISIBLE);
            yysEdt4.setVisibility(View.GONE);
            yysEdt5.setVisibility(View.GONE);
        } else if (yys2Bean.getStat().equals("4")) {
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            Toast.makeText(this, "请输入身份证号", Toast.LENGTH_SHORT).show();
            yysEdt3.setVisibility(View.GONE);
            yysEdt4.setVisibility(View.VISIBLE);
            yysEdt5.setVisibility(View.GONE);
        } else if (yys2Bean.getStat().equals("5")) {
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            Toast.makeText(this, "请输入服务密码", Toast.LENGTH_SHORT).show();
            yysEdt3.setVisibility(View.GONE);
            yysEdt4.setVisibility(View.GONE);
            yysEdt5.setVisibility(View.VISIBLE);
        } else if (yys2Bean.getStat().equals("2")) {
            DTBDPresreter presreter = new DTBDPresreter(YYSActivity.this, activity);
            presreter.getData();
            Toast.makeText(this, "恭喜您，认证成功", Toast.LENGTH_SHORT).show();
        }else if (yys2Bean.getStat().equals("0")){
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            stat = 8;
            Toast.makeText(this, "用户名或密码不匹配，请重新输入", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse3(YYS3Bean yys3Bean) {
        if (yys3Bean.getStat().equals("1")) {
            YYSPresreter presreter = new YYSPresreter(this, tel, pw, params, token, code, otherInfo);
            presreter.getData2();
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
                YYSActivity.this.finish();
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, SFRZActivity.class);
                YYSActivity.this.finish();
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(this, ZMFActivity.class);
                YYSActivity.this.finish();
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(this, YYSActivity.class);
                YYSActivity.this.finish();
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(this, TBRZActivity.class);
                YYSActivity.this.finish();
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(this, JDRZActivity.class);
                YYSActivity.this.finish();
                startActivity(intent);
                break;
            case 7:
                intent = new Intent(this, XLRZActivity.class);
                YYSActivity.this.finish();
                startActivity(intent);
                break;
            case 8:
                intent = new Intent(this, YHRZActivity.class);
                YYSActivity.this.finish();
                startActivity(intent);
                break;
            case 9:
                intent = new Intent(this, XYKRZActivity.class);
                YYSActivity.this.finish();
                startActivity(intent);
                break;
            case 10:
                YYSActivity.this.finish();
                Toast.makeText(this, "您的基本认证已完成", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onFailure(String s) {

    }
}
