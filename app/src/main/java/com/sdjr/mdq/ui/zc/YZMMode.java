package com.sdjr.mdq.ui.zc;

import com.sdjr.mdq.bean.YZMBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/3.
 */

public class YZMMode implements YZMContract.Mode{
    @Override
    public void loadYZM(Callback<YZMBean> callback, String weichat_id, String phone) {
        HttpUtils.newInstance().loadYZMBean(callback,weichat_id,phone);
    }
}
