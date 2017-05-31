package com.sdjr.mdq.ui.grxx;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.GRXXBean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/9.
 */

public class GRXXContract {
    public interface View extends IBaseView {
        void onResponse(GRXXBean grxxBean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadGRXX(Callback<GRXXBean> callback, int id,String company_name,String company_email
                ,String company_size,String industry,String ci_industry,String job,String money,String company_phone);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
