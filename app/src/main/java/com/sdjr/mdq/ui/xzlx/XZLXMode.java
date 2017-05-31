package com.sdjr.mdq.ui.xzlx;

import com.sdjr.mdq.bean.SFXZBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/9.
 */

public class XZLXMode implements XZLXContract.Mode{
    @Override
    public void loadSFXZ(Callback<SFXZBean> callback, int id, int identity) {
        HttpUtils.newInstance().loadSFXZBean(callback,id,identity);
    }
}
