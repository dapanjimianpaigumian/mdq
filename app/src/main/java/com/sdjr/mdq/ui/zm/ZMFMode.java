package com.sdjr.mdq.ui.zm;

import com.sdjr.mdq.bean.ZMF2Bean;
import com.sdjr.mdq.bean.ZMFBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/15.
 */

public class ZMFMode implements ZMFContract.Mode{
    @Override
    public void loadZMFBean(Callback<ZMFBean> callback, int id) {
        HttpUtils.newInstance().loadZMFBean(callback,id);
    }

    @Override
    public void loadZMF2Bean(Callback<ZMF2Bean> callback, int id) {
        HttpUtils.newInstance().loadZMF2Bean(callback,id);
    }
}
