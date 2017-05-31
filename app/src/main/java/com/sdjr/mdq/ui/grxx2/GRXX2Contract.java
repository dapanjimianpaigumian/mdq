package com.sdjr.mdq.ui.grxx2;

import com.sdjr.mdq.base.IBaseMode;
import com.sdjr.mdq.base.IBasePresenter;
import com.sdjr.mdq.base.IBaseView;
import com.sdjr.mdq.bean.GRXX2Bean;

import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/9.
 */

public class GRXX2Contract {
    public interface View extends IBaseView {
        void onResponse(GRXX2Bean grxx2Bean);
        void onFailure(String s);
    }

    public interface Mode extends IBaseMode {
        void  loadGRXX2(Callback<GRXX2Bean> callback, int id, String name, String card, String email,
                       String record, String marital, String housing, String room, String car, String graduation_date, String credit, String edu
                , String call, String qq, String treasure, String he_treasure, String province, String city, String address, String zhima_score
                , String town, String bao_liabilities, String jin_liabilities, String borrow );
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
