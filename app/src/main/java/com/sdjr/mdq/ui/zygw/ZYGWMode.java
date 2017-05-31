package com.sdjr.mdq.ui.zygw;

import com.sdjr.mdq.bean.ZYGW2Bean;
import com.sdjr.mdq.bean.ZYGWBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/11.
 */

public class ZYGWMode implements ZYGWContract.Mode{
    @Override
    public void loadZYGW(Callback<ZYGWBean> callback, String weichat_id) {
        HttpUtils.newInstance().loadZYGWBean(callback,weichat_id);
    }

    @Override
    public void loadZYGW2(Callback<ZYGW2Bean> callback, String name, String sex, String consult_time,String phone) {
        HttpUtils.newInstance().loadZYGW2Bean(callback,name,sex,consult_time,phone);
    }
}
