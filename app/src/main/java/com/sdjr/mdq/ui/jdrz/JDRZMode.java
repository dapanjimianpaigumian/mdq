package com.sdjr.mdq.ui.jdrz;

import com.sdjr.mdq.bean.JDRZ2Bean;
import com.sdjr.mdq.bean.JDRZ3Bean;
import com.sdjr.mdq.bean.JDRZBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/12.
 */

public class JDRZMode implements JDRZContract.Mode{
    @Override
    public void loadJDRZBean(Callback<JDRZBean> callback, int id, String tel, String pw) {
        HttpUtils.newInstance().loadJDRZBean(callback,id,tel,pw);
    }

    @Override
    public void loadJDRZ2Bean(Callback<JDRZ2Bean> callback, int id, String params, String token) {
        HttpUtils.newInstance().loadJDRZ2Bean(callback,id,params,token);
    }

    @Override
    public void loadJDRZ3Bean(Callback<JDRZ3Bean> callback, int id, String code, String token) {
        HttpUtils.newInstance().loadJDRZ3Bean(callback,id,code,token);
    }
}
