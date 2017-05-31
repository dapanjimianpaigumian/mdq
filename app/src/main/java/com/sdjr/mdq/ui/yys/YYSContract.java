package com.sdjr.mdq.ui.yys;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.YYS2Bean;
import com.sdjr.mdq.bean.YYS3Bean;
import com.sdjr.mdq.bean.YYSBean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/12.
 */

public class YYSContract {
    public interface View extends IBaseView {
        void onResponse(YYSBean yysBean);
        void onResponse2(YYS2Bean yys2Bean);
        void onResponse3(YYS3Bean yys3Bean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadYYSBean(Callback<YYSBean> callback, int id, String tel, String pw,String otherInfo);
        void  loadYYS2Bean(Callback<YYS2Bean> callback, int id, String params, String token);
        void  loadYYS3Bean(Callback<YYS3Bean> callback, int id, String code, String token);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
        void getData2();
        void getData3();
    }
}
