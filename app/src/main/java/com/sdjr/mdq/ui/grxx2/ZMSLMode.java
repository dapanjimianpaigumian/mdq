package com.sdjr.mdq.ui.grxx2;


import com.sdjr.mdq.bean.ZM2bean;
import com.sdjr.mdq.bean.ZMbean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/12.
 */

public class ZMSLMode implements ZMSLContract.Mode{
    @Override
    public void loadzmbean(Callback<ZMbean> callback, int id, String card, String name,String invokeurl) {
        HttpUtils.newInstance().loadzmbean(callback,id,card,name,invokeurl);
    }

    @Override
    public void loadzm2bean(Callback<ZM2bean> callback, int id, String Identifier) {
        HttpUtils.newInstance().loadzm2bean(callback,id,Identifier);
    }

}
