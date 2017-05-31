package com.sdjr.mdq.ui.xykrz;

import android.os.Handler;

import com.sdjr.mdq.bean.XYKRZ2Bean;
import com.sdjr.mdq.bean.XYKRZ3Bean;
import com.sdjr.mdq.bean.XYKRZBean;
import com.sdjr.mdq.config.UrlConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/13.
 */

public class XYKRZPresreter implements XYKRZContract.Presreter{
    private XYKRZContract.View view;
    private XYKRZContract.Mode mode;
    private String tel,pw,params,token,code;

    public XYKRZPresreter(XYKRZContract.View view,String tel,String pw,String params,String token,String code){
        this.view = view;
        this.mode = new XYKRZMode();
        this.pw = pw;
        this.tel = tel;
        this.params = params;
        this.token = token;
        this.code = code;
    }

    @Override
    public void getData() {
        int id = UrlConfig.login;
        mode.loadXYKRZBean(new Callback<XYKRZBean>() {
            @Override
            public void onResponse(Call<XYKRZBean> call, Response<XYKRZBean> response) {
                if (response.isSuccessful()){
                    final XYKRZBean body = response.body();
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
            public void onFailure(Call<XYKRZBean> call, Throwable t) {

            }
        },id,tel,pw);
    }

    @Override
    public void getData2() {
        int id = UrlConfig.login;
            mode.loadXYKRZ2Bean(new Callback<XYKRZ2Bean>() {
                @Override
                public void onResponse(Call<XYKRZ2Bean> call, Response<XYKRZ2Bean> response) {
                    if (response.isSuccessful()){
                        final XYKRZ2Bean body = response.body();
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
                public void onFailure(Call<XYKRZ2Bean> call, Throwable t) {

                }
            },id,params,token);
    }

    @Override
    public void getData3() {
        int id = UrlConfig.login;
        mode.loadXYKRZ3Bean(new Callback<XYKRZ3Bean>() {
            @Override
            public void onResponse(Call<XYKRZ3Bean> call, Response<XYKRZ3Bean> response) {
                if (response.isSuccessful()){
                    final XYKRZ3Bean body = response.body();
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
            public void onFailure(Call<XYKRZ3Bean> call, Throwable t) {

            }
        },id,code,token);
    }
}
