package com.sdjr.mdq.ui.yhrz;

import com.sdjr.mdq.bean.YHRZ2Bean;
import com.sdjr.mdq.bean.YHRZBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/13.
 */

public class YHRZMode implements YHRZContract.Mode{
    @Override
    public void loadYHRZBean(Callback<YHRZBean> callback, int id, String tel, String pw, String idcode) {
        HttpUtils.newInstance().loadYHRZBean(callback,id,tel,pw,idcode);
    }

    @Override
    public void loadYHRZ2Bean(Callback<YHRZ2Bean> callback, int id, String params, String token) {
        HttpUtils.newInstance().loadYHRZ2Bean(callback,id,params,token);
    }
}
