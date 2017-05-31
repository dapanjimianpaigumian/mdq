package com.sdjr.mdq.http;


import com.google.gson.Gson;
import com.sdjr.mdq.bean.CJWTBean;
import com.sdjr.mdq.bean.DLBean;
import com.sdjr.mdq.bean.DTBD2Bean;
import com.sdjr.mdq.bean.DTBDBean;
import com.sdjr.mdq.bean.GRXX2Bean;
import com.sdjr.mdq.bean.GRXXBean;
import com.sdjr.mdq.bean.HYZXBean;
import com.sdjr.mdq.bean.JDBean;
import com.sdjr.mdq.bean.JDRZ2Bean;
import com.sdjr.mdq.bean.JDRZ3Bean;
import com.sdjr.mdq.bean.JDRZBean;
import com.sdjr.mdq.bean.QYXX2Bean;
import com.sdjr.mdq.bean.QYXXBean;
import com.sdjr.mdq.bean.RZBean;
import com.sdjr.mdq.bean.SFRZ2Bean;
import com.sdjr.mdq.bean.SFXZBean;
import com.sdjr.mdq.bean.SYBNBean;
import com.sdjr.mdq.bean.TBRZ2Bean;
import com.sdjr.mdq.bean.TBRZBean;
import com.sdjr.mdq.bean.WSBean;
import com.sdjr.mdq.bean.XLRZ2Bean;
import com.sdjr.mdq.bean.XLRZBean;
import com.sdjr.mdq.bean.XYKRZ2Bean;
import com.sdjr.mdq.bean.XYKRZ3Bean;
import com.sdjr.mdq.bean.XYKRZBean;
import com.sdjr.mdq.bean.YHRZ2Bean;
import com.sdjr.mdq.bean.YHRZBean;
import com.sdjr.mdq.bean.YYS2Bean;
import com.sdjr.mdq.bean.YYS3Bean;
import com.sdjr.mdq.bean.YYSBean;
import com.sdjr.mdq.bean.YZMBean;
import com.sdjr.mdq.bean.ZCBean;
import com.sdjr.mdq.bean.ZM2bean;
import com.sdjr.mdq.bean.ZMF2Bean;
import com.sdjr.mdq.bean.ZMFBean;
import com.sdjr.mdq.bean.ZMbean;
import com.sdjr.mdq.bean.ZYGW2Bean;
import com.sdjr.mdq.bean.ZYGWBean;
import com.sdjr.mdq.config.UrlConfig;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.Part;

/**
 * Created by Administrator on 2016/9/6.
 */
public class HttpUtils {
    private HttpUtils(){};
    private static HttpUtils utile= new HttpUtils();
    public static HttpUtils newInstance(){
        return utile;
    }

    public void loadDLBean(Callback<DLBean> callback, String weichat_id, String phone, String password){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<DLBean> leftBeanCall = retrofitInter.loadDLBean(weichat_id,phone,password);
        leftBeanCall.enqueue(callback);
    }

    public void loadYZMBean(Callback<YZMBean> callback, String weichat_id, String phone){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<YZMBean> leftBeanCall = retrofitInter.loadYZMBean(weichat_id,phone);
        leftBeanCall.enqueue(callback);
    }

    public void loadZCBean(Callback<ZCBean> callback, String weichat_id, String phone, String password,String page){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<ZCBean> leftBeanCall = retrofitInter.loadZCBean(weichat_id,phone,password,page);
        leftBeanCall.enqueue(callback);
    }

    public void loadDTBDBean(Callback<DTBDBean> callback, int id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<DTBDBean> leftBeanCall = retrofitInter.loadDTBDBean(id);
        leftBeanCall.enqueue(callback);
    }

    public void loadDTBD2Bean(Callback<DTBD2Bean> callback, int id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<DTBD2Bean> leftBeanCall = retrofitInter.loadDTBD2Bean(id);
        leftBeanCall.enqueue(callback);
    }

    public void loadSFXZBean(Callback<SFXZBean> callback, int id,int identity){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<SFXZBean> leftBeanCall = retrofitInter.loadSFXZBean(id,identity);
        leftBeanCall.enqueue(callback);
    }

    public void loadWSBean(Callback<WSBean> callback, int id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<WSBean> leftBeanCall = retrofitInter.loadWSBean(id);
        leftBeanCall.enqueue(callback);
    }

