package com.sdjr.mdq.ui.zc;

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
import com.sdjr.mdq.bean.YZMBean;
import com.sdjr.mdq.bean.ZCBean;
import com.sdjr.mdq.ui.login.LoginActivity;
import com.sdjr.mdq.widget.TimeButton;
import com.sdjr.mdq.widget.Zz;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZCActivity extends AppCompatActivity implements View.OnClickListener, YZMContract.View, ZCContract.View {
    @Bind(R.id.timebutton)
    TimeButton timebutton;
    @Bind(R.id.zc_edt1)
    EditText zcEdt1;
    @Bind(R.id.zc_edt2)
    EditText zcEdt2;
    @Bind(R.id.zc_edt3)
    EditText zcEdt3;
    @Bind(R.id.zc_edt4)
    EditText zcEdt4;
    @Bind(R.id.zc_btn)
    Button zcBtn;
    @Bind(R.id.zc_name)
    TextView zcName;
    private ImageView zcimg01;
    private String zcEdt11, zcEdt33, zcEdt44;
    private int yzm, zcEdt22;
    private String page;

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
        setContentView(R.layout.activity_zc);
        Bundle bundle = this.getIntent().getExtras();
        page = bundle.getString("page");
        ButterKnife.bind(this);
        if (page.equals("zc")){
            zcName.setText("注册");
        }else if (page.equals("wj")){
            zcName.setText("忘记密码");
        }
        zcimg01 = (ImageView) findViewById(R.id.zc_img01);
        timebutton.onCreate(savedInstanceState);
        timebutton.setTextAfter("秒后重新发送").setTextBefore("点击获取验证码").setLenght(60 * 1000);
        timebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login2();
            }
        });
        zcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        initView();
    }

    public void initView() {
        zcimg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ZCActivity.this.finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
//        Toast.makeText(ZCActivity.this, "这是处理调用者onclicklistnenr",
//                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        timebutton.onDestroy();
        super.onDestroy();
    }

    @OnClick(R.id.zc_btn)
    public void onViewClicked() {
        login();
    }

    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
            zcEdt11 = zcEdt1.getText().toString().trim();    //获取当前输入的用户名和密码信息
            zcEdt22 = Integer.parseInt(zcEdt2.getText().toString().trim());
            zcEdt33 = zcEdt3.getText().toString().trim();    //获取当前输入的用户名和密码信息
            zcEdt44 = zcEdt4.getText().toString().trim();
            if (Zz.isMobileNO(zcEdt11)) {
                if (yzm == zcEdt22) {
                    ZCPresreter presreter = new ZCPresreter(this, zcEdt11, zcEdt33,page);
                    presreter.getData();
                } else {
                    Toast.makeText(this, "验证码输入错误", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "您的手机号格式错误", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean isUserNameAndPwdValid() {
        if (zcEdt1.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.account_empty),
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (zcEdt2.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入验证码",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (zcEdt3.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.pwd_empty),
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (zcEdt4.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.pwd_empty),
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void login2() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid2()) {
            zcEdt11 = zcEdt1.getText().toString().trim();    //获取当前输入的用户名和密码信息
            if (Zz.isMobileNO(zcEdt11)) {
                timebutton.setTextAfter("秒后重新发送").setTextBefore("点击获取验证码").setLenght(60 * 1000);
                timebutton.setOnClickListener(this);
                YZMPresreter presreter = new YZMPresreter(this, zcEdt11);
                presreter.getData();
            } else {
                Toast.makeText(this, "您的手机号格式错误", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean isUserNameAndPwdValid2() {
        if (zcEdt1.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.account_empty),
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onResponse(YZMBean yzmBean) {
        int stat = Integer.parseInt(yzmBean.getStat());
        if (stat == 1) {
            yzm = yzmBean.getInfo();
        }
        Toast.makeText(this, yzmBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(ZCBean zcBean) {
        Intent intent = new Intent(ZCActivity.this, LoginActivity.class);
        ZCActivity.this.finish();
        startActivity(intent);
        int state = Integer.parseInt(zcBean.getStat());
        Toast.makeText(this, zcBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String s) {

    }
}
