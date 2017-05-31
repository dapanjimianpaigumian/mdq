package com.sdjr.mdq.ui.login;

import com.sdjr.mdq.bean.DLBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/4/27.
 */

public class LoginMode implements LoginContract.Mode{

    @Override
    public void loadDL(Callback<DLBean> callback, String weichat_id, String phone, String password) {
        HttpUtils.newInstance().loadDLBean(callback,weichat_id,phone,password);
    }
}
