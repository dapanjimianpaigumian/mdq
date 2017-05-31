package com.sdjr.mdq.ui.xlrz;

import android.os.Handler;

import com.sdjr.mdq.bean.XLRZ2Bean;
import com.sdjr.mdq.bean.XLRZBean;
import com.sdjr.mdq.config.UrlConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/12.
 */

public class XLRZPresreter implements XLRZContract.Presreter{
    private XLRZContract.View view;
    private XLRZContract.Mode mode;
    private String tel,pw,params, token;

    public XLRZPresreter(XLRZContract.View view,String tel,String pw,String params,String token){
        this.view = view;
        this.mode = new XLRZMode();
        this.tel = tel;
        this.pw = pw;
        this.params = params;
        this.token = token;
    }

    @Override
    public void getData() {
        int id = UrlConfig.login;
        mode.loadXLRZBean(new Callback<XLRZBean>() {
            @Override
            public void onResponse(Call<XLRZBean> call, Response<XLRZBean> response) {
                if (response.isSuccessful()){
                    final XLRZBean body = response.body();
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
            public void onFailure(Call<XLRZBean> call, Throwable t) {

            }
        },id,tel,pw);
    }

    @Override
    public void getData2() {
        int id = UrlConfig.login;
        mode.loadXLRZ2Bean(new Callback<XLRZ2Bean>() {
            @Override
            public void onResponse(Call<XLRZ2Bean> call, Response<XLRZ2Bean> response) {
                if (response.isSuccessful()){
                    final XLRZ2Bean body = response.body();
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
            public void onFailure(Call<XLRZ2Bean> call, Throwable t) {

            }
        },id,params,token);
    }


}
