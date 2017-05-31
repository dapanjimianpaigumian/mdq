package com.sdjr.mdq.ui.tbrz;

import android.os.Handler;
import android.util.Log;

import com.sdjr.mdq.bean.TBRZ2Bean;
import com.sdjr.mdq.bean.TBRZBean;
import com.sdjr.mdq.config.UrlConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/13.
 */

public class TBRZPresreter implements TBRZContract.Presreter{
    private TBRZContract.View view;
    private TBRZContract.Mode mode;
    private String params,token;

    public TBRZPresreter (TBRZContract.View view,String params,String token){
        this.view = view;
        this.mode = new TBRZMode();
        this.token = token;
        this.params = params;
    }

    @Override
    public void getData() {
        int id = UrlConfig.login;
        mode.loadTBRZBean(new Callback<TBRZBean>() {
            @Override
            public void onResponse(Call<TBRZBean> call, Response<TBRZBean> response) {
                if (response.isSuccessful()){
                    final TBRZBean body = response.body();
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
            public void onFailure(Call<TBRZBean> call, Throwable t) {

            }
        },id);
    }

    @Override
    public void getData2() {
        int id = UrlConfig.login;
        mode.loadTBRZ2Bean(new Callback<TBRZ2Bean>() {
            @Override
            public void onResponse(Call<TBRZ2Bean> call, Response<TBRZ2Bean> response) {
                if (response.isSuccessful()){
                    final TBRZ2Bean body = response.body();
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
            public void onFailure(Call<TBRZ2Bean> call, Throwable t) {
                Log.i("asd", "onFailure: ========失败啦====");
            }
        },id,params,token);
    }
}
