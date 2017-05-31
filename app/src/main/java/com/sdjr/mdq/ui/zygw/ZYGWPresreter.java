package com.sdjr.mdq.ui.zygw;

import android.os.Handler;

import com.sdjr.mdq.bean.ZYGW2Bean;
import com.sdjr.mdq.bean.ZYGWBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/11.
 */

public class ZYGWPresreter implements ZYGWContract.Presreter{
    private ZYGWContract.View view;
    private ZYGWContract.Mode mode;
    private String name, sex, consult_time,phone;

    public ZYGWPresreter(ZYGWContract.View view,String name,String sex,String consult_time,String phone){
        this.view = view;
        this.mode = new ZYGWMode();
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.consult_time = consult_time;
    }

    @Override
    public void getData() {
        String weichat_id = "o-KRi1";
        mode.loadZYGW(new Callback<ZYGWBean>() {
            @Override
            public void onResponse(Call<ZYGWBean> call, Response<ZYGWBean> response) {
                if (response.isSuccessful()){
                    final ZYGWBean body = response.body();
                    Handler handle = new Handler();
                    handle.post(new Runnable() {
                        @Override
                        public void run() {
                            view.onResponse(body);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<ZYGWBean> call, Throwable t) {

            }
        },weichat_id);
    }

    @Override
    public void getData2() {
        mode.loadZYGW2(new Callback<ZYGW2Bean>() {
            @Override
            public void onResponse(Call<ZYGW2Bean> call, Response<ZYGW2Bean> response) {
                if (response.isSuccessful()){
                    final ZYGW2Bean body = response.body();
                    Handler handle = new Handler();
                    handle.post(new Runnable() {
                        @Override
                        public void run() {
                            view.onResponse2(body);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<ZYGW2Bean> call, Throwable t) {

            }
        },name,sex,consult_time,phone);
    }
}
