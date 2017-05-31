package com.sdjr.mdq.ui.grxx2;

import com.sdjr.mdq.bean.GRXX2Bean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/9.
 */

public class GRXX2Mode implements GRXX2Contract.Mode{
    @Override
    public void loadGRXX2(Callback<GRXX2Bean> callback, int id, String name, String card, String email, String record, String marital, String housing, String room, String car, String graduation_date, String credit, String edu, String call, String qq, String treasure, String he_treasure, String province, String city, String address, String zhima_score, String town, String bao_liabilities, String jin_liabilities, String borrow) {
        HttpUtils.newInstance().loadGRXX2Bean(callback,id,name,card,email,record,marital,housing,room,car,graduation_date,credit,edu,call,qq,treasure,
                he_treasure,province,city,address,zhima_score,town,bao_liabilities,jin_liabilities,borrow);
    }
}
