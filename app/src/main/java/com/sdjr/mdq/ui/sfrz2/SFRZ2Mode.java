package com.sdjr.mdq.ui.sfrz2;

import com.sdjr.mdq.bean.SFRZ2Bean;
import com.sdjr.mdq.http.HttpUtils;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Callback;

/**
 * Created by 昇盾 on 2017/5/10.
 */

public class SFRZ2Mode implements SFRZ2Contract.Mode{
    @Override
    public void loadSFRZ2(Callback<SFRZ2Bean> callback, int id,MultipartBody.Part front_img, MultipartBody.Part reverse_img, MultipartBody.Part portrait_img)
    {HttpUtils.newInstance().loadSFRZ2Bean(callback,id,front_img,reverse_img,portrait_img);
    }
}
