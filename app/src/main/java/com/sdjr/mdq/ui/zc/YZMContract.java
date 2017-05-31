package com.sdjr.mdq.ui.zc;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.YZMBean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/3.
 */

public class YZMContract {
    public interface View extends IBaseView {
        void onResponse(YZMBean yzmBean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadYZM(Callback<YZMBean> callback, String weichat_id, String phone);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}

