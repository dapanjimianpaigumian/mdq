package com.sdjr.mdq.ui.zm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.android.moblie.zmxy.antgroup.creditsdk.app.CreditApp;
import com.sdjr.mdq.R;
import com.sdjr.mdq.bean.DTBDBean;
import com.sdjr.mdq.bean.ZMF2Bean;
import com.sdjr.mdq.bean.ZMFBean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.ui.jdrz.JDRZActivity;
import com.sdjr.mdq.ui.sfrz.SFRZActivity;
import com.sdjr.mdq.ui.sqjk.DTBDContract;
import com.sdjr.mdq.ui.sqjk.DTBDPresreter;
import com.sdjr.mdq.ui.tbrz.TBRZActivity;
import com.sdjr.mdq.ui.xlrz.XLRZActivity;
import com.sdjr.mdq.ui.xykrz.XYKRZActivity;
import com.sdjr.mdq.ui.xzlx.XZLXActivity;
import com.sdjr.mdq.ui.yhrz.YHRZActivity;
import com.sdjr.mdq.ui.yys.YYSActivity;

public class ZMFActivity extends AppCompatActivity implements DemoView,ZMFContract.View,DTBDContract.View{
    private Button authButton;
    private DemoPresenter presenter;
    public static String params;
    public static String sign;
    private Context activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zmf);
        if (DemoPresenterImpl.zmf == 2){
            DTBDPresreter presreter1 = new DTBDPresreter(ZMFActivity.this,activity);
            presreter1.getData();
            ZMFActivity.this.finish();
        }else {
            ZMFPresreter presreter = new ZMFPresreter(this);
            presreter.getData();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (DemoPresenterImpl.zmf == 2){
            ZMFPresreter presreter = new ZMFPresreter(this);
            presreter.getData2();
        }else {
            ZMFPresreter presreter = new ZMFPresreter(this);
            presreter.getData();
        }
    }

    @Override
    public void toastMessage(final String msg) {
//check context
        if(isFinishing() || TextUtils.isEmpty(msg)){
            return;
        }
        //toast message
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ZMFActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //onActivityResult callback
        CreditApp.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onResponse(ZMFBean zmfBean) {
        if (zmfBean.getStat().equals("1")){
            sign = zmfBean.getSign();
            params = zmfBean.getParam();
            presenter = new DemoPresenterImpl(this, this);
            presenter.doCreditRequest();
        }
    }

    @Override
    public void onResponse2(ZMF2Bean zmf2Bean) {
        if (zmf2Bean.getStat().equals("2")){
            DTBDPresreter presreter1 = new DTBDPresreter(ZMFActivity.this,activity);
            presreter1.getData();
        }
    }

    @Override
    public void onResponse(DTBDBean dtbdBean) {
        UrlConfig.start = Integer.parseInt(dtbdBean.getInfo());
        switch (UrlConfig.start){
            case 1:
                Intent intent = new Intent(this, XZLXActivity.class);
                ZMFActivity.this.finish();
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, SFRZActivity.class);
                ZMFActivity.this.finish();
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(this, ZMFActivity.class);
                ZMFActivity.this.finish();
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(this, YYSActivity.class);
                ZMFActivity.this.finish();
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(this, TBRZActivity.class);
                ZMFActivity.this.finish();
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(this, JDRZActivity.class);
                ZMFActivity.this.finish();
                startActivity(intent);
                break;
            case 7:
                intent = new Intent(this, XLRZActivity.class);
                ZMFActivity.this.finish();
                startActivity(intent);
                break;
            case 8:
                intent = new Intent(this, YHRZActivity.class);
                ZMFActivity.this.finish();
                startActivity(intent);
                break;
            case 9:
                intent = new Intent(this, XYKRZActivity.class);
                ZMFActivity.this.finish();
                startActivity(intent);
                break;
            case 10:
                Toast.makeText(this, "您的基本认证已完成", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onFailure(String s) {

    }
}
