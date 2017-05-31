package com.sdjr.mdq.ui.qyxx;

import android.os.Handler;

import com.sdjr.mdq.bean.QYXXBean;
import com.sdjr.mdq.config.UrlConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/9.
 */

public class QYXXPresreter implements QYXXContract.Presreter{
    private QYXXContract.View view;
    private QYXXContract.Mode mode;
    private String father_name,father_phone,mother_name,mother_phone,brothers_name,brothers_phone
            ,work_name,work_phone,friend_name,friend_phone;

    public QYXXPresreter(QYXXContract.View view,String father_name,String father_phone,String mother_name,String mother_phone,String brothers_name,String brothers_phone
            ,String work_name,String work_phone,String friend_name,String friend_phone){
        this.view = view;
        this.mode = new QYXXMode();
        this.father_name = father_name;
        this.father_phone = father_phone;
        this.mother_name = mother_name;
        this.mother_phone = mother_phone;
        this.brothers_name = brothers_name;
        this.brothers_phone = brothers_phone;
        this.work_name = work_name;
        this.work_phone = work_phone;
        this.friend_name = friend_name;
        this.friend_phone = friend_phone;
    }

    @Override
    public void getData() {
        int id = UrlConfig.login;
        mode.loadQYXX(new Callback<QYXXBean>() {
            @Override
            public void onResponse(Call<QYXXBean> call, Response<QYXXBean> response) {
                if (response.isSuccessful()){
                    final QYXXBean body = response.body();
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.onResponse(body
                            );
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<QYXXBean> call, Throwable t) {

            }
        },id,father_name,father_phone,mother_name,mother_phone,brothers_name,brothers_phone
                ,work_name,work_phone,friend_name,friend_phone);
    }
}
