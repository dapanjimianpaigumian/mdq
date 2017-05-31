package com.sdjr.mdq.ui.yhrz;

import android.os.Handler;

import com.sdjr.mdq.bean.YHRZ2Bean;
import com.sdjr.mdq.bean.YHRZBean;
import com.sdjr.mdq.config.UrlConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/13.
 */

public class YHRZPresreter implements YHRZContract.Presreter{
    private YHRZContract.View view;
    private YHRZContract.Mode mode;
    private String tel,pw,params,token,idcode;

    public YHRZPresreter (YHRZContract.View view,String tel,String pw,String params,String token,String idcode){
        this.view = view;
        this.mode = new YHRZMode();
        this.pw = pw;
        this.tel = tel;
        this.params = params;
        this.token = token;
        this.idcode = idcode;
    }


    @Override
    public void getData() {
        int id = UrlConfig.login;
        mode.loadYHRZBean(new Callback<YHRZBean>() {
            @Override
            public void onResponse(Call<YHRZBean> call, Response<YHRZBean> response) {
                if (response.isSuccessful()){
                    final YHRZBean body = response.body();
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
            public void onFailure(Call<YHRZBean> call, Throwable t) {

            }
        },id,tel,pw,idcode);
    }

    @Override
    public void getData2() {
        int id = UrlConfig.login;
        mode.loadYHRZ2Bean(new Callback<YHRZ2Bean>() {
            @Override
            public void onResponse(Call<YHRZ2Bean> call, Response<YHRZ2Bean> response) {
                if (response.isSuccessful()){
                    final YHRZ2Bean body = response.body();
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
            public void onFailure(Call<YHRZ2Bean> call, Throwable t) {

            }
        },id,params,token);
    }
}
