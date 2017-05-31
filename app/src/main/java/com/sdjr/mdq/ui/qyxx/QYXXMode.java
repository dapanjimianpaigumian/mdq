package com.sdjr.mdq.ui.qyxx;

import com.sdjr.mdq.bean.QYXXBean;
import com.sdjr.mdq.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/9.
 */

public class QYXXMode implements QYXXContract.Mode{
    @Override
    public void loadQYXX(Callback<QYXXBean> callback, int id, String father_name, String father_phone, String mother_name, String mother_phone, String brothers_name, String brothers_phone, String work_name, String work_phone, String friend_name, String friend_phone) {
        HttpUtils.newInstance().loadQYXXBean(callback,id,father_name,father_phone,mother_name,mother_phone,brothers_name,brothers_phone
                ,work_name,work_phone,friend_name,friend_phone);
    }
}
