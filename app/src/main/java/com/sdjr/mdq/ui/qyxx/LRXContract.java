package com.sdjr.mdq.ui.qyxx;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.QYXX2Bean;

import java.util.List;
import java.util.Map;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/17.
 */

public class LRXContract {
    public interface View extends IBaseView {
        void onResponse(QYXX2Bean qyxx2Bean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadQYXX(Callback<QYXX2Bean> callback, int id, String data);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
