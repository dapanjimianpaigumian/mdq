package com.sdjr.mdq.ui.sqjk;

import com.sdjr.mdq.bean.SYBNBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/22.
 */

public class SQJKBANMode implements SQJKBANContract.Mode{

    @Override
    public void loadSYBN(Callback<SYBNBean> callback) {
        HttpUtils.newInstance().loadSYBNBean(callback);
    }
}
