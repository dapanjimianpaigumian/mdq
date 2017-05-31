package com.sdjr.mdq.ui.grxx2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sdjr.mdq.R;
import com.sdjr.mdq.bean.GRXX2Bean;
import com.sdjr.mdq.bean.ZM2bean;
import com.sdjr.mdq.bean.ZMbean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.ui.sfrz.SFRZActivity;
import com.sdjr.mdq.ui.sfrz2.SFRZ2Activity;
import com.sdjr.mdq.widget.LoadingDialog;
import com.sdjr.mdq.widget.Zz;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GRXX2Activity extends AppCompatActivity implements GRXX2Contract.View,ZMSLContract.View{
    @Bind(R.id.grxx2_btn)
    Button grxx2Btn;
    @Bind(R.id.grxx2_et1)
    EditText grxx2Et1;
    @Bind(R.id.grxx2_et2)
    EditText grxx2Et2;
    @Bind(R.id.grxx2_et3)
    EditText grxx2Et3;
    @Bind(R.id.grxx2_et4)
    EditText grxx2Et4;
    @Bind(R.id.grxx2_et5)
    EditText grxx2Et5;
    @Bind(R.id.grxx2_et6)
    EditText grxx2Et6;
    @Bind(R.id.grxx2_et7)
    EditText grxx2Et7;
    @Bind(R.id.grxx2_et8)
    EditText grxx2Et8;
    @Bind(R.id.grxx2_et9)
    EditText grxx2Et9;
    @Bind(R.id.grxx2_et10)
    EditText grxx2Et10;
    @Bind(R.id.grxx2_et11)
    EditText grxx2Et11;
    @Bind(R.id.grxx2_et13)
    EditText grxx2Et13;
    @Bind(R.id.grxx2_et14)
    EditText grxx2Et14;
    @Bind(R.id.grxx2_et15)
    EditText grxx2Et15;
    @Bind(R.id.grxx2_et16)
    EditText grxx2Et16;
    @Bind(R.id.grxx2_et17)
    EditText grxx2Et17;
    @Bind(R.id.grxx2_et18)
    EditText grxx2Et18;
    @Bind(R.id.grxx2_et19)
    EditText grxx2Et19;
    @Bind(R.id.grxx2_lin1)
    LinearLayout grxx2Lin1;
    @Bind(R.id.grxx2_lin2)
    LinearLayout grxx2Lin2;
    @Bind(R.id.grxx2_lin3)
    LinearLayout grxx2Lin3;
    @Bind(R.id.grxx2_lin4)
    LinearLayout grxx2Lin4;
    @Bind(R.id.grxx2_lin5)
    LinearLayout grxx2Lin5;
    @Bind(R.id.grxx2_lin6)
    LinearLayout grxx2Lin6;
    @Bind(R.id.grxx2_lin7)
    LinearLayout grxx2Lin7;
    @Bind(R.id.grxx2_lin8)
    LinearLayout grxx2Lin8;
    @Bind(R.id.grxx2_lin9)
    LinearLayout grxx2Lin9;
    @Bind(R.id.grxx2_lin10)
    LinearLayout grxx2Lin10;
    @Bind(R.id.grxx2_lin11)
    LinearLayout grxx2Lin11;
    @Bind(R.id.grxx2_lin12)
    LinearLayout grxx2Lin12;
    @Bind(R.id.grxx2_lin13)
    LinearLayout grxx2Lin13;
    @Bind(R.id.grxx2_lin14)
    LinearLayout grxx2Lin14;
    @Bind(R.id.grxx2_lin15)
    LinearLayout grxx2Lin15;
    @Bind(R.id.grxx2_lin16)
    LinearLayout grxx2Lin16;
    @Bind(R.id.grxx2_lin17)
    LinearLayout grxx2Lin17;
    @Bind(R.id.grxx2_lin18)
    LinearLayout grxx2Lin18;
    @Bind(R.id.grxx2_lin19)
    LinearLayout grxx2Lin19;
    @Bind(R.id.grxx2_img1)
    ImageView grxx2Img1;
    @Bind(R.id.grxx2_img2)
    ImageView grxx2Img2;
    @Bind(R.id.grxx2_img3)
    ImageView grxx2Img3;
    @Bind(R.id.grxx2_img4)
    ImageView grxx2Img4;
    @Bind(R.id.grxx2_img5)
    ImageView grxx2Img5;
    @Bind(R.id.grxx2_img6)
    ImageView grxx2Img6;
    @Bind(R.id.grxx2_img7)
    ImageView grxx2Img7;
    @Bind(R.id.grxx2_img8)
    ImageView grxx2Img8;
    @Bind(R.id.grxx2_img9)
    ImageView grxx2Img9;
    @Bind(R.id.grxx2_img10)
    ImageView grxx2Img10;
    @Bind(R.id.grxx2_img11)
    ImageView grxx2Img11;
    @Bind(R.id.grxx2_img12)
    ImageView grxx2Img12;
    @Bind(R.id.grxx2_img13)
    ImageView grxx2Img13;
    @Bind(R.id.grxx2_img14)
    ImageView grxx2Img14;
    @Bind(R.id.grxx2_img15)
    ImageView grxx2Img15;
    @Bind(R.id.grxx2_img16)
    ImageView grxx2Img16;
    @Bind(R.id.grxx2_img17)
    ImageView grxx2Img17;
    @Bind(R.id.grxx2_img18)
    ImageView grxx2Img18;
    @Bind(R.id.grxx2_img19)
    ImageView grxx2Img19;
    private ImageView grxx2img01;
    private TextView grxx2Text1;
    private String name,card,email,record,marital,housing,room,car,graduation_date,credit,edu,call,qq,treasure,
            he_treasure,province,city,address,zhima_score,town,bao_liabilities,jin_liabilities,borrow;
    private LoadingDialog loadingDialog;
    private String Identifier;
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
        setContentView(R.layout.activity_grxx2);
        ButterKnife.bind(this);
        loadingDialog = new LoadingDialog(this);
        if (UrlConfig.borrow1 == 0) {
            grxx2Lin1.setVisibility(View.GONE);
        } else if (UrlConfig.borrow1 == 1) {

        } else if (UrlConfig.borrow1 == 2) {
            grxx2Img1.setVisibility(View.GONE);
        }

        if (UrlConfig.graduation1 == 0) {
            grxx2Lin2.setVisibility(View.GONE);
        } else if (UrlConfig.graduation1 == 1) {

        } else if (UrlConfig.graduation1 == 2) {
            grxx2Img2.setVisibility(View.GONE);
        }

        if (UrlConfig.houses1 == 0) {
            grxx2Lin3.setVisibility(View.GONE);
        } else if (UrlConfig.houses1 == 1) {

        } else if (UrlConfig.houses1 == 2) {
            grxx2Img3.setVisibility(View.GONE);
        }

        if (UrlConfig.marriage1 == 0) {
            grxx2Lin4.setVisibility(View.GONE);
        } else if (UrlConfig.marriage1 == 1) {

        } else if (UrlConfig.marriage1 == 2) {
            grxx2Img4.setVisibility(View.GONE);
        }

        if (UrlConfig.bao_liabilities1 == 0) {
            grxx2Lin5.setVisibility(View.GONE);
        } else if (UrlConfig.bao_liabilities1 == 1) {

        } else if (UrlConfig.bao_liabilities1 == 2) {
            grxx2Img5.setVisibility(View.GONE);
        }

        if (UrlConfig.jiedaibao1 == 0) {
            grxx2Lin6.setVisibility(View.GONE);
        } else if (UrlConfig.jiedaibao1 == 1) {

        } else if (UrlConfig.jiedaibao1 == 2) {
            grxx2Img6.setVisibility(View.GONE);
        }

        if (UrlConfig.address1 == 0) {
            grxx2Lin7.setVisibility(View.GONE);
        } else if (UrlConfig.address1 == 1) {

        } else if (UrlConfig.address1 == 2) {
            grxx2Img7.setVisibility(View.GONE);
        }

        if (UrlConfig.address1 == 0) {
            grxx2Lin8.setVisibility(View.GONE);
        } else if (UrlConfig.address1 == 1) {

        } else if (UrlConfig.address1 == 2) {
            grxx2Img8.setVisibility(View.GONE);
        }

        if (UrlConfig.home_tel1 == 0) {
            grxx2Lin9.setVisibility(View.GONE);
        } else if (UrlConfig.home_tel1 == 1) {

        } else if (UrlConfig.home_tel1 == 2) {
            grxx2Img9.setVisibility(View.GONE);
        }

        if (UrlConfig.house_loan1 == 0) {
            grxx2Lin10.setVisibility(View.GONE);
        } else if (UrlConfig.house_loan1 == 1) {

        } else if (UrlConfig.house_loan1 == 2) {
            grxx2Img10.setVisibility(View.GONE);
        }

        if (UrlConfig.recommend1 == 0) {
            grxx2Lin11.setVisibility(View.GONE);
        } else if (UrlConfig.recommend1 == 1) {

        } else if (UrlConfig.recommend1 == 2) {
            grxx2Img11.setVisibility(View.GONE);
        }

        if (UrlConfig.jin_liabilities1 == 0) {
            grxx2Lin12.setVisibility(View.GONE);
        } else if (UrlConfig.jin_liabilities1 == 1) {

        } else if (UrlConfig.jin_liabilities1 == 2) {
            grxx2Img12.setVisibility(View.GONE);
        }

        if (UrlConfig.credit_limit1 == 0) {
            grxx2Lin13.setVisibility(View.GONE);
        } else if (UrlConfig.credit_limit1 == 1) {

        } else if (UrlConfig.credit_limit1 == 2) {
            grxx2Img13.setVisibility(View.GONE);
        }

        if (UrlConfig.name1 == 0) {
            grxx2Lin14.setVisibility(View.GONE);
        } else if (UrlConfig.name1 == 1) {

        } else if (UrlConfig.name1 == 2) {
            grxx2Img14.setVisibility(View.GONE);
        }

        if (UrlConfig.emails1 == 0) {
            grxx2Lin15.setVisibility(View.GONE);
        } else if (UrlConfig.emails1 == 1) {

        } else if (UrlConfig.emails1 == 2) {
            grxx2Img15.setVisibility(View.GONE);
        }

        if (UrlConfig.idcard1 == 0) {
            grxx2Lin16.setVisibility(View.GONE);
        } else if (UrlConfig.idcard1 == 1) {

        } else if (UrlConfig.idcard1 == 2) {
            grxx2Img16.setVisibility(View.GONE);
        }

        if (UrlConfig.QQ1 == 0) {
            grxx2Lin17.setVisibility(View.GONE);
        } else if (UrlConfig.QQ1 == 1) {

        } else if (UrlConfig.QQ1 == 2) {
            grxx2Img17.setVisibility(View.GONE);
        }

        if (UrlConfig.zhima_score1 == 0) {
            grxx2Lin18.setVisibility(View.GONE);
        } else if (UrlConfig.zhima_score1 == 1) {

        } else if (UrlConfig.zhima_score1 == 2) {
            grxx2Img18.setVisibility(View.GONE);
        }

        if (UrlConfig.credits1 == 0) {
            grxx2Lin19.setVisibility(View.GONE);
        } else if (UrlConfig.credits1 == 1) {

        } else if (UrlConfig.credits1 == 2) {
            grxx2Img19.setVisibility(View.GONE);
        }

        grxx2img01 = (ImageView) findViewById(R.id.grxx2_img01);
        grxx2Text1 = (TextView) findViewById(R.id.grxx2_text1);
        grxx2Text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeAddressPopwindow mChangeAddressPopwindow = new ChangeAddressPopwindow(GRXX2Activity.this);
                mChangeAddressPopwindow.setAddress("广东", "深圳", "福田区");
                mChangeAddressPopwindow.showAtLocation(grxx2Text1, Gravity.BOTTOM, 0, 0);
                mChangeAddressPopwindow.setAddresskListener(new ChangeAddressPopwindow.OnAddressCListener() {
                    @Override
                    public void onClick(String provinc, String cit, String area) {
                        Toast.makeText(GRXX2Activity.this,
                                provinc + "-" + cit + "-" + area,
                                Toast.LENGTH_LONG).show();
                        province = provinc;
                        city = cit;
                        town = area;
                        grxx2Text1.setText(provinc + cit + area);
                    }
                });
            }
        });
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (UrlConfig.zmsl!=null){
            Identifier = UrlConfig.zmsl;
            ZMSLPresreter presreter = new ZMSLPresreter(this,name,card,Identifier);
            presreter.getData2();
        }
    }

    public void initView() {
        grxx2img01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GRXX2Activity.this.finish();
            }
        });

        grxx2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
            borrow = grxx2Et1.getText().toString().trim();
            graduation_date = grxx2Et2.getText().toString().trim();
            housing = grxx2Et3.getText().toString().trim();
            marital = grxx2Et4.getText().toString().trim();
            bao_liabilities = grxx2Et5.getText().toString().trim();
            treasure = grxx2Et6.getText().toString().trim();
            address = grxx2Et7.getText().toString().trim();
            call = grxx2Et8.getText().toString().trim();
            room = grxx2Et9.getText().toString().trim();
            jin_liabilities = grxx2Et11.getText().toString().trim();
            edu = grxx2Et13.getText().toString().trim();
            name = grxx2Et14.getText().toString().trim();
            email = grxx2Et15.getText().toString().trim();
            card = grxx2Et16.getText().toString().trim();
            qq = grxx2Et17.getText().toString().trim();
            zhima_score = grxx2Et18.getText().toString().trim();
            credit = grxx2Et19.getText().toString().trim();
            if (Zz.isSFZ(card)&&Zz.isUsName(name)) {
                Intent intent = new Intent(this,ZMSLActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putString("card",card);
                intent.putExtras(bundle);
                startActivity(intent);
            } else {
                Toast.makeText(this, "您输入的信息格式错误", Toast.LENGTH_SHORT).show();
            }
//            if (Zz.isUsName(grxx2Et113)) {
//
//            } else {
//                Toast.makeText(this, "您输入的住房情况格式错误", Toast.LENGTH_SHORT).show();
//            }
//
//            if (Zz.isUsName(grxx2Et114)) {
//
//            } else {
//                Toast.makeText(this, "您输入的婚姻情况格式错误", Toast.LENGTH_SHORT).show();
//            }
//
//            if (Zz.isUsName(grxx2Et118)) {
//
//            } else {
//                Toast.makeText(this, "您输入的详细地址格式错误", Toast.LENGTH_SHORT).show();
//            }
//
//            if (Zz.isUsName(grxx2Et1110)) {
//
//            } else {
//                Toast.makeText(this, "您输入的房贷情况格式错误", Toast.LENGTH_SHORT).show();
//            }
//
//            if (Zz.isMobileNO(grxx2Et1111)) {
//
//            } else {
//                Toast.makeText(this, "您输入的推荐人手机格式错误", Toast.LENGTH_SHORT).show();
//            }
//            if (Zz.isEmail(grxx2Et1115)) {
//
//            } else {
//                Toast.makeText(this, "您输入的电子邮箱格式错误", Toast.LENGTH_SHORT).show();
//            }
        }
    }

    public boolean isUserNameAndPwdValid() {
        if (UrlConfig.borrow1 == 1&&grxx2Et1.getText().toString().trim().equals("")){
                Toast.makeText(this, "请输入现需借款",
                        Toast.LENGTH_SHORT).show();
                return false;
        } else if (UrlConfig.graduation1 == 1&&grxx2Et2.getText().toString().trim().equals("")){
            Toast.makeText(this, "请输入毕业年份",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (UrlConfig.houses1 == 1&&grxx2Et3.getText().toString().trim().equals("")){
                Toast.makeText(this, "请输入住房请款",
                        Toast.LENGTH_SHORT).show();
                return false;
        } else if (UrlConfig.marriage1 == 1&&grxx2Et4.getText().toString().trim().equals("")){
                Toast.makeText(this, "请输入婚姻情况",
                        Toast.LENGTH_SHORT).show();
            return false;
        } else if (UrlConfig.bao_liabilities1 == 1&&grxx2Et5.getText().toString().trim().equals("")){
                Toast.makeText(this, "请输入借贷宝债务",
                        Toast.LENGTH_SHORT).show();
            return false;
        } else if (UrlConfig.jiedaibao1 == 1&&grxx2Et6.getText().toString().trim().equals("")){
                Toast.makeText(this, "请输入借贷宝账号",
                        Toast.LENGTH_SHORT).show();
            return false;
        } else if (UrlConfig.address1 == 1&&grxx2Et7.getText().toString().trim().equals("")){
                Toast.makeText(this, "请输入详细地址",
                        Toast.LENGTH_SHORT).show();
            return false;
        } else if (UrlConfig.home_tel1 == 1&&grxx2Et8.getText().toString().trim().equals("")){
                Toast.makeText(this, "请输入住宅电话",
                        Toast.LENGTH_SHORT).show();
            return false;
        } else if (UrlConfig.house_loan1 == 1&&grxx2Et9.getText().toString().trim().equals("")){
                Toast.makeText(this, "请输入房贷情况",
                        Toast.LENGTH_SHORT).show();
            return false;
        } else if (UrlConfig. recommend1== 1&&grxx2Et10.getText().toString().trim().equals("")){
                Toast.makeText(this, "请输入推荐人手机号",
                        Toast.LENGTH_SHORT).show();
            return false;
        } else if (UrlConfig.jin_liabilities1 == 1&&grxx2Et11.getText().toString().trim().equals("")){
                Toast.makeText(this, "请输入今借到债务",
                        Toast.LENGTH_SHORT).show();
            return false;
        } else if (UrlConfig.credit_limit1 == 1&&grxx2Et13.getText().toString().trim().equals("")){
                Toast.makeText(this, "请输入信用卡额度",
                        Toast.LENGTH_SHORT).show();
            return false;
        } else if (UrlConfig.name1 == 1&&grxx2Et14.getText().toString().trim().equals("")){
                Toast.makeText(this, "请输入真实姓名",
                        Toast.LENGTH_SHORT).show();
                return false;
        } else if (UrlConfig.emails1 == 1&&grxx2Et15.getText().toString().trim().equals("")){
                Toast.makeText(this, "请输入电子邮箱",
                        Toast.LENGTH_SHORT).show();
            return false;
        } else if (UrlConfig.idcard1 == 1&&grxx2Et16.getText().toString().trim().equals("")){
                Toast.makeText(this, "请输入身份证号",
                        Toast.LENGTH_SHORT).show();
            return false;
        } else if (UrlConfig.QQ1 == 1&&grxx2Et17.getText().toString().trim().equals("")){
                Toast.makeText(this, "请输入QQ",
                        Toast.LENGTH_SHORT).show();
            return false;
        } else if (UrlConfig.zhima_score1 == 1&&grxx2Et18.getText().toString().trim().equals("")){
                Toast.makeText(this, "请输入芝麻信用分",
                        Toast.LENGTH_SHORT).show();
                return false;
        } else if (UrlConfig.credits1 == 1&&grxx2Et19.getText().toString().trim().equals("")){
                Toast.makeText(this, "请输入信用卡",
                        Toast.LENGTH_SHORT).show();
                return false;
        }
        return true;
    }

    @Override
    public void onResponse(GRXX2Bean grxx2Bean) {
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
        int stat = Integer.parseInt(grxx2Bean.getStat());
        Toast.makeText(this, grxx2Bean.getMsg(), Toast.LENGTH_SHORT).show();
        if (stat == 1){
            Intent intent = new Intent(this, SFRZActivity.class);
            GRXX2Activity.this.finish();
            startActivity(intent);
        }
    }

    @Override
    public void onResponse(ZMbean zmbean) {

    }

    @Override
    public void onResponse2(ZM2bean zm2bean) {
        int start = zm2bean.getStat();
        if (start == 0){
            Toast.makeText(this, zm2bean.getMsg(), Toast.LENGTH_SHORT).show();
        }else if (zm2bean.getStat() == 1){
            GRXX2Presreter presreter = new GRXX2Presreter(this,name,card,email,record,marital,housing,room,car,graduation_date,credit,edu,call,qq,treasure,
                    he_treasure,province,city,address,zhima_score,town,bao_liabilities,jin_liabilities,borrow);
            presreter.getData();
        }
    }

    @Override
    public void onFailure(String s) {

    }
}
