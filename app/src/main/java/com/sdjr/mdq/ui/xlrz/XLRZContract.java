package com.sdjr.mdq.ui.xlrz;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.XLRZ2Bean;
import com.sdjr.mdq.bean.XLRZBean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/12.
 */

public class XLRZContract {
    public interface View extends IBaseView {
        void onResponse(XLRZBean xlrzBean);
        void onResponse2(XLRZ2Bean xlrz2Bean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadXLRZBean(Callback<XLRZBean> callback, int id, String tel, String pw);
        void  loadXLRZ2Bean(Callback<XLRZ2Bean> callback, int id, String params, String token);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
        void getData2();
    }
}
