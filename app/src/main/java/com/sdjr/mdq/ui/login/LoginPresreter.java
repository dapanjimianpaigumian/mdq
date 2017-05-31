package com.sdjr.mdq.ui.login;

import android.os.Handler;

import com.sdjr.mdq.bean.DLBean;
import com.sdjr.mdq.config.UrlConfig;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/4/27.
 */

public class LoginPresreter implements LoginContract.Presreter{
    private LoginContract.View view;
    private LoginContract.Mode mode;
    private String userName;
    private String userPwd;

    public LoginPresreter(LoginContract.View view, String userName, String userPwd){
        this.view = view;
        this.mode = new LoginMode();
        this.userName = userName;
        this.userPwd = userPwd;
    }

    @Override
    public void getData() {
        String phone = userName;
        String password = userPwd;
        String weichat_id = "o-KRi1";
        mode.loadDL(new Callback<DLBean>() {
            @Override
            public void onResponse(Call<DLBean> call, Response<DLBean> response) {
                if (response.isSuccessful()){
                    final DLBean body = response.body();
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
            public void onFailure(Call<DLBean> call, Throwable t) {
            }
        },weichat_id,phone,password);
    }
}
