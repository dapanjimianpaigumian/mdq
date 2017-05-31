package com.sdjr.mdq.ui.xlrz;

import com.sdjr.mdq.bean.XLRZ2Bean;
import com.sdjr.mdq.bean.XLRZBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/12.
 */

public class XLRZMode implements XLRZContract.Mode{
    @Override
    public void loadXLRZBean(Callback<XLRZBean> callback, int id, String tel, String pw) {
        HttpUtils.newInstance().loadXLRZBean(callback,id,tel,pw);
    }

    @Override
    public void loadXLRZ2Bean(Callback<XLRZ2Bean> callback, int id, String params, String token) {
        HttpUtils.newInstance().loadXLRZ2Bean(callback,id,params,token);
    }
}
