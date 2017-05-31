package com.sdjr.mdq.ui.rz;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.RZBean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/11.
 */

public class RZContract {
    public interface View extends IBaseView {
        void onResponse(RZBean rzBean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadRZ(Callback<RZBean> callback, int id);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
