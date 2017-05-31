package com.sdjr.mdq.ui.zm;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.ZMF2Bean;
import com.sdjr.mdq.bean.ZMFBean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/15.
 */

public class ZMFContract {
    public interface View extends IBaseView {
        void onResponse(ZMFBean zmfBean);
        void onResponse2(ZMF2Bean zmf2Bean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadZMFBean(Callback<ZMFBean> callback, int id);
        void  loadZMF2Bean(Callback<ZMF2Bean> callback, int id);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
        void getData2();
    }
}
