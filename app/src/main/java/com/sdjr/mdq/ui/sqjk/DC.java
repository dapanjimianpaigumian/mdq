package com.sdjr.mdq.ui.sqjk;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.DTBD2Bean;
import com.sdjr.mdq.bean.DTBDBean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/24.
 */

public class DC {
    public interface View extends IBaseView {
        void onResponse(DTBD2Bean dtbd2Bean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadDTBD2(Callback<DTBD2Bean> callback, int id);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
