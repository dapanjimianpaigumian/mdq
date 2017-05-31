package com.sdjr.mdq.ui.xykrz;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.JDRZ2Bean;
import com.sdjr.mdq.bean.JDRZ3Bean;
import com.sdjr.mdq.bean.JDRZBean;
import com.sdjr.mdq.bean.XYKRZ2Bean;
import com.sdjr.mdq.bean.XYKRZ3Bean;
import com.sdjr.mdq.bean.XYKRZBean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/13.
 */

public class XYKRZContract {
    public interface View extends IBaseView {
        void onResponse(XYKRZBean xykrzBean);
        void onResponse2(XYKRZ2Bean xykrz2Bean);
        void onResponse3(XYKRZ3Bean xykrz3Bean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadXYKRZBean(Callback<XYKRZBean> callback, int id, String tel, String pw);
        void  loadXYKRZ2Bean(Callback<XYKRZ2Bean> callback, int id, String params, String token);
        void  loadXYKRZ3Bean(Callback<XYKRZ3Bean> callback, int id, String code, String token);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
        void getData2();
        void getData3();
    }
}
