package com.sdjr.mdq.ui.hyzx;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.HYZXBean;
import com.sdjr.mdq.bean.RZBean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/19.
 */

public class HYZXContract {
    public interface View extends IBaseView {
        void onResponse(HYZXBean hyzxBean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadHYZX(Callback<HYZXBean> callback, int id);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
