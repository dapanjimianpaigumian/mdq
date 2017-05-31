package com.sdjr.mdq.ui.grxx2;

import android.os.Handler;

import com.sdjr.mdq.bean.GRXX2Bean;
import com.sdjr.mdq.config.UrlConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/9.
 */

public class GRXX2Presreter implements GRXX2Contract.Presreter{
    private GRXX2Contract.View view;
    private GRXX2Contract.Mode mode;
    private String name,card,email,record,marital,housing,room,car,graduation_date,credit,edu,call,qq,treasure,
            he_treasure,province,city,address,zhima_score,town,bao_liabilities,jin_liabilities,borrow;

    public GRXX2Presreter (GRXX2Contract.View view,String name, String card,String email,String record,String marital,String housing,String room,String car
            ,String graduation_date,String credit,String edu,String call,String qq,String treasure,
                           String he_treasure,String province,String city,String address,String zhima_score,String town,String bao_liabilities
            ,String jin_liabilities,String borrow){
        this.view = view;
        this.mode = new GRXX2Mode();
        this.name = name;
        this.card = card;
        this.email = email;
        this.record = record;
        this.marital = marital;
        this.housing = housing;
        this.room = room;
        this.car = car;
        this.graduation_date = graduation_date;
        this.credit = credit;
        this.edu = edu;
        this.call = call;
        this.qq = qq;
        this.treasure = treasure;
        this.he_treasure = he_treasure;
        this.province = province;
        this.city = city;
        this.address = address;
        this.zhima_score = zhima_score;
        this.town = town;
        this.bao_liabilities = bao_liabilities;
        this.jin_liabilities = jin_liabilities;
        this.borrow = borrow;
    }

    @Override
    public void getData() {
        int id = UrlConfig.login;
        mode.loadGRXX2(new Callback<GRXX2Bean>() {
            @Override
            public void onResponse(Call<GRXX2Bean> call, Response<GRXX2Bean> response) {
                if (response.isSuccessful()){
                    final GRXX2Bean body = response.body();
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
            public void onFailure(Call<GRXX2Bean> call, Throwable t) {

            }
        },id,name,card,email,record,marital,housing,room,car,graduation_date,credit,edu,call,qq,treasure,
                he_treasure,province,city,address,zhima_score,town,bao_liabilities,jin_liabilities,borrow);
    }
}
