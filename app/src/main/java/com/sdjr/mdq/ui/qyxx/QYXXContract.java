package com.sdjr.mdq.ui.qyxx;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.QYXXBean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/9.
 */

public class QYXXContract {
    public interface View extends IBaseView {
        void onResponse(QYXXBean qyxxBean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadQYXX(Callback<QYXXBean> callback, int id,String father_name,String father_phone
                ,String mother_name,String mother_phone,String brothers_name,String brothers_phone,String work_name,String work_phone
                ,String friend_name,String friend_phone);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
