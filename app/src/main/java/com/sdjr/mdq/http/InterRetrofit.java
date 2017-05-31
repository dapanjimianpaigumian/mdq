package com.sdjr.mdq.http;


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
import com.sdjr.mdq.bean.XXWSBean;
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


import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Administrator on 2016/9/6.
 */
public interface InterRetrofit {

    @FormUrlEncoded
    @POST("index.php?g=API&m=Select&a=login")
    Call<DLBean> loadDLBean( @Field("weichat_id") String weichat_id, @Field("phone") String phone, @Field("password") String password);

    @FormUrlEncoded
    @POST("index.php?g=API&m=Select&a=send_sms")
    Call<YZMBean> loadYZMBean(@Field("weichat_id") String weichat_id, @Field("phone") String phone);

    @FormUrlEncoded
    @POST("index.php?g=API&m=Insert&a=set_password")
    Call<ZCBean> loadZCBean(@Field("weichat_id") String weichat_id, @Field("phone") String phone, @Field("password") String password, @Field("page") String page);

    @FormUrlEncoded
    @POST("index.php?g=API&m=select&a=member_step")
    Call<DTBDBean> loadDTBDBean(@Field("id") int id);

    @FormUrlEncoded
    @POST("index.php?g=API&m=select&a=member_step")
    Call<DTBD2Bean> loadDTBD2Bean(@Field("id") int id);

    @FormUrlEncoded
    @POST("index.php?g=API&m=select&a=member_info")
    Call<XXWSBean> loadXXWSBean(@Field("id") int id);
    //身份选择
    @FormUrlEncoded
    @POST("index.php?g=API&m=Update&a=identity")
    Call<SFXZBean> loadSFXZBean(@Field("id") int id, @Field("identity") int identity);

    //未完善已完善
    @FormUrlEncoded
    @POST("index.php?g=API&m=select&a=member_info")
    Call<WSBean> loadWSBean(@Field("id") int id);
//    5.个人信息
//    http://bao.financesd.cn/admin/
//    个人信息添加入参
//    `id`  '会员ID', `name`  '姓名',`card`  '身份证号',`email`  '邮箱',
//            `record`'学历',`marital`  '婚姻 0位1已',`housing`  '0租1买',
//            `graduation_date`  '毕业年份', `edu`  '额度',`credit`  '信用卡', `room`  '房贷情况', `car`  '车产',`call`  '电话',`qq` 'QQ',`treasure`  '本人借贷宝', `he_treasure`  '担保人借贷宝',`province`  '省', `city` '市', `address`  '详细地址', `town`  '区', `zhima_score` i '芝麻信用分', `bao_liabilities` '借贷宝负债',
//            `jin_liabilities` 今借到负债 `borrow`  '借款金额',
//    {
//        msg = “保存成功”;
//        stat = 1;
//    }
    @FormUrlEncoded
    @POST("index.php?g=API&m=Insert&a=basic")
    Call<GRXX2Bean> loadGRXX2Bean(@Field("id") int id,@Field("name") String name,@Field("card") String card,@Field("email") String email,
                                  @Field("record") String record,@Field("marital") String marital,@Field("housing") String housing,@Field("room") String room
            ,@Field("car") String car,@Field("graduation_date") String graduation_date,@Field("credit") String credit,@Field("edu") String edu
            ,@Field("call") String call,@Field("qq") String qq,@Field("treasure") String treasure,@Field("he_treasure") String he_treasure
            ,@Field("province") String province,@Field("city") String city,@Field("address") String address,@Field("zhima_score") String zhima_score
            ,@Field("town") String town
            ,@Field("bao_liabilities") String bao_liabilities,@Field("jin_liabilities") String jin_liabilities,@Field("borrow") String borrow);

//    6.亲友信息
//    http://bao.financesd.cn/admin/
//    联系人信息字典入参字段
//    `id` ,`father_name`  '父',`father_phone` ,
//            `mother_name`  '母',`mother_phone` , `brothers_name` '兄', `brothers_phone` , `work_name`  '同事',`work_phone` ,`friend_name`  '朋友',`friend_phone`
    @FormUrlEncoded
    @POST("index.php?g=API&m=Insert&a=linkman")
    Call<QYXXBean> loadQYXXBean(@Field("id") int id,@Field("father_name") String father_name,@Field("father_phone") String father_phone
            ,@Field("mother_name") String mother_name,@Field("mother_phone") String mother_phone,@Field("brothers_name") String brothers_name
            ,@Field("brothers_phone") String brothers_phone,@Field("work_name") String work_name,@Field("work_phone") String work_phone
            ,@Field("friend_name") String friend_name,@Field("friend_phone") String friend_phone);

