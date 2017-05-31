package com.sdjr.mdq.ui.sfrz2;

import android.os.Handler;
import android.util.Log;

import com.sdjr.mdq.bean.SFRZ2Bean;
import com.sdjr.mdq.config.UrlConfig;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 昇盾 on 2017/5/10.
 */

public class SFRZ2Presreter implements SFRZ2Contract.Presreter{
    private SFRZ2Contract.View view;
    private SFRZ2Contract.Mode mode;
    private File w1,w2,w3;

    public SFRZ2Presreter (SFRZ2Contract.View view,File w1,File w2,File w3){
        this.view = view;
        this.mode = new SFRZ2Mode();
        this.w1 = w1;
        this.w2 = w2;
        this.w3 = w3;
    }

    @Override
    public void getData() {
        int id = UrlConfig.login;
        Log.i("asd", "getData: ==========w1========"+w1.length());
        Log.i("asd", "getData: ==========w2========"+w2.length());
        Log.i("asd", "getData: ==========w3========"+w3.length());

        RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), w1);
        MultipartBody.Part front_img =
                MultipartBody.Part.createFormData("front_img", w1.getName(), body);
        RequestBody body2 = RequestBody.create(MediaType.parse("multipart/form-data"), w2);
        MultipartBody.Part reverse_img =
                MultipartBody.Part.createFormData("reverse_img", w2.getName(), body2);
        RequestBody body3 = RequestBody.create(MediaType.parse("multipart/form-data"), w3);
        MultipartBody.Part portrait_img =
                MultipartBody.Part.createFormData("portrait_img", w3.getName(), body3);
        mode.loadSFRZ2(new Callback<SFRZ2Bean>() {
            @Override
            public void onResponse(Call<SFRZ2Bean> call, Response<SFRZ2Bean> response) {
                if (response.isSuccessful()){
                    final SFRZ2Bean body = response.body();
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.onResponse(body);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<SFRZ2Bean> call, Throwable t) {

            }
        },id,front_img,reverse_img,portrait_img);
    }
}
