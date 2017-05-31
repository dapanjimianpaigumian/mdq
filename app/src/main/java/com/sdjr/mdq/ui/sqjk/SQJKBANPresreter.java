package com.sdjr.mdq.ui.sqjk;

import android.os.Handler;

import com.sdjr.mdq.bean.SYBNBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/22.
 */

public class SQJKBANPresreter implements SQJKBANContract.Presreter{
    private SQJKBANContract.Mode mode;
    private SQJKBANContract.View view;

    public SQJKBANPresreter(SQJKBANContract.View view){
        this.view = view;
        this.mode = new SQJKBANMode();
    }

    @Override
    public void getData() {
        mode.loadSYBN(new Callback<SYBNBean>() {
            @Override
            public void onResponse(Call<SYBNBean> call, Response<SYBNBean> response) {
                if (response.isSuccessful()){
                    final SYBNBean body = response.body();
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
            public void onFailure(Call<SYBNBean> call, Throwable t) {

            }
        });
    }
}
