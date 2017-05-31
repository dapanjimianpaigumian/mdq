package com.sdjr.mdq.ui.yys;

import android.os.Handler;
import android.util.Log;

import com.sdjr.mdq.bean.YYS2Bean;
import com.sdjr.mdq.bean.YYS3Bean;
import com.sdjr.mdq.bean.YYSBean;
import com.sdjr.mdq.config.UrlConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/12.
 */

public class YYSPresreter implements YYSContract.Presreter{
    private YYSContract.Mode mode;
    private YYSContract.View view;
    private String tel,pw,params,token,code,otherInfo;

    public YYSPresreter(YYSContract.View view,String tel,String pw,String params,String token,String code,String otherInfo){
        this.view = view;
        this.mode = new YYSMode();
        this.pw = pw;
        this.tel = tel;
        this.params = params;
        this.token = token;
        this.code = code;
        this.otherInfo = otherInfo;
    }

    @Override
    public void getData() {
        int id = UrlConfig.login;
        mode.loadYYSBean(new Callback<YYSBean>() {
            @Override
            public void onResponse(Call<YYSBean> call, Response<YYSBean> response) {
                if (response.isSuccessful()){
                    final YYSBean body = response.body();
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
            public void onFailure(Call<YYSBean> call, Throwable t) {

            }
        },id,tel,pw,otherInfo);
    }

    @Override
    public void getData2() {
        int id = UrlConfig.login;
        mode.loadYYS2Bean(new Callback<YYS2Bean>() {
            @Override
            public void onResponse(Call<YYS2Bean> call, Response<YYS2Bean> response) {
                if (response.isSuccessful()){
                    final YYS2Bean body = response.body();
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
            public void onFailure(Call<YYS2Bean> call, Throwable t) {

            }
        },id,params,token);
    }

    @Override
    public void getData3() {
        int id = UrlConfig.login;
        mode.loadYYS3Bean(new Callback<YYS3Bean>() {
            @Override
            public void onResponse(Call<YYS3Bean> call, Response<YYS3Bean> response) {
                if (response.isSuccessful()){
                    final YYS3Bean body = response.body();
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.onResponse3(body);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<YYS3Bean> call, Throwable t) {

            }
        },id,code,token);
    }
}
