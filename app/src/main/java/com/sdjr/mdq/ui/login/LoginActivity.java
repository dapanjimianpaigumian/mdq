package com.sdjr.mdq.ui.login;

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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.sdjr.mdq.MainActivity;
import com.sdjr.mdq.R;
import com.sdjr.mdq.bean.DLBean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.ui.gywm.GYWMActivity;
import com.sdjr.mdq.ui.zc.ZCActivity;
import com.sdjr.mdq.widget.LoadingDialog;
import com.sdjr.mdq.widget.Zz;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginContract.View{

    @Bind(R.id.login_edit1)
    EditText loginEdit1;
    @Bind(R.id.login_edit2)
    EditText loginEdit2;
    @Bind(R.id.login_check)
    CheckBox loginCheck;
    @Bind(R.id.login_text1)
    TextView loginText1;
    @Bind(R.id.login_btn)
    Button loginBtn;
    @Bind(R.id.login_text2)
    TextView loginText2;
    @Bind(R.id.login_text3)
    TextView loginText3;
    @Bind(R.id.login_img)
    SimpleDraweeView loginImg;
    @Bind(R.id.login_img01)
    ImageView loginImg01;
    private String userName;
    private String userPwd;
    private String page;
    private LoadingDialog loadingDialog;
    private int cos;
    private SharedPreferences login_sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loadingDialog = new LoadingDialog(this);
        loginImg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginActivity.this.finish();
            }
        });
        loginText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UrlConfig.web =2;
                Intent intent = new Intent(LoginActivity.this, GYWMActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name","借款协议");
                bundle.putInt("id" , 48);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        loginCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cos = 0;
                    }else{
                    cos = 1;
                   }
            }
        });
    }

    @OnClick({R.id.login_text1, R.id.login_btn, R.id.login_text2, R.id.login_text3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_text1:
                break;
            case R.id.login_btn:
                login();
                break;
            case R.id.login_text2:
                page = "wj";
                Intent intent = new Intent(LoginActivity.this, ZCActivity.class);
                LoginActivity.this.finish();
                Bundle bundle = new Bundle();
                bundle.putString("page",page);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.login_text3:
                page = "zc";
                intent = new Intent(LoginActivity.this, ZCActivity.class);
                LoginActivity.this.finish();
                bundle = new Bundle();
                bundle.putString("page",page);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }

    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
            userName = loginEdit1.getText().toString().trim();    //获取当前输入的用户名和密码信息
            userPwd = loginEdit2.getText().toString().trim();
            if (Zz.isMobileNO(userName)){
                loadingDialog.show();
                LoginPresreter presreter = new LoginPresreter(this,userName,userPwd);
                presreter.getData();
            }
        }
    }

    public boolean isUserNameAndPwdValid() {
        if (loginEdit1.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.account_empty),
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (loginEdit2.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.pwd_empty),
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (cos == 1){
            Toast.makeText(this, "请选择借款协议",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onResponse(DLBean dlBean) {
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
        int stat = Integer.parseInt(dlBean.getStat());
        Toast.makeText(this, dlBean.getMsg(), Toast.LENGTH_SHORT).show();
        if (stat == 1){
            login_sp = getSharedPreferences("userInfo", 0);
            SharedPreferences.Editor editor =login_sp.edit();
            //保存用户名和密码

            UrlConfig.login = Integer.parseInt(dlBean.getInfo());
            editor.putInt("loginid", UrlConfig.login);
            editor.commit();

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            LoginActivity.this.finish();
            startActivity(intent);
        }
    }

    @Override
    public void onFailure(String s) {

    }
}
