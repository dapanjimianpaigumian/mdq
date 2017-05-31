package com.sdjr.mdq.ui.sqjk;

import com.sdjr.mdq.bean.DTBD2Bean;
import com.sdjr.mdq.bean.DTBDBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/24.
 */

public class DM implements DC.Mode{
    @Override
    public void loadDTBD2(Callback<DTBD2Bean> callback, int id) {
        HttpUtils.newInstance().loadDTBD2Bean(callback,id);
    }
}
