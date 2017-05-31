package com.sdjr.mdq.ui.jdrz;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.JDRZ2Bean;
import com.sdjr.mdq.bean.JDRZ3Bean;
import com.sdjr.mdq.bean.JDRZBean;
import com.sdjr.mdq.bean.YYS2Bean;
import com.sdjr.mdq.bean.YYS3Bean;
import com.sdjr.mdq.bean.YYSBean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/12.
 */

public class JDRZContract {
    public interface View extends IBaseView {
        void onResponse(JDRZBean jdrzBean);
        void onResponse2(JDRZ2Bean jdrz2Bean);
        void onResponse3(JDRZ3Bean jdrz3Bean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadJDRZBean(Callback<JDRZBean> callback, int id, String tel, String pw);
        void  loadJDRZ2Bean(Callback<JDRZ2Bean> callback, int id, String params, String token);
        void  loadJDRZ3Bean(Callback<JDRZ3Bean> callback, int id, String code, String token);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
        void getData2();
        void getData3();
    }
}
