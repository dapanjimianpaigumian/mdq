package com.sdjr.mdq.ui.zc;

import com.sdjr.mdq.bean.ZCBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/3/28 0028.
 */

public class ZCMode implements ZCContract.Mode{

    @Override
    public void loadZC(Callback<ZCBean> callback, String weichat_id, String phone, String password,String page) {
        HttpUtils.newInstance().loadZCBean(callback,weichat_id,phone,password,page);
    }
}
