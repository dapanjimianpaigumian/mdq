package com.sdjr.mdq.ui.sfrz;

import android.os.Handler;

import com.sdjr.mdq.bean.JDBean;
import com.sdjr.mdq.config.UrlConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/19.
 */

public class JieDianPresreter implements JieDianContract.Presreter{
    private JieDianContract.Mode mode;
    private JieDianContract.View view;

    public JieDianPresreter(JieDianContract.View view){
        this.mode = new JieDianMode();
        this.view = view;
    }

    @Override
    public void getData() {
        int id = UrlConfig.login;
        mode.loadJD(new Callback<JDBean>() {
            @Override
            public void onResponse(Call<JDBean> call, Response<JDBean> response) {
                if (response.isSuccessful()){
                    final JDBean body = response.body();
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
            public void onFailure(Call<JDBean> call, Throwable t) {

            }
        },id);
    }
}
