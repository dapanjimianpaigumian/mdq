package com.sdjr.mdq.ui.sfrz;

import com.sdjr.mdq.bean.JDBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/19.
 */

public class JieDianMode implements JieDianContract.Mode{
    @Override
    public void loadJD(Callback<JDBean> callback, int id) {
        HttpUtils.newInstance().loadJDBean(callback,id);
    }
}
