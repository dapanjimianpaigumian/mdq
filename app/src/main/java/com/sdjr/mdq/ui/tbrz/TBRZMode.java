package com.sdjr.mdq.ui.tbrz;

import com.sdjr.mdq.bean.TBRZ2Bean;
import com.sdjr.mdq.bean.TBRZBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/13.
 */

public class TBRZMode implements TBRZContract.Mode{
    @Override
    public void loadTBRZBean(Callback<TBRZBean> callback, int id) {
        HttpUtils.newInstance().loadTBRZBean(callback,id);
    }

    @Override
    public void loadTBRZ2Bean(Callback<TBRZ2Bean> callback, int id, String params, String token) {
        HttpUtils.newInstance().loadTBRZ2Bean(callback,id,params,token);
    }
}
