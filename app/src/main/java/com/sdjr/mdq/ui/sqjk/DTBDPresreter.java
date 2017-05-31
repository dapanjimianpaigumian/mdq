package com.sdjr.mdq.ui.sqjk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import com.sdjr.mdq.bean.DTBD2Bean;
import com.sdjr.mdq.bean.DTBDBean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.ui.rz.GDRZFragment;
import com.sdjr.mdq.ui.xzlx.XZLXActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/3.
 */

public class DTBDPresreter implements DTBDContract.Presreter ,DC.View{
    private DTBDContract.View view;
    private DTBDContract.Mode mode;
    private int id;
    private Context activity;

    public DTBDPresreter (DTBDContract.View view,Context activity){
        this.view = view;
        this.mode = new DTBDMode();
        this.activity = activity;
    }

    @Override
    public void getData() {
        id = UrlConfig.login;
        mode.loadDTBD(new Callback<DTBDBean>() {
            @Override
            public void onResponse(Call<DTBDBean> call, Response<DTBDBean> response) {
                if (response.isSuccessful()){
                    final DTBDBean body = response.body();
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
            public void onFailure(Call<DTBDBean> call, Throwable t) {
                DP dp = new DP(DTBDPresreter.this,activity);
                dp.getData();
//                UrlConfig.start = 1;
//                Intent intent = new Intent(activity,XZLXActivity.class);
//                activity.startActivity(intent);
            }
        },id);
    }

    @Override
    public void onResponse(DTBD2Bean dtbd2Bean) {
        UrlConfig.start = Integer.parseInt(dtbd2Bean.getInfo());
    }

    @Override
    public void onFailure(String s) {

    }
}
