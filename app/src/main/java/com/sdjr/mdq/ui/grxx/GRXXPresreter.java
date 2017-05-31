package com.sdjr.mdq.ui.grxx;

import android.os.Handler;

import com.sdjr.mdq.bean.GRXXBean;
import com.sdjr.mdq.config.UrlConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/9.
 */

public class GRXXPresreter implements GRXXContract.Presreter {
    private GRXXContract.View view;
    private GRXXContract.Mode mode;
    private String company_name,company_email,company_size,industry,ci_industry,job,money,company_phone;

    public GRXXPresreter(GRXXContract.View view,String company_name,String company_email,String company_size,String industry,
                         String ci_industry,String job,String money,String company_phone){
        this.view = view;
        this.mode = new GRXXMode();
        this.company_name = company_name;
        this.company_email = company_email;
        this.company_size = company_size;
        this.industry = industry;
        this.ci_industry = ci_industry;
        this.job = job;
        this.money = money;
        this.company_phone = company_phone;
    }

    @Override
    public void getData() {
        int id = UrlConfig.login;
        mode.loadGRXX(new Callback<GRXXBean>() {
            @Override
            public void onResponse(Call<GRXXBean> call, Response<GRXXBean> response) {
                if (response.isSuccessful()){
                    final GRXXBean body = response.body();
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
            public void onFailure(Call<GRXXBean> call, Throwable t) {

            }
        },id,company_name,company_email,company_size,industry,ci_industry,job,money,company_phone);
    }
}
