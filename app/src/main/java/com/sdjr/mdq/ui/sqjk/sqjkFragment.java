package com.sdjr.mdq.ui.sqjk;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sdjr.mdq.R;
import com.sdjr.mdq.bean.DTBDBean;
import com.sdjr.mdq.bean.SYBNBean;
import com.sdjr.mdq.bean.WSBean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.ui.jdr.GuidePageAdapter;
import com.sdjr.mdq.ui.jdr.JDRActivity;
import com.sdjr.mdq.ui.jdrz.JDRZActivity;
import com.sdjr.mdq.ui.jkgl.JKGLActivity;
import com.sdjr.mdq.ui.login.LoginActivity;
import com.sdjr.mdq.ui.sfrz.SFRZActivity;
import com.sdjr.mdq.ui.tbrz.TBRZActivity;
import com.sdjr.mdq.ui.ws.WSContract;
import com.sdjr.mdq.ui.ws.WSPresreter;
import com.sdjr.mdq.ui.xlrz.XLRZActivity;
import com.sdjr.mdq.ui.xykrz.XYKRZActivity;
import com.sdjr.mdq.ui.xzlx.XZLXActivity;
import com.sdjr.mdq.ui.yhrz.YHRZActivity;
import com.sdjr.mdq.ui.yys.YYSActivity;
import com.sdjr.mdq.ui.zm.ZMFActivity;
import com.sdjr.mdq.ui.zygw.ZYGWActivity;
import com.sdjr.mdq.widget.ScrollTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class sqjkFragment extends Fragment implements DTBDContract.View, WSContract.View, SQJKBANContract.View,ViewPager.OnPageChangeListener {
    @Bind(R.id.sqjk_btn1)
    Button sqjkBtn1;
    @Bind(R.id.sqjk_lin1)
    RelativeLayout sqjkLin1;
    @Bind(R.id.sqjk_lin2)
    RelativeLayout sqjkLin2;
    @Bind(R.id.sqjk_lin3)
    RelativeLayout sqjkLin3;
    @Bind(R.id.sqjk_viewpage)
    ViewPager sqjkViewpage;
    private Context context;
    private View view;
    private int b1 = 1, b2 = 3;
    private Context activity;
    private String[] imageIdArray;//图片资源的数组
    private List<View> viewList;//图片资源的集合
    private boolean isLooper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        activity = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sqjk, container, false);
        ButterKnife.bind(this, view);
        SQJKBANPresreter presreter = new SQJKBANPresreter(this);
        presreter.getData();

        sqjkBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UrlConfig.login != 0) {
                    DTBDPresreter presreter = new DTBDPresreter(sqjkFragment.this, activity);
                    presreter.getData();
                    if (UrlConfig.rz == 1){
                        Intent intent = new Intent(context,XZLXActivity.class);
                        startActivity(intent);
                    }
                } else {
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        String temp = getResources().getString(R.string.info);
        ScrollTextView sqjkScrollText1 = (ScrollTextView) view.findViewById(R.id.sqjk_scroll_text1);
        sqjkScrollText1.setText(temp);
        sqjkScrollText1.beginScroll();
//        String temp1 = getResources().getString(R.string.info1);
//        ScrollTextView1 sqjkScrollText2 = (ScrollTextView1) view.findViewById(R.id.sqjk_scroll_text2);
//        sqjkScrollText2.setText(temp1);
//        sqjkScrollText2.beginScroll();
//        String temp2 = getResources().getString(R.string.info2);
//        ScrollTextView sqjkScrollText3 = (ScrollTextView) view.findViewById(R.id.sqjk_scroll_tex3);
//        sqjkScrollText3.setText(temp2);
//        sqjkScrollText3.beginScroll();
        return view;
    }

    /**
     * 加载图片ViewPager
     */
    private void initViewPager(String st , String str,String str3 , String str4) {
        //实例化图片资源
        imageIdArray = new String[]{st,str,str3,str4};
        viewList = new ArrayList<>();
        //获取一个Layout参数，设置为全屏
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);

        //循环创建View并加入到集合中
        int len = imageIdArray.length;
        for (int i = 0;i<len;i++){
            //new ImageView并设置全屏和图片资源
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(params);
//            imageView.setBackgroundResource(imageIdArray[i]);
            Glide.with(context).load(imageIdArray[i]).into(imageView);
            //将ImageView加入到集合中
            viewList.add(imageView);
        }

        //View集合初始化好后，设置Adapter
        sqjkViewpage.setAdapter(new GuidePageAdapter(viewList));
        //设置滑动监听
        sqjkViewpage.setOnPageChangeListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onResponse(DTBDBean dtbdBean) {
        UrlConfig.start = Integer.parseInt(dtbdBean.getInfo());
        switch (UrlConfig.start) {
            case 1:
                Intent intent = new Intent(context, XZLXActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(context, SFRZActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(context, ZMFActivity.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(context, YYSActivity.class);
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(context, TBRZActivity.class);
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(context, JDRZActivity.class);
                startActivity(intent);
                break;
            case 7:
                intent = new Intent(context, XLRZActivity.class);
                startActivity(intent);
                break;
            case 8:
                intent = new Intent(context, YHRZActivity.class);
                startActivity(intent);
                break;
            case 9:
                intent = new Intent(context, XYKRZActivity.class);
                startActivity(intent);
                break;
            case 10:
                Toast.makeText(context, "您的借款申请已提交，请保持通话畅通，等待审核专员与您联系", Toast.LENGTH_SHORT).show();
                break;
        }
        WSPresreter presreter = new WSPresreter(this);
        presreter.getData();
        if (dtbdBean.getPurviews().getStep5().get(0).getR().equals("1")) {
            if (dtbdBean.getPurviews().getStep5().get(0).getId().equals(UrlConfig.yunying)) {
                UrlConfig.yunying1 = 1;
            } else if (dtbdBean.getPurviews().getStep5().get(0).getId().equals(UrlConfig.gongjijin)) {
                UrlConfig.gongjijin1 = 1;
            } else if (dtbdBean.getPurviews().getStep5().get(0).getId().equals(UrlConfig.taobao)) {
                UrlConfig.taobao1 = 1;
            } else if (dtbdBean.getPurviews().getStep5().get(0).getId().equals(UrlConfig.shebao)) {
                UrlConfig.shebao1 = 1;
            } else if (dtbdBean.getPurviews().getStep5().get(0).getId().equals(UrlConfig.xuexin)) {
                UrlConfig.xuexin1 = 1;
            } else if (dtbdBean.getPurviews().getStep5().get(0).getId().equals(UrlConfig.jd)) {
                UrlConfig.jd1 = 1;
            } else if (dtbdBean.getPurviews().getStep5().get(0).getId().equals(UrlConfig.xinyongka)) {
                UrlConfig.xinyongka1 = 1;
            } else if (dtbdBean.getPurviews().getStep5().get(0).getId().equals(UrlConfig.zhengxin)) {
                UrlConfig.zhengxin1 = 1;
            }
        }
        if (dtbdBean.getPurviews().getStep1() != null) {
            for (int i = 0; i < dtbdBean.getPurviews().getStep1().size(); i++) {
                if (dtbdBean.getPurviews().getStep1().get(i).getR().equals("1")) {
                    if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.borrow)) {
                        UrlConfig.borrow1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.credits)) {
                        UrlConfig.credits1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.address)) {
                        UrlConfig.address1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.car_loan)) {
                        UrlConfig.car_loan1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.jin_liabilities)) {
                        UrlConfig.jin_liabilities1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.graduation)) {
                        UrlConfig.graduation1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.house_loan)) {
                        UrlConfig.house_loan1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.bao_liabilities)) {
                        UrlConfig.bao_liabilities1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.zhima_score)) {
                        UrlConfig.zhima_score1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.home_tel)) {
                        UrlConfig.home_tel1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.credit_limit)) {
                        UrlConfig.credit_limit1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.name)) {
                        UrlConfig.name1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.idcard)) {
                        UrlConfig.idcard1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.marriage)) {
                        UrlConfig.marriage1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.QQ)) {
                        UrlConfig.QQ1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.houses)) {
                        UrlConfig.houses1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.jiedaibao)) {
                        UrlConfig.jiedaibao1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.emails)) {
                        UrlConfig.emails1 = 1;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.recommend)) {
                        UrlConfig.recommend1 = 1;
                    }
                } else if (dtbdBean.getPurviews().getStep1().get(i).getR().equals("0")) {
                    if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.borrow)) {
                        UrlConfig.borrow1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.credits)) {
                        UrlConfig.credits1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.address)) {
                        UrlConfig.address1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.car_loan)) {
                        UrlConfig.car_loan1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.jin_liabilities)) {
                        UrlConfig.jin_liabilities1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.graduation)) {
                        UrlConfig.graduation1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.house_loan)) {
                        UrlConfig.house_loan1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.bao_liabilities)) {
                        UrlConfig.bao_liabilities1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.zhima_score)) {
                        UrlConfig.zhima_score1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.home_tel)) {
                        UrlConfig.home_tel1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.credit_limit)) {
                        UrlConfig.credit_limit1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.name)) {
                        UrlConfig.name1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.idcard)) {
                        UrlConfig.idcard1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.marriage)) {
                        UrlConfig.marriage1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.QQ)) {
                        UrlConfig.QQ1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.houses)) {
                        UrlConfig.houses1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.jiedaibao)) {
                        UrlConfig.jiedaibao1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.emails)) {
                        UrlConfig.emails1 = 2;
                    } else if (dtbdBean.getPurviews().getStep1().get(i).getId().equals(UrlConfig.recommend)) {
                        UrlConfig.recommend1 = 2;
                    }
                }
            }
        } else {
            UrlConfig.step1 = 1;
        }

        if (dtbdBean.getPurviews().getStep2() != null) {
            for (int i = 0; i < dtbdBean.getPurviews().getStep2().size(); i++) {
                if (dtbdBean.getPurviews().getStep2().get(i).getR().equals("1")) {
                    if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.workmate)) {
                        UrlConfig.workmate1 = 1;
                    } else if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.mother)) {
                        UrlConfig.mother1 = 1;
                    } else if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.father)) {
                        UrlConfig.father1 = 1;
                    } else if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.family)) {
                        UrlConfig.family1 = 1;
                    } else if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.friend)) {
                        UrlConfig.friend1 = 1;
                    }
                } else if (dtbdBean.getPurviews().getStep2().get(i).getR().equals("0")) {
                    if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.workmate)) {
                        UrlConfig.workmate1 = 2;
                    } else if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.mother)) {
                        UrlConfig.mother1 = 2;
                    } else if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.father)) {
                        UrlConfig.father1 = 2;
                    } else if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.family)) {
                        UrlConfig.family1 = 2;
                    } else if (dtbdBean.getPurviews().getStep2().get(i).getId().equals(UrlConfig.friend)) {
                        UrlConfig.friend1 = 2;
                    }
                }
            }
        } else {
            UrlConfig.step2 = 1;
        }

        if (dtbdBean.getPurviews().getStep3() != null) {
            for (int i = 0; i < dtbdBean.getPurviews().getStep3().size(); i++) {
                if (dtbdBean.getPurviews().getStep3().get(i).getR().equals("1")) {
                    if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_email)) {
                        UrlConfig.com_email1 = 1;
                    } else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_scale)) {
                        UrlConfig.com_scale1 = 1;
                    } else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.company)) {
                        UrlConfig.company1 = 1;
                    } else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_type)) {
                        UrlConfig.com_type1 = 1;
                    } else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_position)) {
                        UrlConfig.com_position1 = 1;
                    } else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_tel)) {
                        UrlConfig.com_tel1 = 1;
                    } else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.salary)) {
                        UrlConfig.salary1 = 1;
                    }
                } else if (dtbdBean.getPurviews().getStep3().get(i).getR().equals("0")) {
                    if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_email)) {
                        UrlConfig.com_email1 = 2;
                    } else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_scale)) {
                        UrlConfig.com_scale1 = 2;
                    } else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.company)) {
                        UrlConfig.company1 = 2;
                    } else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_type)) {
                        UrlConfig.com_type1 = 2;
                    } else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_position)) {
                        UrlConfig.com_position1 = 2;
                    } else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.com_tel)) {
                        UrlConfig.com_tel1 = 2;
                    } else if (dtbdBean.getPurviews().getStep3().get(i).getId().equals(UrlConfig.salary)) {
                        UrlConfig.salary1 = 2;
                    }
                }
            }
        } else {
            UrlConfig.step3 = 1;
        }

        if (dtbdBean.getPurviews().getStep4() != null) {
            for (int i = 0; i < dtbdBean.getPurviews().getStep4().size(); i++) {
                if (dtbdBean.getPurviews().getStep4().get(i).getR().equals("1")) {
                    if (dtbdBean.getPurviews().getStep4().get(i).getId().equals(UrlConfig.front)) {
                        UrlConfig.front1 = 1;
                    } else if (dtbdBean.getPurviews().getStep4().get(i).getId().equals(UrlConfig.more_img)) {
                        UrlConfig.more_img1 = 1;
                    } else if (dtbdBean.getPurviews().getStep4().get(i).getId().equals(UrlConfig.back)) {
                        UrlConfig.back1 = 1;
                    } else if (dtbdBean.getPurviews().getStep4().get(i).getId().equals(UrlConfig.handsID)) {
                        UrlConfig.handsID1 = 1;
                    }
                } else if (dtbdBean.getPurviews().getStep4().get(i).getR().equals("0")) {
                    if (dtbdBean.getPurviews().getStep4().get(i).getId().equals(UrlConfig.front)) {
                        UrlConfig.front1 = 2;
                    } else if (dtbdBean.getPurviews().getStep4().get(i).getId().equals(UrlConfig.more_img)) {
                        UrlConfig.more_img1 = 2;
                    } else if (dtbdBean.getPurviews().getStep4().get(i).getId().equals(UrlConfig.back)) {
                        UrlConfig.back1 = 2;
                    } else if (dtbdBean.getPurviews().getStep4().get(i).getId().equals(UrlConfig.handsID)) {
                        UrlConfig.handsID1 = 2;
                    }
                }
            }
        } else {
            UrlConfig.step4 = 1;
        }
    }

    @Override
    public void onResponse(WSBean wsBean) {
//        if (wsBean.getInfo().equals("2222")) {
//            if (UrlConfig.yunying1 == 1) {
//                Intent intent = new Intent(context, YYSActivity.class);
//                startActivity(intent);
//            } else if (UrlConfig.gongjijin1 == 1) {
//                Intent intent = new Intent(context, GJJActivity.class);
//                startActivity(intent);
//            } else if (UrlConfig.taobao1 == 1) {
//                Intent intent = new Intent(context, TBRZActivity.class);
//                startActivity(intent);
//            } else if (UrlConfig.shebao1 == 1) {
//                Intent intent = new Intent(context, SBActivity.class);
//                startActivity(intent);
//            } else if (UrlConfig.xuexin1 == 1) {
//                Intent intent = new Intent(context, XLRZActivity.class);
//                startActivity(intent);
//            } else if (UrlConfig.jd1 == 1) {
//                Intent intent = new Intent(context, JDRZActivity.class);
//                startActivity(intent);
//            } else if (UrlConfig.xinyongka1 == 1) {
//                Intent intent = new Intent(context, XYKRZActivity.class);
//                startActivity(intent);
//            } else if (UrlConfig.zhengxin1 == 1) {
//                Intent intent = new Intent(context, ZXRZActivity.class);
//                startActivity(intent);
//            }
//        } else if (wsBean.getInfo().equals("1111")) {
//            Intent intent = new Intent(context, SFRZActivity.class);
//            startActivity(intent);
//        } else if (wsBean.getInfo().equals("2111")) {
//            Intent intent = new Intent(context, SFRZActivity.class);
//            startActivity(intent);
//        } else if (wsBean.getInfo().equals("2211")) {
//            Intent intent = new Intent(context, SFRZActivity.class);
//            startActivity(intent);
//        } else if (wsBean.getInfo().equals("2221")) {
//            Intent intent = new Intent(context, SFRZActivity.class);
//            startActivity(intent);
//        }
//
//        if (UrlConfig.step3 == 1) {
//            if (wsBean.getInfo().equals("2212")) {
//                if (UrlConfig.yunying1 == 1) {
//                    Intent intent = new Intent(context, YYSActivity.class);
//                    startActivity(intent);
//                } else if (UrlConfig.gongjijin1 == 1) {
//                    Intent intent = new Intent(context, GJJActivity.class);
//                    startActivity(intent);
//                } else if (UrlConfig.taobao1 == 1) {
//                    Intent intent = new Intent(context, TBRZActivity.class);
//                    startActivity(intent);
//                } else if (UrlConfig.shebao1 == 1) {
//                    Intent intent = new Intent(context, SBActivity.class);
//                    startActivity(intent);
//                } else if (UrlConfig.xuexin1 == 1) {
//                    Intent intent = new Intent(context, XLRZActivity.class);
//                    startActivity(intent);
//                } else if (UrlConfig.jd1 == 1) {
//                    Intent intent = new Intent(context, JDRZActivity.class);
//                    startActivity(intent);
//                } else if (UrlConfig.xinyongka1 == 1) {
//                    Intent intent = new Intent(context, XYKRZActivity.class);
//                    startActivity(intent);
//                } else if (UrlConfig.zhengxin1 == 1) {
//                    Intent intent = new Intent(context, ZXRZActivity.class);
//                    startActivity(intent);
//                }
//            } else {
//                if (wsBean.getInfo().equals("2212")) {
//                    Intent intent = new Intent(context, SFRZActivity.class);
//                    startActivity(intent);
//                }
//            }
//        }
    }

    @Override
    public void onResponse(SYBNBean sybnBean) {
//加载ViewPager
        String st = sybnBean.getInfo().get(0).getImage();
        String str = sybnBean.getInfo().get(1).getImage();
        String str3 = sybnBean.getInfo().get(0).getImage();
        String str4 = sybnBean.getInfo().get(1).getImage();
        initViewPager(st,str,str3,str4);
        //修改添加设置ViewPager的当前页，为了保证左右轮播
        sqjkViewpage.setCurrentItem(0);
        //开启一个线程，用于循环
        new Thread(new Runnable() {
            @Override
            public void run() {
                isLooper = true;
                while (isLooper){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    ((Activity)context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //这里是设置当前页的下一页
                            if (sqjkViewpage!=null){
                                sqjkViewpage.setCurrentItem(sqjkViewpage.getCurrentItem() + 1);
                            }
                        }
                    });

                }
            }
        }).start();
    }

    @Override
    public void onFailure(String s) {

    }

    @OnClick({R.id.sqjk_lin1, R.id.sqjk_lin2, R.id.sqjk_lin3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sqjk_lin1:
                Intent intent = new Intent(context, JDRActivity.class);
                startActivity(intent);
                break;
            case R.id.sqjk_lin2:
                intent = new Intent(context, JKGLActivity.class);
                startActivity(intent);
                break;
            case R.id.sqjk_lin3:
                intent = new Intent(context, ZYGWActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //修改全部的position长度
        int newPosition = position % viewList.size();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
