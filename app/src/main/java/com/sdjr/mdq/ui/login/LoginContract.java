package com.sdjr.mdq.ui.login;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.DLBean;

import java.util.Map;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/4/27.
 */

public class LoginContract {
    public interface View extends IBaseView {
        void onResponse(DLBean dlBean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadDL(Callback<DLBean> callback, String weichat_id, String phone, String password);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
