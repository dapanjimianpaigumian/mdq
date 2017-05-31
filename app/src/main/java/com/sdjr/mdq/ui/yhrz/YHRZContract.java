package com.sdjr.mdq.ui.yhrz;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.YHRZ2Bean;
import com.sdjr.mdq.bean.YHRZBean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/13.
 */

public class YHRZContract {
    public interface View extends IBaseView {
        void onResponse(YHRZBean yhrzBean);
        void onResponse2(YHRZ2Bean yhrz2bean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadYHRZBean(Callback<YHRZBean> callback, int id, String tel, String pw, String idcode);
        void  loadYHRZ2Bean(Callback<YHRZ2Bean> callback, int id, String params, String token);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
        void getData2();
    }
}