    public void loadGRXX2Bean(Callback<GRXX2Bean> callback, int id, String name, String card, String email,
                              String record, String marital, String housing, String room, String car, String graduation_date, String credit, String edu
            , String call, String qq, String treasure, String he_treasure, String province, String city, String address, String zhima_score
            , String town, String bao_liabilities, String jin_liabilities, String borrow ){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<GRXX2Bean> leftBeanCall = retrofitInter.loadGRXX2Bean(id,name,card,email,record,marital,housing,room,car,graduation_date,credit,edu,call,qq,treasure,
                he_treasure,province,city,address,zhima_score,town,bao_liabilities,jin_liabilities,borrow);
        leftBeanCall.enqueue(callback);
    }

    public void loadQYXXBean(Callback<QYXXBean> callback, int id,String father_name,String father_phone
            ,String mother_name,String mother_phone,String brothers_name,String brothers_phone,String work_name,String work_phone
            ,String friend_name,String friend_phone){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<QYXXBean> leftBeanCall = retrofitInter.loadQYXXBean(id,father_name,father_phone,mother_name,mother_phone,brothers_name,brothers_phone
        ,work_name,work_phone,friend_name,friend_phone);
        leftBeanCall.enqueue(callback);
    }

    public void loadQYXX2Bean(Callback<QYXX2Bean> callback, int id,String data){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<QYXX2Bean> leftBeanCall = retrofitInter.loadQYXX2Bean(id,data);
        leftBeanCall.enqueue(callback);
    }

    public void loadGRXXBean(Callback<GRXXBean> callback, int id,String company_name,String company_email
            ,String company_size,String industry,String ci_industry,String job,String money,String company_phone){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<GRXXBean> leftBeanCall = retrofitInter.loadGRXXBean(id,company_name,company_email,company_size,industry,ci_industry,job,money,company_phone);
        leftBeanCall.enqueue(callback);
    }

    public void loadSFRZ2Bean(Callback<SFRZ2Bean> callback, int id, MultipartBody.Part front_img, MultipartBody.Part reverse_img, MultipartBody.Part portrait_img
    ){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<SFRZ2Bean> leftBeanCall = retrofitInter.loadSFRZ2Bean(id,front_img,reverse_img,portrait_img);
//        ,reverse_img,portrait_img
        leftBeanCall.enqueue(callback);
    }

    public void loadRZBean(Callback<RZBean> callback, int id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<RZBean> leftBeanCall = retrofitInter.loadRZBean(id);
        leftBeanCall.enqueue(callback);
    }

    public void loadYYSBean(Callback<YYSBean> callback, int id, String tel, String pw,String otherInfo){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<YYSBean> leftBeanCall = retrofitInter.loadYYSBean(id,tel,pw,otherInfo);
        leftBeanCall.enqueue(callback);
    }

    public void loadYYS2Bean(Callback<YYS2Bean> callback, int id, String params, String token){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<YYS2Bean> leftBeanCall = retrofitInter.loadYYS2Bean(id,params,token);
        leftBeanCall.enqueue(callback);
    }

    public void loadYYS3Bean(Callback<YYS3Bean> callback, int id, String code, String token){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<YYS3Bean> leftBeanCall = retrofitInter.loadYYS3Bean(id,code,token);
        leftBeanCall.enqueue(callback);
    }

    public void loadXLRZBean(Callback<XLRZBean> callback, int id, String tel, String pw){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<XLRZBean> leftBeanCall = retrofitInter.loadXLRZBean(id,tel,pw);
        leftBeanCall.enqueue(callback);
    }

    public void loadXLRZ2Bean(Callback<XLRZ2Bean> callback, int id, String params, String token){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<XLRZ2Bean> leftBeanCall = retrofitInter.loadXLRZ2Bean(id,params,token);
        leftBeanCall.enqueue(callback);
    }

    public void loadJDRZBean(Callback<JDRZBean> callback, int id, String tel, String pw){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<JDRZBean> leftBeanCall = retrofitInter.loadJDRZBean(id,tel,pw);
        leftBeanCall.enqueue(callback);
    }

    public void loadJDRZ2Bean(Callback<JDRZ2Bean> callback, int id, String params, String token){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<JDRZ2Bean> leftBeanCall = retrofitInter.loadJDRZ2Bean(id,params,token);
        leftBeanCall.enqueue(callback);
    }

