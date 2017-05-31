package com.sdjr.mdq.ui.grxx;

import com.sdjr.mdq.bean.GRXXBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/9.
 */

public class GRXXMode implements GRXXContract.Mode{
    @Override
    public void loadGRXX(Callback<GRXXBean> callback, int id, String company_name, String company_email, String company_size, String industry, String ci_industry, String job, String money, String company_phone) {
        HttpUtils.newInstance().loadGRXXBean(callback,id,company_name,company_email,company_size,industry,ci_industry,job,money,company_phone);
    }
}
