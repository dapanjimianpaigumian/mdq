package com.sdjr.mdq.ui.zc;


import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.DLBean;
import com.sdjr.mdq.bean.ZCBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/3/28 0028.
 */

public class ZCContract {
    public interface View extends IBaseView {
        void onResponse(ZCBean zcBean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadZC(Callback<ZCBean> callback, String weichat_id, String phone, String password,String page);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
