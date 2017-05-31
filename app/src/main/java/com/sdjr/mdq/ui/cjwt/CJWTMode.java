package com.sdjr.mdq.ui.cjwt;

import com.sdjr.mdq.bean.CJWTBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by user on 2017/5/16.
 */

public class CJWTMode implements CJWTContract.Mode{

    @Override
    public void loadCJWT(Callback<CJWTBean> callback) {
        HttpUtils.newInstance().loadCJWTBean(callback);
    }
}
