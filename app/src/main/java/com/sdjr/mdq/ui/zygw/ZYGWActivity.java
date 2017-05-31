package com.sdjr.mdq.ui.zygw;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sdjr.mdq.R;
import com.sdjr.mdq.bean.ZYGW2Bean;
import com.sdjr.mdq.bean.ZYGWBean;
import com.sdjr.mdq.widget.MyCDialog;
import com.sdjr.mdq.widget.Zz;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZYGWActivity extends AppCompatActivity implements ZYGWContract.View {

    @Bind(R.id.zygw_img01)
    ImageView zygwImg01;
    @Bind(R.id.zygw_text1)
    TextView zygwText1;
    @Bind(R.id.zygw_text2)
    TextView zygwText2;
    @Bind(R.id.zygw_edt2)
    EditText zygwEdt2;
    @Bind(R.id.zygw_text3)
    TextView zygwText3;
    @Bind(R.id.zygw_lin1)
    RelativeLayout zygwLin1;
    @Bind(R.id.zygw_btn1)
    Button zygwBtn1;
    @Bind(R.id.zygw_QQ)
    ImageView zygwQQ;
    String qqUrl = "mqqwpa://im/chat?chat_type=wpa&uin=289059690&version=1";
    @Bind(R.id.zygw_text4)
    TextView zygwText4;
    @Bind(R.id.zygw_edt1)
    EditText zygwEdt1;
    private Context mContext;
    private String name, sex, consult_time, phone;
    private TextView mycDialogText1, mycDialogText2, mycDialogText3, mycDialogText4;
    private ImageView mycDialogImg1, mycDialogImg2, mycDialogImg3, mycDialogImg4;

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
        setContentView(R.layout.activity_zygw);
        ButterKnife.bind(this);
        mContext = getApplicationContext();
        ZYGWPresreter presreter = new ZYGWPresreter(this, name, sex, consult_time, phone);
        presreter.getData();
        zygwQQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkApkExist(mContext, "com.tencent.mobileqq")){
                     startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(qqUrl)));
                     }else{
                    Toast.makeText(mContext, "本机未安装QQ应用", Toast.LENGTH_SHORT).show();
                     }

            }
        });
    }

    public boolean checkApkExist(Context context, String packageName) {
         if(packageName==null||"".equals(packageName))
         return false;
         try {
             ApplicationInfo info = context.getPackageManager().getApplicationInfo(packageName,
                PackageManager.GET_UNINSTALLED_PACKAGES);
             return true;
             } catch (PackageManager.NameNotFoundException e) {
             return false;
             }
         }

    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
            phone = zygwEdt2.getText().toString().trim();    //获取当前输入的用户名和密码信息
            name = zygwEdt1.getText().toString().trim();    //获取当前输入的用户名和密码信息
            if (sex == null) {
                sex = "男";
            }
            if (consult_time == null) {
                consult_time = "任意时间";
            }
            if (Zz.isMobileNO(phone)) {
                ZYGWPresreter presreter = new ZYGWPresreter(this, name, sex, consult_time, phone);
                presreter.getData2();
            }else {
                Toast.makeText(mContext, "您输入的手机号格式不正确", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean isUserNameAndPwdValid() {
        if (zygwEdt1.getText().toString().trim().equals("")){
            Toast.makeText(this, "请输入您的称呼",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (zygwEdt2.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入手机号",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @OnClick({R.id.zygw_img01, R.id.zygw_text1, R.id.zygw_text2, R.id.zygw_lin1, R.id.zygw_btn1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zygw_img01:
                ZYGWActivity.this.finish();
                break;
            case R.id.zygw_text1:
                sex = "男";
                zygwText1.setBackgroundResource(R.drawable.huangbiangk);
                zygwText2.setBackgroundResource(R.drawable.heibiangk);
                break;
            case R.id.zygw_text2:
                sex = "女";
                zygwText1.setBackgroundResource(R.drawable.heibiangk);
                zygwText2.setBackgroundResource(R.drawable.huangbiangk);
                break;
            case R.id.zygw_lin1:
                MyCDialog dialog = new MyCDialog(ZYGWActivity.this, R.style.MyAnimDialog);
                dialog.setContentView(R.layout.mycdialog);
                dialog.show();
                mycDialogText1 = (TextView) dialog.getWindow().findViewById(R.id.myc_dialog_text1);
                mycDialogText2 = (TextView) dialog.getWindow().findViewById(R.id.myc_dialog_text2);
                mycDialogText3 = (TextView) dialog.getWindow().findViewById(R.id.myc_dialog_text3);
                mycDialogText4 = (TextView) dialog.getWindow().findViewById(R.id.myc_dialog_text4);
                mycDialogImg1 = (ImageView) dialog.getWindow().findViewById(R.id.myc_dialog_img1);
                mycDialogImg2 = (ImageView) dialog.getWindow().findViewById(R.id.myc_dialog_img2);
                mycDialogImg3 = (ImageView) dialog.getWindow().findViewById(R.id.myc_dialog_img3);
                mycDialogImg4 = (ImageView) dialog.getWindow().findViewById(R.id.myc_dialog_img4);
                mycDialogText1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        consult_time = "任意时间";
                        zygwText3.setText(consult_time);
                        mycDialogText1.setTextColor(mContext.getResources().getColor(R.color.home));
                        mycDialogText2.setTextColor(mContext.getResources().getColor(R.color.hei));
                        mycDialogText3.setTextColor(mContext.getResources().getColor(R.color.hei));
                        mycDialogText4.setTextColor(mContext.getResources().getColor(R.color.hei));
                        mycDialogImg1.setVisibility(View.VISIBLE);
                        mycDialogImg2.setVisibility(View.GONE);
                        mycDialogImg3.setVisibility(View.GONE);
                        mycDialogImg4.setVisibility(View.GONE);
                    }
                });
                mycDialogText2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        consult_time = "上午";
                        zygwText3.setText(consult_time);
                        mycDialogText1.setTextColor(mContext.getResources().getColor(R.color.hei));
                        mycDialogText2.setTextColor(mContext.getResources().getColor(R.color.home));
                        mycDialogText3.setTextColor(mContext.getResources().getColor(R.color.hei));
                        mycDialogText4.setTextColor(mContext.getResources().getColor(R.color.hei));
                        mycDialogImg1.setVisibility(View.GONE);
                        mycDialogImg2.setVisibility(View.VISIBLE);
                        mycDialogImg3.setVisibility(View.GONE);
                        mycDialogImg4.setVisibility(View.GONE);
                    }
                });
                mycDialogText3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        consult_time = "下午";
                        zygwText3.setText(consult_time);
                        mycDialogText1.setTextColor(mContext.getResources().getColor(R.color.hei));
                        mycDialogText2.setTextColor(mContext.getResources().getColor(R.color.hei));
                        mycDialogText3.setTextColor(mContext.getResources().getColor(R.color.home));
                        mycDialogText4.setTextColor(mContext.getResources().getColor(R.color.hei));
                        mycDialogImg1.setVisibility(View.GONE);
                        mycDialogImg2.setVisibility(View.GONE);
                        mycDialogImg3.setVisibility(View.VISIBLE);
                        mycDialogImg4.setVisibility(View.GONE);
                    }
                });
                mycDialogText4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        consult_time = "晚上";
                        zygwText3.setText(consult_time);
                        mycDialogText1.setTextColor(mContext.getResources().getColor(R.color.hei));
                        mycDialogText2.setTextColor(mContext.getResources().getColor(R.color.hei));
                        mycDialogText3.setTextColor(mContext.getResources().getColor(R.color.hei));
                        mycDialogText4.setTextColor(mContext.getResources().getColor(R.color.home));
                        mycDialogImg1.setVisibility(View.GONE);
                        mycDialogImg2.setVisibility(View.GONE);
                        mycDialogImg3.setVisibility(View.GONE);
                        mycDialogImg4.setVisibility(View.VISIBLE);
                    }
                });
                break;
            case R.id.zygw_btn1:
                login();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (MyCDialog.consult != null) {
            zygwText3.setText(MyCDialog.consult);
        }
    }

    @Override
    public void onResponse(ZYGWBean zygwBean) {
        qqUrl = "mqqwpa://im/chat?chat_type=wpa&uin=" + zygwBean.getInfo().getQq() + "&version=1";
        zygwText4.setText(zygwBean.getInfo().getSum());
    }

    @Override
    public void onResponse2(ZYGW2Bean zygw2Bean) {
        Toast.makeText(mContext, zygw2Bean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String s) {

    }
}
