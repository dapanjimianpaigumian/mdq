package com.sdjr.mdq.ui.xykrz;

import com.sdjr.mdq.bean.XYKRZ2Bean;
import com.sdjr.mdq.bean.XYKRZ3Bean;
import com.sdjr.mdq.bean.XYKRZBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/13.
 */

public class XYKRZMode implements XYKRZContract.Mode{
    @Override
    public void loadXYKRZBean(Callback<XYKRZBean> callback, int id, String tel, String pw) {
        HttpUtils.newInstance().loadXYKRZBean(callback,id,tel,pw);
    }

    @Override
    public void loadXYKRZ2Bean(Callback<XYKRZ2Bean> callback, int id, String params, String token) {
        HttpUtils.newInstance().loadXYKRZ2Bean(callback,id,params,token);
    }

    @Override
    public void loadXYKRZ3Bean(Callback<XYKRZ3Bean> callback, int id, String code, String token) {
        HttpUtils.newInstance().loadXYKRZ3Bean(callback,id,code,token);
    }
}