    @FormUrlEncoded
    @POST("index.php?g=Api&m=Insert&a=phone")
    Call<QYXX2Bean> loadQYXX2Bean(@Field("id") int id, @Field("data")String data);

// 7. 工作信息
//    http://bao.financesd.cn/admin/
//    职业信息字典入参
//    `id`  '会员id',`company_name`  '公司名称', `company_email`  '公司邮箱',
//            `company_size`  '公司大小', `industry`  '主行业'`ci_industry`  '次行业',`job` '职务',`money`  '月收入', `company_phone`  '公司电话',
    @FormUrlEncoded
    @POST("index.php?g=API&m=Insert&a=vocation")
    Call<GRXXBean> loadGRXXBean(@Field("id") int id,@Field("company_name") String company_name,@Field("company_email") String company_email
            ,@Field("company_size") String company_size,@Field("industry") String industry,@Field("ci_industry") String ci_industry
            ,@Field("job") String job,@Field("money") String money,@Field("company_phone") String company_phone);

// 8.图片上传
//    http://bao.financesd.cn/admin/
//    params id ： USERID //把for循环放到外层，三次分别上传，
//    name ：name
//    fileName @"front_img",@"reverse_img",@"portrait_img"



    @Multipart
    @POST("index.php?g=api&m=insert&a=set_img")
    Call<SFRZ2Bean> loadSFRZ2Bean(@Part("id") int id,
                                  @Part MultipartBody.Part front_img,
                                  @Part MultipartBody.Part reverse_img,
                                  @Part MultipartBody.Part portrait_img
    );
    //认证状态
    @FormUrlEncoded
    @POST("index.php?g=Api&m=Select&a=Certification_page")
    Call<RZBean> loadRZBean(@Field("id") int id);

    @FormUrlEncoded
    @POST("index.php?g=API&m=Insert&a=yun")
    Call<YYSBean> loadYYSBean(@Field("id") int id, @Field("tel") String tel, @Field("pw") String pw,@Field("otherInfo") String otherInfo);

    @FormUrlEncoded
    @POST("index.php?g=API&m=Insert&a=yun_qingqiu")
    Call<YYS2Bean> loadYYS2Bean(@Field("id") int id, @Field("params") String params, @Field("token") String token);

    @FormUrlEncoded
    @POST("index.php?g=API&m=Insert&a=yun_veray")
    Call<YYS3Bean> loadYYS3Bean(@Field("id") int id, @Field("code") String code, @Field("token") String token);

    @FormUrlEncoded
    @POST("index.php?g=API&m=Insert&a=xueli")
    Call<XLRZBean> loadXLRZBean(@Field("id") int id, @Field("tel") String tel, @Field("pw") String pw);

    @FormUrlEncoded
    @POST("index.php?g=API&m=Insert&a=xuexing_qingqiu")
    Call<XLRZ2Bean> loadXLRZ2Bean(@Field("id") int id, @Field("params") String params, @Field("token") String token);

    @FormUrlEncoded
    @POST("index.php?g=API&m=Insert&a=jingdong")
    Call<JDRZBean> loadJDRZBean(@Field("id") int id, @Field("tel") String tel, @Field("pw") String pw);

