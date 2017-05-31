package com.sdjr.mdq.ui.rz;

import com.sdjr.mdq.bean.RZBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/11.
 */

public class RZMode implements RZContract.Mode{
    @Override
    public void loadRZ(Callback<RZBean> callback, int id) {
        HttpUtils.newInstance().loadRZBean(callback,id);
    }
}
