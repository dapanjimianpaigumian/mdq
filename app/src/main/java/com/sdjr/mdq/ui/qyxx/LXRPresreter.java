package com.sdjr.mdq.ui.qyxx;

import android.os.Handler;

import com.sdjr.mdq.bean.QYXX2Bean;
import com.sdjr.mdq.config.UrlConfig;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/17.
 */

public class LXRPresreter implements LRXContract.Presreter{
    private LRXContract.Mode mode ;
    private LRXContract.View view;
    private String data;

    public LXRPresreter (LRXContract.View view,String data){
        this.view = view;
        this.mode = new LXRMode();
        this.data = data;
    }

    @Override
    public void getData() {
        int id = UrlConfig.login;
        mode.loadQYXX(new Callback<QYXX2Bean>() {
            @Override
            public void onResponse(Call<QYXX2Bean> call, Response<QYXX2Bean> response) {
                if (response.isSuccessful()){
                    final QYXX2Bean body = response.body();
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
            public void onFailure(Call<QYXX2Bean> call, Throwable t) {

            }
        },id,data);
    }
}
