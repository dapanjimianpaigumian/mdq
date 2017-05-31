package com.sdjr.mdq.ui.tbrz;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.TBRZ2Bean;
import com.sdjr.mdq.bean.TBRZBean;
import com.sdjr.mdq.bean.XYKRZ2Bean;
import com.sdjr.mdq.bean.XYKRZ3Bean;
import com.sdjr.mdq.bean.XYKRZBean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/13.
 */

public class TBRZContract {
    public interface View extends IBaseView {
        void onResponse(TBRZBean tbrzBean);
        void onResponse2(TBRZ2Bean tbrz2Bean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadTBRZBean(Callback<TBRZBean> callback, int id);
        void  loadTBRZ2Bean(Callback<TBRZ2Bean> callback, int id, String params, String token);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
        void getData2();
    }
}
