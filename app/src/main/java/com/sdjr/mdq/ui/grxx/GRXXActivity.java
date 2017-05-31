package com.sdjr.mdq.ui.grxx;

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
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sdjr.mdq.R;
import com.sdjr.mdq.bean.GRXXBean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.widget.LoadingDialog;
import com.sdjr.mdq.widget.Zz;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GRXXActivity extends AppCompatActivity implements GRXXContract.View{
    @Bind(R.id.login_et1)
    EditText loginEt1;
    @Bind(R.id.login_et2)
    EditText loginEt2;
    @Bind(R.id.login_et3)
    EditText loginEt3;
    @Bind(R.id.login_et4)
    EditText loginEt4;
    @Bind(R.id.grxx_btn)
    Button grxxBtn;
    @Bind(R.id.login_et5)
    EditText loginEt5;
    @Bind(R.id.login_et6)
    EditText loginEt6;
    @Bind(R.id.login_et7)
    EditText loginEt7;
    @Bind(R.id.grxx_lin1)
    LinearLayout grxxLin1;
    @Bind(R.id.grxx_lin2)
    LinearLayout grxxLin2;
    @Bind(R.id.grxx_lin3)
    LinearLayout grxxLin3;
    @Bind(R.id.grxx_lin4)
    LinearLayout grxxLin4;
    @Bind(R.id.grxx_lin5)
    LinearLayout grxxLin5;
    @Bind(R.id.grxx_lin6)
    LinearLayout grxxLin6;
    @Bind(R.id.grxx_lin7)
    LinearLayout grxxLin7;
    private ImageView grxximg01;
    private String company_name,company_email,company_size,industry,ci_industry,job,money,company_phone;
    private LoadingDialog loadingDialog;

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
        setContentView(R.layout.activity_grxx);
        ButterKnife.bind(this);
        loadingDialog = new LoadingDialog(this);
        if (UrlConfig.company1 == 0) {
            grxxLin1.setVisibility(View.GONE);
        } else if (UrlConfig.company1 == 1) {

        } else if (UrlConfig.company1 == 2) {
//            grxxImg1.setVisibility(View.GONE);
        }

        if (UrlConfig.com_tel1 == 0) {
            grxxLin2.setVisibility(View.GONE);
        } else if (UrlConfig.com_tel1 == 1) {

        } else if (UrlConfig.com_tel1 == 2) {
//            grxxImg1.setVisibility(View.GONE);
        }

        if (UrlConfig.com_position1 == 0) {
            grxxLin3.setVisibility(View.GONE);
        } else if (UrlConfig.com_position1 == 1) {

        } else if (UrlConfig.com_position1 == 2) {
//            grxxImg1.setVisibility(View.GONE);
        }

        if (UrlConfig.salary1 == 0) {
            grxxLin4.setVisibility(View.GONE);
        } else if (UrlConfig.salary1 == 1) {

        } else if (UrlConfig.salary1 == 2) {
//            grxxImg1.setVisibility(View.GONE);
        }

        if (UrlConfig.com_type1 == 0) {
            grxxLin5.setVisibility(View.GONE);
        } else if (UrlConfig.com_type1 == 1) {

        } else if (UrlConfig.com_type1 == 2) {
//            grxxImg1.setVisibility(View.GONE);
        }

        if (UrlConfig.com_email1 == 0) {
            grxxLin6.setVisibility(View.GONE);
        } else if (UrlConfig.com_email1 == 1) {

        } else if (UrlConfig.com_email1 == 2) {
//            grxxImg1.setVisibility(View.GONE);
        }

        if (UrlConfig.com_scale1 == 0) {
            grxxLin7.setVisibility(View.GONE);
        } else if (UrlConfig.com_scale1 == 1) {

        } else if (UrlConfig.com_scale1 == 2) {
//            grxxImg1.setVisibility(View.GONE);
        }
        grxximg01 = (ImageView) findViewById(R.id.grxx_img01);
        initView();
    }

    public void initView() {
        grxximg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GRXXActivity.this.finish();
            }
        });
        grxxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    public void login() {
        if (isUserNameAndPwdValid()) {
            company_name = loginEt1.getText().toString().trim();
            company_phone = loginEt2.getText().toString().trim();
            job = loginEt3.getText().toString().trim();
            money = loginEt4.getText().toString().trim();
            industry = loginEt5.getText().toString().trim();
            company_email = loginEt6.getText().toString().trim();
            company_size = loginEt7.getText().toString().trim();
//            if (Zz.isUsName(loginEt11)) {
//
//            } else {
//                Toast.makeText(this, "您的公司名称输入有误", Toast.LENGTH_SHORT).show();
//            }
//
//            if (Zz.isMobileNO(loginEt22)) {
//
//            } else {
//                Toast.makeText(this, "您的公司电话输入有误", Toast.LENGTH_SHORT).show();
//            }
//
//            if (Zz.isUsName(loginEt33)) {
//
//            } else {
//                Toast.makeText(this, "您的职务输入有误", Toast.LENGTH_SHORT).show();
//            }
            loadingDialog.show();
            GRXXPresreter presreter = new GRXXPresreter(this,company_name,company_email,company_size,industry,ci_industry,job,money,company_phone);
            presreter.getData();
        }
    }

    public boolean isUserNameAndPwdValid() {
        if (UrlConfig.company1 == 1 &&loginEt1.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入公司名称", Toast.LENGTH_SHORT).show();
            return false;
        } else if (UrlConfig.com_tel1 == 1 &&loginEt2.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入公司电话", Toast.LENGTH_SHORT).show();
            return false;
        } else if (UrlConfig.com_position1 == 1 &&loginEt3.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入坐在职务", Toast.LENGTH_SHORT).show();
            return false;
        } else if (UrlConfig.salary1 == 1 &&loginEt4.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入月收入", Toast.LENGTH_SHORT).show();
            return false;
        }else if (UrlConfig.com_type1 == 1 &&loginEt5.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入公司行业", Toast.LENGTH_SHORT).show();
            return false;
        }else if (UrlConfig.com_email1 == 1 &&loginEt6.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入公司邮箱", Toast.LENGTH_SHORT).show();
            return false;
        }else if (UrlConfig.com_scale1 == 1 &&loginEt7.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入公司规模", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @OnClick(R.id.grxx_btn)
    public void onViewClicked() {
        login();
    }

    @Override
    public void onResponse(GRXXBean grxxBean) {
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
        if (grxxBean.getStat().equals("1")){
            GRXXActivity.this.finish();
        }else{
            Toast.makeText(this, grxxBean.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(String s) {

    }
}
