package com.sdjr.mdq.ui.grxx2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sdjr.mdq.R;
import com.sdjr.mdq.bean.ZM2bean;
import com.sdjr.mdq.bean.ZMbean;
import com.sdjr.mdq.config.UrlConfig;

import java.net.URLEncoder;
import java.util.List;

public class ZMSLActivity extends AppCompatActivity implements ZMSLContract.View{
    private int start = 10;
    private int id = 10;
    private String name,card;
    private String Identifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState!=null){
            int id = savedInstanceState.getInt("id");
            String name = savedInstanceState.getString("name");
            String card = savedInstanceState.getString("card");
            int start = savedInstanceState.getInt("start");
        }
        setContentView(R.layout.activity_zmsl);
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
        card = bundle.getString("card");
        if (start == 10){
            ZMSLPresreter presreter = new ZMSLPresreter(this,name,card,Identifier);
            presreter.getData();
        }
    }

    /*
    启动支付宝进行认证
    @param url 开放平台返回的URL
    */
    private void doVerify(String url) {
        if (hasApplication()) {
            Intent action = new Intent(Intent.ACTION_VIEW);
            StringBuilder builder = new StringBuilder();
            // 这里使用固定appid 20000067
            builder.append("alipays://platformapi/startapp?appId=20000067&url=");
            builder.append(URLEncoder.encode(url));
            action.setData(Uri.parse(builder.toString()));
            ZMSLActivity.this.finish();
            startActivity(action);
        } else {
            //处理没有安装支付宝的情况
            new AlertDialog.Builder(this)
                    .setMessage("是否下载并安装支付宝完成认证?")
                    .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent action = new Intent(Intent.ACTION_VIEW);
                            action.setData(Uri.parse("https://m.alipay.com"));
                            startActivity(action);
                        }
                    }).setNegativeButton("算了", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).show();
        }
    }

    /*
    判断是否安装了支付宝
    @return true 为已经安装
    */
    private boolean hasApplication() {
        PackageManager manager = getPackageManager();
        Intent action = new Intent(Intent.ACTION_VIEW);
        action.setData(Uri.parse("alipays://"));
        List list = manager.queryIntentActivities(action, PackageManager.GET_RESOLVED_FILTER);
        return list != null && list.size() > 0;
    }

    @Override
    public void onResponse(ZMbean zmbean) {
        start = Integer.parseInt(zmbean.getStat());
        if (zmbean.getUrl()!=null){
            doVerify(zmbean.getUrl());
        }
        if (zmbean.getIdentifier().getBiz_no()!=null){
            UrlConfig.zmsl = zmbean.getIdentifier().getBiz_no();
        }
    }

    @Override
    public void onResponse2(ZM2bean zm2bean) {

    }

    @Override
    public void onFailure(String s) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putInt("id", id);
        outState.putInt("start", start);
        outState.putString("name", name);
        outState.putString("card", card);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        int id = savedInstanceState.getInt("id");
        int start = savedInstanceState.getInt("start");
        String name = savedInstanceState.getString("name");
        String card = savedInstanceState.getString("card");
    }
}