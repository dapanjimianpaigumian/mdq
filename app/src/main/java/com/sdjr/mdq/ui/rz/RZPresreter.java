package com.sdjr.mdq.ui.rz;

import android.os.Handler;

import com.sdjr.mdq.bean.RZBean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.widget.LoadingDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/11.
 */

public class RZPresreter implements RZContract.Presreter{
    private RZContract.View view;
    private RZContract.Mode mode;
    private LoadingDialog loadingDialog;

    public RZPresreter (RZContract.View view,LoadingDialog loadingDialog){
        this.view = view;
        this.mode = new RZMode();
        this.loadingDialog = loadingDialog;
    }

    @Override
    public void getData() {
        int id = UrlConfig.login;
        mode.loadRZ(new Callback<RZBean>() {
            @Override
            public void onResponse(Call<RZBean> call, Response<RZBean> response) {
                UrlConfig.rz = 0;
                if (response.isSuccessful()){
                    final RZBean body = response.body();
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
            public void onFailure(Call<RZBean> call, Throwable t) {
                if (loadingDialog.isShowing()) {
                    loadingDialog.dismiss();
                }
                UrlConfig.rz = 1;
            }
        },id);
    }
}
