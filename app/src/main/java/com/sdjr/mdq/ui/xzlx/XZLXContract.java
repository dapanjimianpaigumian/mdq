package com.sdjr.mdq.ui.xzlx;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.DLBean;
import com.sdjr.mdq.bean.SFXZBean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/9.
 */

public class XZLXContract {
    public interface View extends IBaseView {
        void onResponse(SFXZBean sfxzBean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadSFXZ(Callback<SFXZBean> callback, int id, int identity);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