    public void loadJDRZ3Bean(Callback<JDRZ3Bean> callback, int id, String code, String token){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<JDRZ3Bean> leftBeanCall = retrofitInter.loadJDRZ3Bean(id,code,token);
        leftBeanCall.enqueue(callback);
    }

    public void loadYHRZBean(Callback<YHRZBean> callback, int id, String tel, String pw, String idcode){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<YHRZBean> leftBeanCall = retrofitInter.loadYHRZBean(id,tel,pw,idcode);
        leftBeanCall.enqueue(callback);
    }

    public void loadYHRZ2Bean(Callback<YHRZ2Bean> callback, int id, String params, String token){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<YHRZ2Bean> leftBeanCall = retrofitInter.loadYHRZ2Bean(id,params,token);
        leftBeanCall.enqueue(callback);
    }

    public void loadXYKRZBean(Callback<XYKRZBean> callback, int id, String tel, String pw){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<XYKRZBean> leftBeanCall = retrofitInter.loadXYKRZBean(id,tel,pw);
        leftBeanCall.enqueue(callback);
    }

    public void loadXYKRZ2Bean(Callback<XYKRZ2Bean> callback, int id, String params, String token){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<XYKRZ2Bean> leftBeanCall = retrofitInter.loadXYKRZ2Bean(id,params,token);
        leftBeanCall.enqueue(callback);
    }

    public void loadXYKRZ3Bean(Callback<XYKRZ3Bean> callback, int id, String code, String token){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<XYKRZ3Bean> leftBeanCall = retrofitInter.loadXYKRZ3Bean(id,code,token);
        leftBeanCall.enqueue(callback);
    }

    public void loadTBRZBean(Callback<TBRZBean> callback, int id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<TBRZBean> leftBeanCall = retrofitInter.loadTBRZBean(id);
        leftBeanCall.enqueue(callback);
    }

    public void loadTBRZ2Bean(Callback<TBRZ2Bean> callback, int id, String params, String token){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<TBRZ2Bean> leftBeanCall = retrofitInter.loadTBRZ2Bean(id,params,token);
        leftBeanCall.enqueue(callback);
    }

    public void loadZMFBean(Callback<ZMFBean> callback, int id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<ZMFBean> leftBeanCall = retrofitInter.loadZMFBean(id);
        leftBeanCall.enqueue(callback);
    }

    public void loadZMF2Bean(Callback<ZMF2Bean> callback, int id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<ZMF2Bean> leftBeanCall = retrofitInter.loadZMF2Bean(id);
        leftBeanCall.enqueue(callback);
    }

    public void loadzmbean(Callback<ZMbean> callback, int id, String card, String name,String invokeurl){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<ZMbean> leftBeanCall = retrofitInter.loadzmbean(id,card,name,invokeurl);
        leftBeanCall.enqueue(callback);
    }

    public void loadzm2bean(Callback<ZM2bean> callback, int id, String Identifier){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<ZM2bean> leftBeanCall = retrofitInter.loadzm2bean(id,Identifier);
        leftBeanCall.enqueue(callback);
    }

    public void loadCJWTBean(Callback<CJWTBean> callback){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<CJWTBean> leftBeanCall = retrofitInter.loadCJWTBean();
        leftBeanCall.enqueue(callback);
    }
    public void loadSYBNBean(Callback<SYBNBean> callback){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<SYBNBean> leftBeanCall = retrofitInter.loadSYBNBean();
        leftBeanCall.enqueue(callback);
    }
    public void loadJDBean(Callback<JDBean> callback, int id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<JDBean> leftBeanCall = retrofitInter.loadJDBean(id);
        leftBeanCall.enqueue(callback);
    }

    public void loadHYZXBean(Callback<HYZXBean> callback, int id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<HYZXBean> leftBeanCall = retrofitInter.loadHYZXBean(id);
        leftBeanCall.enqueue(callback);
    }

    public void loadZYGWBean(Callback<ZYGWBean> callback, String weichat_id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<ZYGWBean> leftBeanCall = retrofitInter.loadZYGWBean(weichat_id);
        leftBeanCall.enqueue(callback);
    }

    public void loadZYGW2Bean(Callback<ZYGW2Bean> callback, String name,String sex,String consult_time,String phone){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<ZYGW2Bean> leftBeanCall = retrofitInter.loadZYGW2Bean(name,sex,consult_time,phone);
        leftBeanCall.enqueue(callback);
    }
}
