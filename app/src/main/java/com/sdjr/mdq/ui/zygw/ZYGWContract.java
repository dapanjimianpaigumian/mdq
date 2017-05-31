package com.sdjr.mdq.ui.zygw;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.ZYGW2Bean;
import com.sdjr.mdq.bean.ZYGWBean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/11.
 */

public class ZYGWContract {
    public interface View extends IBaseView {
        void onResponse(ZYGWBean zygwBean);
        void onResponse2(ZYGW2Bean zygw2Bean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadZYGW(Callback<ZYGWBean> callback, String weichat_id);
        void  loadZYGW2(Callback<ZYGW2Bean> callback, String name,String sex,String consult_time,String phone);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
        void getData2();
    }
}
