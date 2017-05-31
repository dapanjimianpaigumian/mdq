package com.sdjr.mdq.ui.sfrz2;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.SFRZ2Bean;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/10.
 */

public class SFRZ2Contract {
    public interface View extends IBaseView {
        void onResponse(SFRZ2Bean sfrz2Bean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadSFRZ2(Callback<SFRZ2Bean> callback, int id,MultipartBody.Part front_img, MultipartBody.Part reverse_img, MultipartBody.Part portrait_img
        );
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
