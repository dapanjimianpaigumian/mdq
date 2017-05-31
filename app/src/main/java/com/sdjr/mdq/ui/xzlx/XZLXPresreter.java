package com.sdjr.mdq.ui.xzlx;

import android.os.Handler;

import com.sdjr.mdq.bean.SFXZBean;
import com.sdjr.mdq.config.UrlConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/9.
 */

public class XZLXPresreter implements XZLXContract.Presreter{
    private XZLXContract.Mode mode;
    private XZLXContract.View view;
    private int identity;

    public XZLXPresreter (XZLXContract.View view,int identity){
        this.view = view;
        this.mode = new XZLXMode();
        this.identity = identity;
    }

    @Override
    public void getData() {
        int id = UrlConfig.login;
        mode.loadSFXZ(new Callback<SFXZBean>() {
            @Override
            public void onResponse(Call<SFXZBean> call, Response<SFXZBean> response) {
                if (response.isSuccessful()){
                    final SFXZBean body = response.body();
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
            public void onFailure(Call<SFXZBean> call, Throwable t) {

            }
        },id,identity);
    }
}
