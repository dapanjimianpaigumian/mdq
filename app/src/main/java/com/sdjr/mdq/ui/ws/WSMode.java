package com.sdjr.mdq.ui.ws;

import com.sdjr.mdq.bean.WSBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/10.
 */

public class WSMode implements WSContract.Mode{
    @Override
    public void loadWS(Callback<WSBean> callback, int id) {
        HttpUtils.newInstance().loadWSBean(callback,id);
    }
}
