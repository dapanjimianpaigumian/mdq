package com.sdjr.mdq.ui.qyxx;

import com.sdjr.mdq.bean.QYXX2Bean;
import com.sdjr.mdq.http.HttpUtils;

import java.util.List;
import java.util.Map;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/17.
 */

public class LXRMode implements LRXContract.Mode{
    @Override
    public void loadQYXX(Callback<QYXX2Bean> callback, int id, String data) {
        HttpUtils.newInstance().loadQYXX2Bean(callback,id,data);
    }
}
