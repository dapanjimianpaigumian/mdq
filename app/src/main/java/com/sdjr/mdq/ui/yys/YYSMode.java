package com.sdjr.mdq.ui.yys;

import com.sdjr.mdq.bean.YYS2Bean;
import com.sdjr.mdq.bean.YYS3Bean;
import com.sdjr.mdq.bean.YYSBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/12.
 */

public class YYSMode implements YYSContract.Mode{
    @Override
    public void loadYYSBean(Callback<YYSBean> callback, int id, String tel, String pw,String otherInfo) {
        HttpUtils.newInstance().loadYYSBean(callback,id,tel,pw,otherInfo);
    }

    @Override
    public void loadYYS2Bean(Callback<YYS2Bean> callback, int id, String params, String token) {
        HttpUtils.newInstance().loadYYS2Bean(callback,id,params,token);
    }

    @Override
    public void loadYYS3Bean(Callback<YYS3Bean> callback, int id, String code, String token) {
        HttpUtils.newInstance().loadYYS3Bean(callback,id,code,token);
    }
}
