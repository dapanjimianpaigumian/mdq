package com.sdjr.mdq.ui.zc;


import android.os.Handler;

import com.sdjr.mdq.bean.YZMBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/3.
 */

public class YZMPresreter implements YZMContract.Presreter{
    private YZMContract.Mode mode;
    private YZMContract.View view;
    private String zcEdt11;

    public YZMPresreter (YZMContract.View view ,String zcEdt11){
        this.view = view;
        this.mode = new YZMMode();
        this.zcEdt11 = zcEdt11;
    }

    @Override
    public void getData() {
        String phone = zcEdt11;
        String weichat_id = "o-KRi1";
        mode.loadYZM(new Callback<YZMBean>() {
            @Override
            public void onResponse(Call<YZMBean> call, Response<YZMBean> response) {
                if (response.isSuccessful()){
                    final YZMBean body = response.body();
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
            public void onFailure(Call<YZMBean> call, Throwable t) {

            }
        },weichat_id,phone);
    }
}
