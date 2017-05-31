package com.sdjr.mdq.ui.grxx2;


import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.ZM2bean;
import com.sdjr.mdq.bean.ZMbean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/12.
 */

public class ZMSLContract {
    public interface View extends IBaseView {
        void onResponse(ZMbean zmbean);
        void onResponse2(ZM2bean zm2bean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadzmbean(Callback<ZMbean> callback, int id, String card, String name,String invokeurl);
        void  loadzm2bean(Callback<ZM2bean> callback, int id, String Identifier);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
        void getData2();
    }
}
