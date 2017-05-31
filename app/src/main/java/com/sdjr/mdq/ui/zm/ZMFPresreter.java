package com.sdjr.mdq.ui.zm;

import android.os.Handler;

import com.sdjr.mdq.bean.ZMF2Bean;
import com.sdjr.mdq.bean.ZMFBean;
import com.sdjr.mdq.config.UrlConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/15.
 */

public class ZMFPresreter implements ZMFContract.Presreter{
    private ZMFContract.Mode mode;
    private ZMFContract.View view;

    public ZMFPresreter(ZMFContract.View view){
        this.view = view;
        this.mode = new ZMFMode();
    }

    @Override
    public void getData() {
        int id = UrlConfig.login;
        mode.loadZMFBean(new Callback<ZMFBean>() {
            @Override
            public void onResponse(Call<ZMFBean> call, Response<ZMFBean> response) {
                if (response.isSuccessful()){
                    final ZMFBean body = response.body();
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
            public void onFailure(Call<ZMFBean> call, Throwable t) {

            }
        },id);
    }

    @Override
    public void getData2() {
        int id = UrlConfig.login;
        mode.loadZMF2Bean(new Callback<ZMF2Bean>() {
            @Override
            public void onResponse(Call<ZMF2Bean> call, Response<ZMF2Bean> response) {
                if (response.isSuccessful()){
                    final ZMF2Bean body = response.body();
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
            public void onFailure(Call<ZMF2Bean> call, Throwable t) {

            }
        },id);
    }
}
