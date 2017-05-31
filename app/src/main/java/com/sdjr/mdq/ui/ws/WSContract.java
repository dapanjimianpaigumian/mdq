package com.sdjr.mdq.ui.ws;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.WSBean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/10.
 */

public class WSContract {
    public interface View extends IBaseView {
        void onResponse(WSBean wsBean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadWS(Callback<WSBean> callback, int id);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
