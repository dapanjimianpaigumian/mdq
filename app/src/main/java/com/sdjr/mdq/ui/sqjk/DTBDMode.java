package com.sdjr.mdq.ui.sqjk;

import com.sdjr.mdq.bean.DTBDBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/3.
 */

public class DTBDMode implements DTBDContract.Mode{
    @Override
    public void loadDTBD(Callback<DTBDBean> callback, int id) {
        HttpUtils.newInstance().loadDTBDBean(callback,id);
    }
}
