package com.sdjr.mdq.ui.xzlx;

import android.app.Activity;
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
import android.widget.TextView;
import android.widget.Toast;

import com.sdjr.mdq.R;
import com.sdjr.mdq.bean.DTBDBean;
import com.sdjr.mdq.bean.SFXZBean;
import com.sdjr.mdq.bean.WSBean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.ui.SBActivity;
import com.sdjr.mdq.ui.gjj.GJJActivity;
import com.sdjr.mdq.ui.gywm.GYWMActivity;
import com.sdjr.mdq.ui.jdrz.JDRZActivity;
import com.sdjr.mdq.ui.sfrz.SFRZActivity;
import com.sdjr.mdq.ui.sqjk.DTBDContract;
import com.sdjr.mdq.ui.sqjk.DTBDPresreter;
import com.sdjr.mdq.ui.tbrz.TBRZActivity;
import com.sdjr.mdq.ui.ws.WSContract;
import com.sdjr.mdq.ui.ws.WSPresreter;
import com.sdjr.mdq.ui.xlrz.XLRZActivity;
import com.sdjr.mdq.ui.xykrz.XYKRZActivity;
import com.sdjr.mdq.ui.yys.YYSActivity;
import com.sdjr.mdq.ui.zxrz.ZXRZActivity;
import com.sdjr.mdq.widget.LoadingDialog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XZLXActivity extends AppCompatActivity implements XZLXContract.View,DTBDContract.View,WSContract.View{
    @Bind(R.id.xzlx_btn1)
    Button xzlxBtn1;
//    @Bind(R.id.xzlx_btn2)
//    Button xzlxBtn2;
    @Bind(R.id.xzlx_btn3)
    Button xzlxBtn3;
    @Bind(R.id.xzlx_btn4)
    Button xzlxBtn4;
    @Bind(R.id.xzlx_text1)
    TextView xzlxText1;
    @Bind(R.id.xzlx_text2)
    TextView xzlxText2;
    private ImageView xzlximg01;
    private int identity = 2 ;
    private Activity activity;
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
        setContentView(R.layout.activity_xzlx);
        ButterKnife.bind(this);
        loadingDialog = new LoadingDialog(this);
        xzlximg01 = (ImageView) findViewById(R.id.xzlx_img01);
        initView();
    }

    public void initView() {
        xzlximg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XZLXActivity.this.finish();
            }
        });
    }

    @OnClick({R.id.xzlx_btn1, R.id.xzlx_btn3, R.id.xzlx_btn4, R.id.xzlx_text1, R.id.xzlx_text2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xzlx_btn1:
                xzlxBtn1.setBackgroundResource(R.drawable.yuanlan);
                xzlxBtn1.setTextColor(this.getResources().getColor(R.color.bai));
//                xzlxBtn2.setBackgroundResource(R.drawable.yuanbai);
//                xzlxBtn2.setTextColor(this.getResources().getColor(R.color.hei));
                xzlxBtn3.setBackgroundResource(R.drawable.yuanbai);
                xzlxBtn3.setTextColor(this.getResources().getColor(R.color.hei));
                identity = 2;
                break;
//            case R.id.xzlx_btn2:
//                xzlxBtn1.setBackgroundResource(R.drawable.yuanbai);
//                xzlxBtn1.setTextColor(this.getResources().getColor(R.color.hei));
////                xzlxBtn2.setBackgroundResource(R.drawable.yuanlan);
////                xzlxBtn2.setTextColor(this.getResources().getColor(R.color.bai));
//                xzlxBtn3.setBackgroundResource(R.drawable.yuanbai);
//                xzlxBtn3.setTextColor(this.getResources().getColor(R.color.hei));
//                identity = 3;
//                break;
            case R.id.xzlx_btn3:
                xzlxBtn1.setBackgroundResource(R.drawable.yuanbai);
                xzlxBtn1.setTextColor(this.getResources().getColor(R.color.hei));
//                xzlxBtn2.setBackgroundResource(R.drawable.yuanbai);
//                xzlxBtn2.setTextColor(this.getResources().getColor(R.color.hei));
                xzlxBtn3.setBackgroundResource(R.drawable.yuanlan);
                xzlxBtn3.setTextColor(this.getResources().getColor(R.color.bai));
                identity = 1;
                break;
            case R.id.xzlx_btn4:
                loadingDialog.show();
                XZLXPresreter presreter = new XZLXPresreter(this,identity);
                presreter.getData();
                break;
            case R.id.xzlx_text1:
                UrlConfig.web = 2;
                Intent intent = new Intent(XZLXActivity.this, GYWMActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name","类型介绍");
                bundle.putInt("id",31);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.xzlx_text2:
                UrlConfig.web = 2;
                intent = new Intent(XZLXActivity.this, GYWMActivity.class);
                bundle = new Bundle();
                bundle.putString("name","类型介绍");
                bundle.putInt("id",31);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onResponse(SFXZBean sfxzBean) {
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
        DTBDPresreter presreter = new DTBDPresreter(this,activity);
        presreter.getData();
        if (sfxzBean.getStat().equals("1")){
            Intent intent = new Intent(XZLXActivity.this, SFRZActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this, sfxzBean.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse(DTBDBean dtbdBean) {
        WSPresreter presreter = new WSPresreter(this);
        presreter.getData();
        if (dtbdBean.getPurviews().getStep5().get(0).getR().equals("1")) {
            if (dtbdBean.getPurviews().getStep5().get(0).getId().equals(UrlConfig.yunying)) {
                UrlConfig.yunying1 = 1;
//                Intent intent = new Intent(context, YYSActivity.class);
//                startActivity(intent);
            } else if (dtbdBean.getPurviews().getStep5().get(0).getId().equals(UrlConfig.gongjijin)) {
                UrlConfig.gongjijin1 = 1;
//                Intent intent = new Intent(context, GJJActivity.class);
//                startActivity(intent);
            } else if (dtbdBean.getPurviews().getStep5().get(0).getId().equals(UrlConfig.taobao)) {
                UrlConfig.taobao1 = 1;
//                Intent intent = new Intent(context, TBRZActivity.class);
//                startActivity(intent);
            } else if (dtbdBean.getPurviews().getStep5().get(0).getId().equals(UrlConfig.shebao)) {
                UrlConfig.shebao1 = 1;
//                Intent intent = new Intent(context, SBActivity.class);
//                startActivity(intent);
            } else if (dtbdBean.getPurviews().getStep5().get(0).getId().equals(UrlConfig.xuexin)) {
                UrlConfig.xuexin1 = 1;
//                Intent intent = new Intent(context, XLRZActivity.class);
//                startActivity(intent);
            } else if (dtbdBean.getPurviews().getStep5().get(0).getId().equals(UrlConfig.jd)) {
                UrlConfig.jd1 = 1;
//                Intent intent = new Intent(context, JDRZActivity.class);
//                startActivity(intent);
            } else if (dtbdBean.getPurviews().getStep5().get(0).getId().equals(UrlConfig.xinyongka)) {
                UrlConfig.xinyongka1 = 1;
//                Intent intent = new Intent(context, XYKRZActivity.class);
//                startActivity(intent);
            } else if (dtbdBean.getPurviews().getStep5().get(0).getId().equals(UrlConfig.zhengxin)) {
                UrlConfig.zhengxin1 = 1;
//                Intent intent = new Intent(context, ZXRZActivity.class);
//                startActivity(intent);
            }
        }
        if (dtbdBean.getPurviews().getStep1() != null) {
            for (int i = 0; i < dtbdBean.getPurviews().getStep1().size(); i++) {
                if (dtbdBean.getPurviews().getStep1().get(i).getR().equals("1")) {
                    if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.borrow)) {
                        UrlConfig.borrow1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.credits)) {
                        UrlConfig.credits1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.address)) {
                        UrlConfig.address1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.car_loan)) {
                        UrlConfig.car_loan1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.jin_liabilities)) {
                        UrlConfig.jin_liabilities1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.graduation)) {
                        UrlConfig.graduation1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.house_loan)) {
                        UrlConfig.house_loan1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.bao_liabilities)) {
                        UrlConfig.bao_liabilities1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.zhima_score)) {
                        UrlConfig.zhima_score1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.home_tel)) {
                        UrlConfig.home_tel1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.credit_limit)) {
                        UrlConfig.credit_limit1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.name)) {
                        UrlConfig.name1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.idcard)) {
                        UrlConfig.idcard1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.marriage)) {
                        UrlConfig.marriage1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.QQ)) {
                        UrlConfig.QQ1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.houses)) {
                        UrlConfig.houses1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.jiedaibao)) {
                        UrlConfig.jiedaibao1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.emails)) {
                        UrlConfig.emails1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.recommend)) {
                        UrlConfig.recommend1 = 1;
                    }
                } else if (dtbdBean.getPurviews().getStep1().get(i).getR().equals("0")) {
                    if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.borrow)) {
                        UrlConfig.borrow1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.credits)) {
                        UrlConfig.credits1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.address)) {
                        UrlConfig.address1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.car_loan)) {
                        UrlConfig.car_loan1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.jin_liabilities)) {
                        UrlConfig.jin_liabilities1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.graduation)) {
                        UrlConfig.graduation1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.house_loan)) {
                        UrlConfig.house_loan1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.bao_liabilities)) {
                        UrlConfig.bao_liabilities1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.zhima_score)) {
                        UrlConfig.zhima_score1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.home_tel)) {
                        UrlConfig.home_tel1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.credit_limit)) {
                        UrlConfig.credit_limit1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.name)) {
                        UrlConfig.name1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.idcard)) {
                        UrlConfig.idcard1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.marriage)) {
                        UrlConfig.marriage1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.QQ)) {
                        UrlConfig.QQ1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.houses)) {
                        UrlConfig.houses1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.jiedaibao)) {
                        UrlConfig.jiedaibao1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.emails)) {
                        UrlConfig.emails1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.recommend)) {
                        UrlConfig.recommend1 = 2;
                    }
                }
            }
        }else {
            UrlConfig.step1 = 1;
        }

        if (dtbdBean.getPurviews().getStep2() != null) {
            for (int i = 0; i < dtbdBean.getPurviews().getStep2().size(); i++) {
                if (dtbdBean.getPurviews().getStep2().get(i).getR().equals("1")) {
                    if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.workmate)) {
                        UrlConfig.workmate1 = 1;
                    } else if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.mother)) {
                        UrlConfig.mother1 = 1;
                    } else if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.father)) {
                        UrlConfig.father1 = 1;
                    } else if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.family)) {
                        UrlConfig.family1 = 1;
                    } else if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.friend)) {
                        UrlConfig.friend1 = 1;
                    }
                } else if (dtbdBean.getPurviews().getStep2().get(i).getR().equals("0")) {
                    if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.workmate)) {
                        UrlConfig.workmate1 = 2;
                    } else if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.mother)) {
                        UrlConfig.mother1 = 2;
                    } else if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.father)) {
                        UrlConfig.father1 = 2;
                    } else if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.family)) {
                        UrlConfig.family1 = 2;
                    } else if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.friend)) {
                        UrlConfig.friend1 = 2;
                    }
                }
            }
        }else {
            UrlConfig.step2 = 1;
        }

        if (dtbdBean.getPurviews().getStep3() != null){
            for (int i = 0; i < dtbdBean.getPurviews().getStep3().size(); i++) {
                if (dtbdBean.getPurviews().getStep3().get(i).getR().equals("1")){
                    if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_email)){
                        UrlConfig.com_email1 = 1;
                    }else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_scale)){
                        UrlConfig.com_scale1 = 1;
                    }else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.company)){
                        UrlConfig.company1 = 1;
                    }else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_type)){
                        UrlConfig.com_type1 = 1;
                    }else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_position)){
                        UrlConfig.com_position1 = 1;
                    }else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_tel)){
                        UrlConfig.com_tel1 = 1;
                    }else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.salary)){
                        UrlConfig.salary1 = 1;
                    }
                }else if (dtbdBean.getPurviews().getStep3().get(i).getR().equals("0")){
                    if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_email)){
                        UrlConfig.com_email1 = 2;
                    }else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_scale)){
                        UrlConfig.com_scale1 = 2;
                    }else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.company)){
                        UrlConfig.company1 = 2;
                    }else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_type)){
                        UrlConfig.com_type1 = 2;
                    }else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_position)){
                        UrlConfig.com_position1 = 2;
                    }else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_tel)){
                        UrlConfig.com_tel1 = 2;
                    }else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.salary)){
                        UrlConfig.salary1 = 2;
                    }
                }
            }
        }else {
            UrlConfig.step3 = 1;
        }

        if (dtbdBean.getPurviews().getStep4() != null) {
            for (int i = 0; i < dtbdBean.getPurviews().getStep4().size(); i++) {
                if (dtbdBean.getPurviews().getStep4().get(i).getR().equals("1")) {
                    if (dtbdBean.getPurviews().getStep4().get(i).getId().equals(UrlConfig.front)) {
                        UrlConfig.front1 = 1;
                    } else if (dtbdBean.getPurviews().getStep4().get(i).getId().equals(UrlConfig.more_img)) {
                        UrlConfig.more_img1 = 1;
                    } else if (dtbdBean.getPurviews().getStep4().get(i).getId().equals(UrlConfig.back)) {
                        UrlConfig.back1 = 1;
                    } else if (dtbdBean.getPurviews().getStep4().get(i).getId().equals(UrlConfig.handsID)) {
                        UrlConfig.handsID1 = 1;
                    }
                } else if (dtbdBean.getPurviews().getStep4().get(i).getR().equals("0")) {
                    if (dtbdBean.getPurviews().getStep4().get(i).getId().equals(UrlConfig.front)) {
                        UrlConfig.front1 = 2;
                    } else if (dtbdBean.getPurviews().getStep4().get(i).getId().equals(UrlConfig.more_img)) {
                        UrlConfig.more_img1 = 2;
                    } else if (dtbdBean.getPurviews().getStep4().get(i).getId().equals(UrlConfig.back)) {
                        UrlConfig.back1 = 2;
                    } else if (dtbdBean.getPurviews().getStep4().get(i).getId().equals(UrlConfig.handsID)) {
                        UrlConfig.handsID1 = 2;
                    }
                }
            }
        }else {
            UrlConfig.step4 = 1;
        }
    }

    @Override
    public void onResponse(WSBean wsBean) {
        if (wsBean.getInfo().equals("2222")){
            if (UrlConfig.yunying1 == 1){
                Intent intent = new Intent(XZLXActivity.this, YYSActivity.class);
                startActivity(intent);
            }else if (UrlConfig.gongjijin1 == 1){
                Intent intent = new Intent(XZLXActivity.this, GJJActivity.class);
                startActivity(intent);
            }else if (UrlConfig.taobao1 == 1){
                Intent intent = new Intent(XZLXActivity.this, TBRZActivity.class);
                startActivity(intent);
            }else if (UrlConfig.shebao1 == 1){
                Intent intent = new Intent(XZLXActivity.this, SBActivity.class);
                startActivity(intent);
            }else if (UrlConfig.xuexin1 == 1){
                Intent intent = new Intent(XZLXActivity.this, XLRZActivity.class);
                startActivity(intent);
            }else if (UrlConfig.jd1 == 1){
                Intent intent = new Intent(XZLXActivity.this, JDRZActivity.class);
                startActivity(intent);
            }else if (UrlConfig.xinyongka1 == 1){
                Intent intent = new Intent(XZLXActivity.this, XYKRZActivity.class);
                startActivity(intent);
            }else if (UrlConfig.zhengxin1 == 1){
                Intent intent = new Intent(XZLXActivity.this, ZXRZActivity.class);
                startActivity(intent);
            }
        }else if (wsBean.getInfo().equals("1111")){
            Intent intent = new Intent(XZLXActivity.this, SFRZActivity.class);
            startActivity(intent);
        }else if (wsBean.getInfo().equals("2111")){
            Intent intent = new Intent(XZLXActivity.this, SFRZActivity.class);
            startActivity(intent);
        }else if (wsBean.getInfo().equals("2211")){
            Intent intent = new Intent(XZLXActivity.this, SFRZActivity.class);
            startActivity(intent);
        }else if (wsBean.getInfo().equals("2221")){
            Intent intent = new Intent(XZLXActivity.this, SFRZActivity.class);
            startActivity(intent);
        }

        if (UrlConfig.step3 == 1){
            if (wsBean.getInfo().equals("2212")){
                if (UrlConfig.yunying1 == 1){
                    Intent intent = new Intent(XZLXActivity.this, YYSActivity.class);
                    startActivity(intent);
                }else if (UrlConfig.gongjijin1 == 1){
                    Intent intent = new Intent(XZLXActivity.this, GJJActivity.class);
                    startActivity(intent);
                }else if (UrlConfig.taobao1 == 1){
                    Intent intent = new Intent(XZLXActivity.this, TBRZActivity.class);
                    startActivity(intent);
                }else if (UrlConfig.shebao1 == 1){
                    Intent intent = new Intent(XZLXActivity.this, SBActivity.class);
                    startActivity(intent);
                }else if (UrlConfig.xuexin1 == 1){
                    Intent intent = new Intent(XZLXActivity.this, XLRZActivity.class);
                    startActivity(intent);
                }else if (UrlConfig.jd1 == 1){
                    Intent intent = new Intent(XZLXActivity.this, JDRZActivity.class);
                    startActivity(intent);
                }else if (UrlConfig.xinyongka1 == 1){
                    Intent intent = new Intent(XZLXActivity.this, XYKRZActivity.class);
                    startActivity(intent);
                }else if (UrlConfig.zhengxin1 == 1){
                    Intent intent = new Intent(XZLXActivity.this, ZXRZActivity.class);
                    startActivity(intent);
                }
            }else {
                if (wsBean.getInfo().equals("2212")){
                    Intent intent = new Intent(XZLXActivity.this, SFRZActivity.class);
                    startActivity(intent);
                }
            }
        }
    }

    @Override
    public void onFailure(String s) {

    }
}
