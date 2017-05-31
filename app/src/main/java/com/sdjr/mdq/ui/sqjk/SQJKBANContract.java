package com.sdjr.mdq.ui.sqjk;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.SYBNBean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/22.
 */

public class SQJKBANContract {
    public interface View extends IBaseView {
        void onResponse(SYBNBean sybnBean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadSYBN(Callback<SYBNBean> callback);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
