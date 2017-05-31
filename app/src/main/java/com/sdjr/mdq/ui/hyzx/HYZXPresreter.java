package com.sdjr.mdq.ui.hyzx;

import android.os.Handler;

import com.sdjr.mdq.bean.HYZXBean;
import com.sdjr.mdq.config.UrlConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/19.
 */

public class HYZXPresreter implements HYZXContract.Presreter{
    private HYZXContract.View view;
    private HYZXContract.Mode mode;

    public HYZXPresreter(HYZXContract.View view){
        this.view = view;
        this.mode = new HYZXMode();
    }

    @Override
    public void getData() {
        int id = UrlConfig.login;
        mode.loadHYZX(new Callback<HYZXBean>() {
            @Override
            public void onResponse(Call<HYZXBean> call, Response<HYZXBean> response) {
                if (response.isSuccessful()){
                    final HYZXBean body = response.body();
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
            public void onFailure(Call<HYZXBean> call, Throwable t) {

            }
        },id);
    }
}