    @FormUrlEncoded
    @POST("index.php?g=API&m=Insert&a=jingdong_qingqiu")
    Call<JDRZ2Bean> loadJDRZ2Bean(@Field("id") int id, @Field("params") String params, @Field("token") String token);

    @FormUrlEncoded
    @POST("index.php?g=API&m=Insert&a=jingdong_veray")
    Call<JDRZ3Bean> loadJDRZ3Bean(@Field("id") int id, @Field("code") String code, @Field("token") String token);

    @FormUrlEncoded
    @POST("index.php?g=api&m=insert&a=yanghang")
    Call<YHRZBean> loadYHRZBean(@Field("id") int id, @Field("tel") String tel, @Field("pw") String pw, @Field("idcode") String idcode);

    @FormUrlEncoded
    @POST("index.php?g=api&m=insert&a=yanghang_qingqiu")
    Call<YHRZ2Bean> loadYHRZ2Bean(@Field("id") int id, @Field("params") String params, @Field("token") String token);

    @FormUrlEncoded
    @POST("index.php?g=API&m=Insert&a=xinyongka")
    Call<XYKRZBean> loadXYKRZBean(@Field("id") int id, @Field("tel") String tel, @Field("pw") String pw);

    @FormUrlEncoded
    @POST("index.php?g=API&m=Insert&a=xingyongka_qingqiu")
    Call<XYKRZ2Bean> loadXYKRZ2Bean(@Field("id") int id, @Field("params") String params, @Field("token") String token);

    @FormUrlEncoded
    @POST("index.php?g=API&m=Insert&a=xingyongka_veray")
    Call<XYKRZ3Bean> loadXYKRZ3Bean(@Field("id") int id, @Field("code") String code, @Field("token") String token);

    @FormUrlEncoded
    @POST("index.php?g=api&m=insert&a=taobao")
    Call<TBRZBean> loadTBRZBean(@Field("id") int id);

    @FormUrlEncoded
    @POST("index.php?g=api&m=insert&a=taobao_qingqiu")
    Call<TBRZ2Bean> loadTBRZ2Bean(@Field("id") int id, @Field("params") String params, @Field("token") String token);

    @FormUrlEncoded
    @POST("index.php?g=API&m=Zhima&a=zhima")
    Call<ZMFBean> loadZMFBean(@Field("id") int id);

    @FormUrlEncoded
    @POST("index.php?g=API&m=Zhima&a=zhimafen")
    Call<ZMF2Bean> loadZMF2Bean(@Field("id") int id);

    @FormUrlEncoded
    @POST("index.php?g=API&m=Zhima&a=zhima1")
    Call<ZMbean> loadzmbean(@Field("id") int id, @Field("card")String card, @Field("name") String name,@Field("invokeurl") String invokeurl);

    @FormUrlEncoded
    @POST("index.php?g=API&m=Zhima&a=zhimajm")
    Call<ZM2bean> loadzm2bean(@Field("id") int id, @Field("Identifier") String Identifier);

    @POST("index.php?g=API&m=Select&a=Common_problems")
    Call<CJWTBean> loadCJWTBean();

    @POST("index.php?g=API&m=Select&a=get_banner")
    Call<SYBNBean> loadSYBNBean();

    @FormUrlEncoded
    @POST("index.php?g=API&m=Insert&a=perfection")
    Call<JDBean> loadJDBean(@Field("id") int id);

    @FormUrlEncoded
    @POST("index.php?g=API&m=Insert&a=member_center")
    Call<HYZXBean> loadHYZXBean(@Field("id") int id);

    @FormUrlEncoded
    @POST("index.php?g=API&m=Select&a=Today_number")
    Call<ZYGWBean> loadZYGWBean(@Field("weichat_id") String weichat_id);

    @FormUrlEncoded
    @POST("index.php?g=Api&m=Insert&a=yytj")
    Call<ZYGW2Bean> loadZYGW2Bean(@Field("name") String name,@Field("sex") String sex,@Field("consult_time") String consult_time,@Field("phone") String phone);
}
