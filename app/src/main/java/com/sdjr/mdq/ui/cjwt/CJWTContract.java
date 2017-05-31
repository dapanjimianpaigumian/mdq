package com.sdjr.mdq.ui.cjwt;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.CJWTBean;
import com.sdjr.mdq.bean.JDRZBean;

import retrofit2.Callback;

/**
 * Created by user on 2017/5/16.
 */

public class CJWTContract {
    public interface View extends IBaseView {
        void onResponse(CJWTBean cjwtBean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadCJWT(Callback<CJWTBean> callback);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
