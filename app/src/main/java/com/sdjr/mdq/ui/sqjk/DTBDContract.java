package com.sdjr.mdq.ui.sqjk;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.DTBDBean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/3.
 */

public class DTBDContract {
    public interface View extends IBaseView {
        void onResponse(DTBDBean dtbdBean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadDTBD(Callback<DTBDBean> callback, int id);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
