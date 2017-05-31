package com.sdjr.mdq.ui.zc;

import android.os.Handler;

import com.sdjr.mdq.bean.ZCBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/3/28 0028.
 */

public class ZCPresreter implements ZCContract.Presreter{
    private ZCContract.View view;
    private ZCContract.Mode mode;
    private String userName;
    private String userPwd;
    private String page;

    public ZCPresreter(ZCContract.View view, String userName, String userPwd,String page){
        this.view = view;
        this.mode = new ZCMode();
        this.userName = userName;
        this.userPwd = userPwd;
        this.page = page;
    }


    @Override
    public void getData() {
        String phone = userName;
        String password = userPwd;
        String weichat_id = "o-KRi1";
        mode.loadZC(new Callback<ZCBean>() {
            @Override
            public void onResponse(Call<ZCBean> call, Response<ZCBean> response) {
                if (response.isSuccessful()){
                    final ZCBean body = response.body();
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
            public void onFailure(Call<ZCBean> call, Throwable t) {

            }
        },weichat_id,phone,password,page);
    }
}
