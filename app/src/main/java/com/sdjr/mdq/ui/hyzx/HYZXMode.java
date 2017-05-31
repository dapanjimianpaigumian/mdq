package com.sdjr.mdq.ui.hyzx;

import com.sdjr.mdq.bean.HYZXBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/19.
 */

public class HYZXMode implements HYZXContract.Mode{
    @Override
    public void loadHYZX(Callback<HYZXBean> callback, int id) {
        HttpUtils.newInstance().loadHYZXBean(callback,id);
    }
}
