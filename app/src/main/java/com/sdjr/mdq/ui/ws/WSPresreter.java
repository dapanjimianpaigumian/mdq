package com.sdjr.mdq.ui.ws;

import android.os.Handler;

import com.sdjr.mdq.bean.WSBean;
import com.sdjr.mdq.config.UrlConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/10.
 */

public class WSPresreter implements WSContract.Presreter{
    private WSContract.View view;
    private WSContract.Mode mode;

    public WSPresreter(WSContract.View view){
        this.view = view;
        this.mode = new WSMode();
    }

    @Override
    public void getData() {
        int id = UrlConfig.login;
        mode.loadWS(new Callback<WSBean>() {
            @Override
            public void onResponse(Call<WSBean> call, Response<WSBean> response) {
                if (response.isSuccessful()){
                    final WSBean body = response.body();
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
            public void onFailure(Call<WSBean> call, Throwable t) {

            }
        },id);
    }
}
