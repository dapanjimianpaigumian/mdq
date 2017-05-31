package com.sdjr.mdq.ui.sfrz;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.JDBean;
import com.sdjr.mdq.bean.WSBean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/19.
 */

public class JieDianContract {
    public interface View extends IBaseView {
        void onResponse(JDBean jdBean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadJD(Callback<JDBean> callback, int id);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
