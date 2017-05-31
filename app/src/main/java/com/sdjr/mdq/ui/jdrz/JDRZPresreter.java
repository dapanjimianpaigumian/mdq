package com.sdjr.mdq.ui.jdrz;

import android.os.Handler;

import com.sdjr.mdq.bean.JDRZ2Bean;
import com.sdjr.mdq.bean.JDRZ3Bean;
import com.sdjr.mdq.bean.JDRZBean;
import com.sdjr.mdq.config.UrlConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/12.
 */

public class JDRZPresreter implements JDRZContract.Presreter{
    private JDRZContract.Mode mode;
    private JDRZContract.View view;
    private String tel,pw,params,token,code;

    public JDRZPresreter (JDRZContract.View view,String tel,String pw,String params,String token,String code){
        this.view = view;
        this.mode = new JDRZMode();
        this.pw = pw;
        this.tel = tel;
        this.params = params;
        this.token = token;
        this.code = code;
    }

    @Override
    public void getData() {
        int id = UrlConfig.login;
        mode.loadJDRZBean(new Callback<JDRZBean>() {
            @Override
            public void onResponse(Call<JDRZBean> call, Response<JDRZBean> response) {
                if (response.isSuccessful()){
                    final JDRZBean body = response.body();
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
            public void onFailure(Call<JDRZBean> call, Throwable t) {

            }
        },id,tel,pw);
    }

    @Override
    public void getData2() {
        int id = UrlConfig.login;
        mode.loadJDRZ2Bean(new Callback<JDRZ2Bean>() {
            @Override
            public void onResponse(Call<JDRZ2Bean> call, Response<JDRZ2Bean> response) {
                if (response.isSuccessful()){
                    final JDRZ2Bean body = response.body();
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
            public void onFailure(Call<JDRZ2Bean> call, Throwable t) {

            }
        },id,params,token);
    }

    @Override
    public void getData3() {
        int id = UrlConfig.login;
        mode.loadJDRZ3Bean(new Callback<JDRZ3Bean>() {
            @Override
            public void onResponse(Call<JDRZ3Bean> call, Response<JDRZ3Bean> response) {
                if (response.isSuccessful()){
                    final JDRZ3Bean body = response.body();
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
            public void onFailure(Call<JDRZ3Bean> call, Throwable t) {

            }
        },id,code,token);
    }
}
