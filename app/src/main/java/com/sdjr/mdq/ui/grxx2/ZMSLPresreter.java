package com.sdjr.mdq.ui.grxx2;

import android.os.Handler;

import com.sdjr.mdq.bean.ZM2bean;
import com.sdjr.mdq.bean.ZMFBean;
import com.sdjr.mdq.bean.ZMbean;
import com.sdjr.mdq.config.UrlConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/12.
 */

public class ZMSLPresreter implements ZMSLContract.Presreter{
    private ZMSLContract.Mode mode;
    private ZMSLContract.View view;
    private String name,card,Identifier;

    public ZMSLPresreter(ZMSLContract.View view,String name ,String card,String Identifier){
        this.view = view;
        this.mode = new ZMSLMode();
        this.card = card;
        this.name = name;
        this.Identifier = Identifier;
    }

    @Override
    public void getData() {
        int id = UrlConfig.login;
        String invokeurl = "com://com.sdjr.mdq://";
        mode.loadzmbean(new Callback<ZMbean>() {
            @Override
            public void onResponse(Call<ZMbean> call, Response<ZMbean> response) {
                if (response.isSuccessful()){
                    final ZMbean body = response.body();
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.onResponse(body);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<ZMbean> call, Throwable t) {

            }
        },id,card,name,invokeurl);
    }

    @Override
    public void getData2() {
        int id = UrlConfig.login;
        mode.loadzm2bean(new Callback<ZM2bean>() {
            @Override
            public void onResponse(Call<ZM2bean> call, Response<ZM2bean> response) {
                if (response.isSuccessful()){
                    final ZM2bean body = response.body();
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.onResponse2(body);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<ZM2bean> call, Throwable t) {

            }
        },id,Identifier);
    }

}
