package com.sdjr.mdq.ui.cjwt;

import android.os.Handler;

import com.sdjr.mdq.bean.CJWTBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 2017/5/16.
 */

public class CJWTPresreter implements CJWTContract.Presreter{
    private CJWTContract.Mode mode;
    private CJWTContract.View view;

    public CJWTPresreter (CJWTContract.View view){
        this.view = view;
        this.mode = new CJWTMode();
    }

    @Override
    public void getData() {
        mode.loadCJWT(new Callback<CJWTBean>() {
            @Override
            public void onResponse(Call<CJWTBean> call, Response<CJWTBean> response) {
                if (response.isSuccessful()){
                    final CJWTBean body = response.body();
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
            public void onFailure(Call<CJWTBean> call, Throwable t) {

            }
        });
    }
}
