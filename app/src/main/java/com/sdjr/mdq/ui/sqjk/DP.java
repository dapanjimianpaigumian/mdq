package com.sdjr.mdq.ui.sqjk;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.sdjr.mdq.bean.DTBD2Bean;
import com.sdjr.mdq.bean.DTBDBean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.ui.xzlx.XZLXActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/24.
 */

public class DP implements DC.Presreter{
    private DC.View view;
    private DC.Mode mode;
    private Context activity;

    public DP(DC.View view,Context activity){
        this.mode = new DM();
        this.view = view;
        this.activity = activity;
    }

    @Override
    public void getData() {
        int id = UrlConfig.login;
        mode.loadDTBD2(new Callback<DTBD2Bean>() {
            @Override
            public void onResponse(Call<DTBD2Bean> call, Response<DTBD2Bean> response) {
                if (response.isSuccessful()){
                    final DTBD2Bean body = response.body();
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
            public void onFailure(Call<DTBD2Bean> call, Throwable t) {

            }
        },id);
    }
}
