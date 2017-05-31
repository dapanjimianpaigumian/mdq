package com.sdjr.mdq.ui.qyxx;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sdjr.mdq.R;
import com.sdjr.mdq.bean.QYXXBean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.ui.login.LoginPresreter;
import com.sdjr.mdq.widget.LoadingDialog;
import com.sdjr.mdq.widget.Zz;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QYXXActivity extends AppCompatActivity implements QYXXContract.View{
    @Bind(R.id.qyxx_text1)
    TextView qyxxText1;
    @Bind(R.id.qyxx_lin1)
    LinearLayout qyxxLin1;
    @Bind(R.id.qyxx_text2)
    TextView qyxxText2;
    @Bind(R.id.qyxx_lin2)
    LinearLayout qyxxLin2;
    @Bind(R.id.qyxx_text3)
    TextView qyxxText3;
    @Bind(R.id.qyxx_lin3)
    LinearLayout qyxxLin3;
    @Bind(R.id.qyxx_text4)
    TextView qyxxText4;
    @Bind(R.id.qyxx_lin4)
    LinearLayout qyxxLin4;
    @Bind(R.id.qyxx_text5)
    TextView qyxxText5;
    @Bind(R.id.qyxx_lin5)
    LinearLayout qyxxLin5;
    @Bind(R.id.qyxx_text6)
    TextView qyxxText6;
    @Bind(R.id.qyxx_lin6)
    LinearLayout qyxxLin6;
    @Bind(R.id.qyxx_text7)
    TextView qyxxText7;
    @Bind(R.id.qyxx_lin7)
    LinearLayout qyxxLin7;
    @Bind(R.id.qyxx_text8)
    TextView qyxxText8;
    @Bind(R.id.qyxx_lin8)
    LinearLayout qyxxLin8;
    @Bind(R.id.qyxx_text9)
    TextView qyxxText9;
    @Bind(R.id.qyxx_lin9)
    LinearLayout qyxxLin9;
    @Bind(R.id.qyxx_text10)
    TextView qyxxText10;
    @Bind(R.id.qyxx_lin10)
    LinearLayout qyxxLin10;
    @Bind(R.id.qqxx_btn)
    Button qqxxBtn;
    @Bind(R.id.qyxx_img1)
    ImageView qyxxImg1;
    @Bind(R.id.qyxx_img2)
    ImageView qyxxImg2;
    @Bind(R.id.qyxx_img3)
    ImageView qyxxImg3;
    @Bind(R.id.qyxx_img4)
    ImageView qyxxImg4;
    @Bind(R.id.qyxx_img5)
    ImageView qyxxImg5;
    private ImageView qyxximg01;
    public static int count = 0;
    public static String father_name;
    public static String father_phone;
    public static String mother_name;
    public static String mother_phone;
    public static String brothers_name;
    public static String brothers_phone;
    public static String work_name;
    public static String work_phone;
    public static String friend_name;
    public static String friend_phone;
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
        setContentView(R.layout.activity_qqxx);
        ButterKnife.bind(this);
        loadingDialog = new LoadingDialog(this);
        qyxximg01 = (ImageView) findViewById(R.id.qyxx_img01);
        if (UrlConfig.friend1 == 0) {
            qyxxLin1.setVisibility(View.GONE);
            qyxxLin2.setVisibility(View.GONE);
        } else if (UrlConfig.friend1 == 1) {

        } else if (UrlConfig.friend1 == 2) {
            qyxxImg1.setVisibility(View.GONE);
        }

        if (UrlConfig.workmate1 == 0) {
            qyxxLin3.setVisibility(View.GONE);
            qyxxLin4.setVisibility(View.GONE);
        } else if (UrlConfig.workmate1 == 1) {

        } else if (UrlConfig.workmate1 == 2) {
            qyxxImg2.setVisibility(View.GONE);
        }

        if (UrlConfig.family1 == 0) {
            qyxxLin5.setVisibility(View.GONE);
            qyxxLin6.setVisibility(View.GONE);
        } else if (UrlConfig.family1 == 1) {

        } else if (UrlConfig.family1 == 2) {
            qyxxImg3.setVisibility(View.GONE);
        }

        if (UrlConfig.mother1 == 0) {
            qyxxLin7.setVisibility(View.GONE);
            qyxxLin8.setVisibility(View.GONE);
        } else if (UrlConfig.mother1 == 1) {

        } else if (UrlConfig.mother1 == 2) {
            qyxxImg4.setVisibility(View.GONE);
        }

        if (UrlConfig.father1 == 0) {
            qyxxLin9.setVisibility(View.GONE);
            qyxxLin10.setVisibility(View.GONE);
        } else if (UrlConfig.father1 == 1) {

        } else if (UrlConfig.father1 == 2) {
            qyxxImg5.setVisibility(View.GONE);
        }
        initView();
        initView2();
    }

    public void initView() {
        qyxximg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QYXXActivity.this.finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        initView2();
    }

    public void initView2() {
        if (LXRActivity.name!= null&& LXRActivity.tel!=null){
            switch (count){
                case 0:
                    break;
                case 1:
                    friend_name= LXRActivity.name;
                    friend_phone= LXRActivity.tel;
                    qyxxText1.setText(friend_name);
                    qyxxText2.setText(friend_phone);

                    break;
                case 2:
                    if (friend_name!=null){
                        if (friend_name == work_name){
                            Toast.makeText(this, "请勿提交重复联系人", Toast.LENGTH_SHORT).show();
                        }else {
                            work_name= LXRActivity.name;
                            work_phone= LXRActivity.tel;
                            qyxxText3.setText(work_name);
                            qyxxText4.setText(work_phone);
                        }
                    }else {
                        work_name= LXRActivity.name;
                        work_phone= LXRActivity.tel;
                        qyxxText3.setText(work_name);
                        qyxxText4.setText(work_phone);
                    }
                    break;
                case 3:
                    if (friend_name!=null){
                        if (friend_name == brothers_name){
                            Toast.makeText(this, "请勿提交重复联系人", Toast.LENGTH_SHORT).show();
                        }else {
                            brothers_name= LXRActivity.name;
                            brothers_phone= LXRActivity.tel;
                            qyxxText5.setText(brothers_name);
                            qyxxText6.setText(brothers_phone);
                        }
                    }else {
                        brothers_name= LXRActivity.name;
                        brothers_phone= LXRActivity.tel;
                        qyxxText5.setText(brothers_name);
                        qyxxText6.setText(brothers_phone);
                    }
                    if (work_name!=null){
                        if (work_name == brothers_name){
                            Toast.makeText(this, "请勿提交重复联系人", Toast.LENGTH_SHORT).show();
                        }else {
                            brothers_name= LXRActivity.name;
                            brothers_phone= LXRActivity.tel;
                            qyxxText5.setText(brothers_name);
                            qyxxText6.setText(brothers_phone);
                        }
                    }else {
                        brothers_name= LXRActivity.name;
                        brothers_phone= LXRActivity.tel;
                        qyxxText5.setText(brothers_name);
                        qyxxText6.setText(brothers_phone);
                    }
                    break;
                case 4:
                    if (friend_name!=null){
                        if (friend_name == mother_name){
                            Toast.makeText(this, "请勿提交重复联系人", Toast.LENGTH_SHORT).show();
                        }else {
                            mother_name = LXRActivity.name;
                            mother_phone = LXRActivity.tel;
                            qyxxText7.setText(mother_name);
                            qyxxText8.setText(mother_phone);
                        }
                    }else {
                        mother_name = LXRActivity.name;
                        mother_phone = LXRActivity.tel;
                        qyxxText7.setText(mother_name);
                        qyxxText8.setText(mother_phone);
                    }
                    if (work_name!=null){
                        if (work_name == mother_name){
                            Toast.makeText(this, "请勿提交重复联系人", Toast.LENGTH_SHORT).show();
                        }else {
                            mother_name = LXRActivity.name;
                            mother_phone = LXRActivity.tel;
                            qyxxText7.setText(mother_name);
                            qyxxText8.setText(mother_phone);
                        }
                    }else {
                        mother_name = LXRActivity.name;
                        mother_phone = LXRActivity.tel;
                        qyxxText7.setText(mother_name);
                        qyxxText8.setText(mother_phone);
                    }
                    if (brothers_name!=null){
                        if (brothers_name == mother_name){
                            Toast.makeText(this, "请勿提交重复联系人", Toast.LENGTH_SHORT).show();
                        }else {
                            mother_name = LXRActivity.name;
                            mother_phone = LXRActivity.tel;
                            qyxxText7.setText(mother_name);
                            qyxxText8.setText(mother_phone);
                        }
                    }else {
                        mother_name = LXRActivity.name;
                        mother_phone = LXRActivity.tel;
                        qyxxText7.setText(mother_name);
                        qyxxText8.setText(mother_phone);
                    }
                    break;
                case 5:
                    if (friend_name!=null){
                        if (friend_name == father_name){
                            Toast.makeText(this, "请勿提交重复联系人", Toast.LENGTH_SHORT).show();
                        }else {
                            father_name= LXRActivity.name;
                            father_phone= LXRActivity.tel;
                            qyxxText9.setText(father_name);
                            qyxxText10.setText(father_phone);
                        }
                    }else {
                        father_name= LXRActivity.name;
                        father_phone= LXRActivity.tel;
                        qyxxText9.setText(father_name);
                        qyxxText10.setText(father_phone);
                    }
                    if (work_name!=null){
                        if (work_name == father_name){
                            Toast.makeText(this, "请勿提交重复联系人", Toast.LENGTH_SHORT).show();
                        }else {
                            father_name= LXRActivity.name;
                            father_phone= LXRActivity.tel;
                            qyxxText9.setText(father_name);
                            qyxxText10.setText(father_phone);
                        }
                    }else {
                        father_name= LXRActivity.name;
                        father_phone= LXRActivity.tel;
                        qyxxText9.setText(father_name);
                        qyxxText10.setText(father_phone);
                    }
                    if (brothers_name!=null){
                        if (brothers_name == father_name){
                            Toast.makeText(this, "请勿提交重复联系人", Toast.LENGTH_SHORT).show();
                        }else {
                            father_name= LXRActivity.name;
                            father_phone= LXRActivity.tel;
                            qyxxText9.setText(father_name);
                            qyxxText10.setText(father_phone);
                        }
                    }else {
                        father_name= LXRActivity.name;
                        father_phone= LXRActivity.tel;
                        qyxxText9.setText(father_name);
                        qyxxText10.setText(father_phone);
                    }
                    if (mother_name!=null){
                        if (mother_name == father_name){
                            Toast.makeText(this, "请勿提交重复联系人", Toast.LENGTH_SHORT).show();
                        }else {
                            father_name= LXRActivity.name;
                            father_phone= LXRActivity.tel;
                            qyxxText9.setText(father_name);
                            qyxxText10.setText(father_phone);
                        }
                    }else {
                        father_name= LXRActivity.name;
                        father_phone= LXRActivity.tel;
                        qyxxText9.setText(father_name);
                        qyxxText10.setText(father_phone);
                    }
                    break;
            }
        }
    }

    @OnClick({R.id.qyxx_lin1, R.id.qyxx_lin2, R.id.qyxx_lin3, R.id.qyxx_lin4, R.id.qyxx_lin5, R.id.qyxx_lin6, R.id.qyxx_lin7, R.id.qyxx_lin8, R.id.qyxx_lin9, R.id.qyxx_lin10, R.id.qqxx_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.qyxx_lin1:
                count = 1;
                Intent intent = new Intent(this, LXRActivity.class);
                startActivity(intent);
                break;
            case R.id.qyxx_lin2:
                count=1;
                intent = new Intent(this, LXRActivity.class);
                startActivity(intent);
                break;
            case R.id.qyxx_lin3:
                count = 2;
                intent = new Intent(this, LXRActivity.class);
                startActivity(intent);
                break;
            case R.id.qyxx_lin4:
                count =2;
                intent = new Intent(this, LXRActivity.class);
                startActivity(intent);
                break;
            case R.id.qyxx_lin5:
                count=3;
                intent = new Intent(this, LXRActivity.class);
                startActivity(intent);
                break;
            case R.id.qyxx_lin6:
                count=3;
                intent = new Intent(this, LXRActivity.class);
                startActivity(intent);
                break;
            case R.id.qyxx_lin7:
                count =4;
                intent = new Intent(this, LXRActivity.class);
                startActivity(intent);
                break;
            case R.id.qyxx_lin8:
                count = 4;
                intent = new Intent(this, LXRActivity.class);
                startActivity(intent);
                break;
            case R.id.qyxx_lin9:
                count = 5;
                intent = new Intent(this, LXRActivity.class);
                startActivity(intent);
                break;
            case R.id.qyxx_lin10:
                count = 5;
                intent = new Intent(this, LXRActivity.class);
                startActivity(intent);
                break;
            case R.id.qqxx_btn:
                login();
                break;
        }
    }

    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
                loadingDialog.show();
            Log.i("asd", "login: ======1====="+father_name);
            Log.i("asd", "login: =======2===="+friend_name);
            Log.i("asd", "login: ========3==="+mother_name);
            Log.i("asd", "login: ========4==="+brothers_name);
            Log.i("asd", "login: ========5==="+work_name);
            QYXXPresreter presreter = new QYXXPresreter(QYXXActivity.this,father_name,father_phone,mother_name,mother_phone,brothers_name,brothers_phone
                    ,work_name,work_phone,friend_name,friend_phone);
            presreter.getData();
        }
    }

    public boolean isUserNameAndPwdValid() {
        if (UrlConfig.friend1 == 1 && friend_name == null){
            Toast.makeText(this, "联系人不能为空",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (UrlConfig.father1 == 1&& father_name == null){
            Toast.makeText(this, "联系人不能为空",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (UrlConfig.mother1 == 1&& mother_name == null){
            Toast.makeText(this, "联系人不能为空",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (  UrlConfig.family1 == 1&& brothers_name == null){
            Toast.makeText(this, "联系人不能为空",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (UrlConfig.workmate1 == 1 && work_name == null){
            Toast.makeText(this, "联系人不能为空",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (UrlConfig.friend1 == 1 && UrlConfig.father1 == 1 && friend_phone.equals(father_phone)){
            Toast.makeText(this, "联系人不能重复",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (UrlConfig.friend1 == 1 && UrlConfig.mother1 == 1 && friend_phone.equals(mother_phone)){
            Toast.makeText(this, "联系人不能重复",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (UrlConfig.friend1 == 1 && UrlConfig.family1 == 1 && friend_phone.equals(brothers_phone)){
            Toast.makeText(this, "联系人不能重复",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (UrlConfig.friend1 == 1 && UrlConfig.workmate1 == 1 && friend_phone.equals(work_phone)){
            Toast.makeText(this, "联系人不能重复",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (UrlConfig.father1 == 1 && UrlConfig.mother1 == 1 && father_phone.equals(mother_phone)){
            Toast.makeText(this, "联系人不能重复",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (UrlConfig.father1 == 1 && UrlConfig.family1 == 1 && father_phone .equals (brothers_phone)){
            Toast.makeText(this, "联系人不能重复",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (UrlConfig.father1 == 1 && UrlConfig.workmate1 == 1 && father_phone .equals (work_phone)){
            Toast.makeText(this, "联系人不能重复",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (UrlConfig.mother1 == 1 && UrlConfig.family1 == 1 && mother_phone .equals (brothers_phone)){
            Toast.makeText(this, "联系人不能重复",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (UrlConfig.mother1 == 1 && UrlConfig.workmate1 == 1 && mother_phone .equals (work_phone)){
            Toast.makeText(this, "联系人不能重复",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (UrlConfig.family1 == 1 && UrlConfig.workmate1 == 1 && brothers_phone .equals (work_phone)){
            Toast.makeText(this, "联系人不能重复",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    @Override
    public void onResponse(QYXXBean qyxxBean) {
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
        if (qyxxBean.getStat().equals("1")){
            QYXXActivity.this.finish();
        }
    }

    @Override
    public void onFailure(String s) {

    }
}
