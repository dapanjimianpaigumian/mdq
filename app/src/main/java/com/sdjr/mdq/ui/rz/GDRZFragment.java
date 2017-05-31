package com.sdjr.mdq.ui.rz;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ant.liao.GifView;
import com.sdjr.mdq.R;
import com.sdjr.mdq.bean.DTBD2Bean;
import com.sdjr.mdq.bean.DTBDBean;
import com.sdjr.mdq.bean.RZBean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.ui.jdrz.JDRZActivity;
import com.sdjr.mdq.ui.login.LoginActivity;
import com.sdjr.mdq.ui.sfrz.SFRZActivity;
import com.sdjr.mdq.ui.sfrz2.SFRZ2Activity;
import com.sdjr.mdq.ui.sqjk.DC;
import com.sdjr.mdq.ui.sqjk.DP;
import com.sdjr.mdq.ui.sqjk.DTBDContract;
import com.sdjr.mdq.ui.sqjk.DTBDPresreter;
import com.sdjr.mdq.ui.tbrz.TBRZActivity;
import com.sdjr.mdq.ui.xlrz.XLRZActivity;
import com.sdjr.mdq.ui.xykrz.XYKRZActivity;
import com.sdjr.mdq.ui.xzlx.XZLXActivity;
import com.sdjr.mdq.ui.yhrz.YHRZActivity;
import com.sdjr.mdq.ui.yys.YYSActivity;
import com.sdjr.mdq.ui.zm.ZMFActivity;
import com.sdjr.mdq.widget.LoadingDialog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class GDRZFragment extends Fragment implements RZContract.View ,DTBDContract.View{
    @Bind(R.id.rz_fragment_text)
    TextView rzFragmentText;
    @Bind(R.id.rz_meiy_img1)
    ImageView rzMeiyImg1;
    @Bind(R.id.rz_meiy_text1)
    TextView rzMeiyText1;
    @Bind(R.id.gdrz_lin1)
    RelativeLayout gdrzLin1;
    @Bind(R.id.rz_meiy_img10)
    ImageView rzMeiyImg10;
    @Bind(R.id.rz_meiy_text10)
    TextView rzMeiyText10;
    @Bind(R.id.gdrz_lin10)
    RelativeLayout gdrzLin10;
    @Bind(R.id.rz_meiy_img2)
    ImageView rzMeiyImg2;
    @Bind(R.id.rz_meiy_text2)
    TextView rzMeiyText2;
    @Bind(R.id.gdrz_lin2)
    RelativeLayout gdrzLin2;
    @Bind(R.id.rz_meiy_img3)
    ImageView rzMeiyImg3;
    @Bind(R.id.rz_meiy_text3)
    TextView rzMeiyText3;
    @Bind(R.id.gdrz_lin3)
    RelativeLayout gdrzLin3;
    @Bind(R.id.rz_meiy_img4)
    ImageView rzMeiyImg4;
    @Bind(R.id.rz_meiy_text4)
    TextView rzMeiyText4;
    @Bind(R.id.gdrz_lin4)
    RelativeLayout gdrzLin4;
    @Bind(R.id.rz_meiy_img5)
    ImageView rzMeiyImg5;
    @Bind(R.id.rz_meiy_text5)
    TextView rzMeiyText5;
    @Bind(R.id.gdrz_lin5)
    RelativeLayout gdrzLin5;
    @Bind(R.id.rz_meiy_img6)
    ImageView rzMeiyImg6;
    @Bind(R.id.rz_meiy_text6)
    TextView rzMeiyText6;
    @Bind(R.id.gdrz_lin6)
    RelativeLayout gdrzLin6;
    @Bind(R.id.rz_meiy_img7)
    ImageView rzMeiyImg7;
    @Bind(R.id.rz_meiy_text7)
    TextView rzMeiyText7;
    @Bind(R.id.gdrz_lin7)
    RelativeLayout gdrzLin7;
    @Bind(R.id.rz_meiy_img8)
    ImageView rzMeiyImg8;
    @Bind(R.id.rz_meiy_text8)
    TextView rzMeiyText8;
    @Bind(R.id.gdrz_lin8)
    RelativeLayout gdrzLin8;
    @Bind(R.id.rz_meiy_img11)
    ImageView rzMeiyImg11;
    @Bind(R.id.rz_meiy_text11)
    TextView rzMeiyText11;
    @Bind(R.id.gdrz_lin11)
    RelativeLayout gdrzLin11;
    @Bind(R.id.rz_meiy_img101)
    ImageView rzMeiyImg101;
    @Bind(R.id.rz_meiy_text101)
    TextView rzMeiyText101;
    @Bind(R.id.gdrz_lin101)
    RelativeLayout gdrzLin101;
    @Bind(R.id.rz_meiy_img21)
    ImageView rzMeiyImg21;
    @Bind(R.id.rz_meiy_text21)
    TextView rzMeiyText21;
    @Bind(R.id.gdrz_lin21)
    RelativeLayout gdrzLin21;
    @Bind(R.id.rz_meiy_img31)
    ImageView rzMeiyImg31;
    @Bind(R.id.rz_meiy_text31)
    TextView rzMeiyText31;
    @Bind(R.id.gdrz_lin31)
    RelativeLayout gdrzLin31;
    @Bind(R.id.rz_meiy_img41)
    ImageView rzMeiyImg41;
    @Bind(R.id.rz_meiy_text41)
    TextView rzMeiyText41;
    @Bind(R.id.gdrz_lin41)
    RelativeLayout gdrzLin41;
    @Bind(R.id.rz_meiy_img51)
    ImageView rzMeiyImg51;
    @Bind(R.id.rz_meiy_text51)
    TextView rzMeiyText51;
    @Bind(R.id.gdrz_lin51)
    RelativeLayout gdrzLin51;
    @Bind(R.id.rz_meiy_img61)
    ImageView rzMeiyImg61;
    @Bind(R.id.rz_meiy_text61)
    TextView rzMeiyText61;
    @Bind(R.id.gdrz_lin61)
    RelativeLayout gdrzLin61;
    @Bind(R.id.rz_meiy_img71)
    ImageView rzMeiyImg71;
    @Bind(R.id.rz_meiy_text71)
    TextView rzMeiyText71;
    @Bind(R.id.gdrz_lin71)
    RelativeLayout gdrzLin71;
    @Bind(R.id.rz_meiy_img81)
    ImageView rzMeiyImg81;
    @Bind(R.id.rz_meiy_text81)
    TextView rzMeiyText81;
    @Bind(R.id.gdrz_lin81)
    RelativeLayout gdrzLin81;
    @Bind(R.id.gdrz_text1)
    TextView gdrzText1;
    @Bind(R.id.gdrz_text2)
    TextView gdrzText2;
    @Bind(R.id.gdrz_text3)
    TextView gdrzText3;
    @Bind(R.id.gdrz_text4)
    TextView gdrzText4;
    @Bind(R.id.gdrz_text5)
    TextView gdrzText5;
    @Bind(R.id.gdrz_text6)
    TextView gdrzText6;
    @Bind(R.id.gdrz_text7)
    TextView gdrzText7;
    @Bind(R.id.gdrz_text8)
    TextView gdrzText8;
    @Bind(R.id.gdrz_text9)
    TextView gdrzText9;
    @Bind(R.id.gdrz_text10)
    TextView gdrzText10;
    @Bind(R.id.gdrz_text11)
    TextView gdrzText11;
    @Bind(R.id.gdrz_text12)
    TextView gdrzText12;
    @Bind(R.id.gdrz_text13)
    TextView gdrzText13;
    @Bind(R.id.gdrz_text14)
    TextView gdrzText14;
    @Bind(R.id.gdrz_text15)
    TextView gdrzText15;
    @Bind(R.id.gdrz_text16)
    TextView gdrzText16;
    @Bind(R.id.gdrz_text17)
    TextView gdrzText17;
    @Bind(R.id.gdrz_text18)
    TextView gdrzText18;
    @Bind(R.id.gdrz_text19)
    TextView gdrzText19;
    @Bind(R.id.gdrz_text20)
    TextView gdrzText20;
    @Bind(R.id.gdrz_text21)
    TextView gdrzText21;
    @Bind(R.id.gdrz_text22)
    TextView gdrzText22;
    @Bind(R.id.gdrz_text23)
    TextView gdrzText23;
    @Bind(R.id.gdrz_text24)
    TextView gdrzText24;
    @Bind(R.id.gdrz_text25)
    TextView gdrzText25;
    @Bind(R.id.gdrz_text26)
    TextView gdrzText26;
    @Bind(R.id.gdrz_text27)
    TextView gdrzText27;
    @Bind(R.id.gdrz_text28)
    TextView gdrzText28;
    @Bind(R.id.gdrz_text29)
    TextView gdrzText29;
    @Bind(R.id.gdrz_text30)
    TextView gdrzText30;
    @Bind(R.id.gdrz_text31)
    TextView gdrzText31;
    @Bind(R.id.gdrz_text32)
    TextView gdrzText32;
    @Bind(R.id.gdrz_text33)
    TextView gdrzText33;
    @Bind(R.id.gdrz_text34)
    TextView gdrzText34;
    @Bind(R.id.gdrz_text35)
    TextView gdrzText35;
    @Bind(R.id.gdrz_text36)
    TextView gdrzText36;
    @Bind(R.id.gdrz_img1)
    ImageView gdrzImg1;
    @Bind(R.id.gdrz_img2)
    ImageView gdrzImg2;
    @Bind(R.id.gdrz_img3)
    ImageView gdrzImg3;
    @Bind(R.id.gdrz_img4)
    ImageView gdrzImg4;
    @Bind(R.id.gdrz_img5)
    ImageView gdrzImg5;
    @Bind(R.id.gdrz_img6)
    ImageView gdrzImg6;
    @Bind(R.id.gdrz_img7)
    ImageView gdrzImg7;
    @Bind(R.id.gdrz_img8)
    ImageView gdrzImg8;
    @Bind(R.id.gdrz_img9)
    ImageView gdrzImg9;
    @Bind(R.id.gdrz_img10)
    ImageView gdrzImg10;
    @Bind(R.id.gdrz_img11)
    ImageView gdrzImg11;
    @Bind(R.id.gdrz_img12)
    ImageView gdrzImg12;
    @Bind(R.id.gdrz_img13)
    ImageView gdrzImg13;
    @Bind(R.id.gdrz_img14)
    ImageView gdrzImg14;
    @Bind(R.id.gdrz_img15)
    ImageView gdrzImg15;
    @Bind(R.id.gdrz_img16)
    ImageView gdrzImg16;
    @Bind(R.id.gdrz_img17)
    ImageView gdrzImg17;
    @Bind(R.id.gdrz_img18)
    ImageView gdrzImg18;
    @Bind(R.id.gdrz_img19)
    ImageView gdrzImg19;
    @Bind(R.id.gdrz_img20)
    ImageView gdrzImg20;
    @Bind(R.id.gdrz_img21)
    ImageView gdrzImg21;
    @Bind(R.id.gdrz_img22)
    ImageView gdrzImg22;
    @Bind(R.id.gdrz_img23)
    ImageView gdrzImg23;
    @Bind(R.id.gdrz_img24)
    ImageView gdrzImg24;
    @Bind(R.id.gdrz_img25)
    ImageView gdrzImg25;
    @Bind(R.id.gdrz_img26)
    ImageView gdrzImg26;
    @Bind(R.id.gdrz_img27)
    ImageView gdrzImg27;
    @Bind(R.id.gdrz_img28)
    ImageView gdrzImg28;
    @Bind(R.id.gdrz_img29)
    ImageView gdrzImg29;
    @Bind(R.id.gdrz_img30)
    ImageView gdrzImg30;
    @Bind(R.id.gdrz_img31)
    ImageView gdrzImg31;
    @Bind(R.id.gdrz_img32)
    ImageView gdrzImg32;
    @Bind(R.id.gdrz_img33)
    ImageView gdrzImg33;
    @Bind(R.id.gdrz_img34)
    ImageView gdrzImg34;
    @Bind(R.id.gdrz_img35)
    ImageView gdrzImg35;
    @Bind(R.id.gdrz_img36)
    ImageView gdrzImg36;
    private Context context;
    private View view;
    private GifView gifView;
    private int sm,yys,xl,tb,jd,xyk,yh,zm,sf,sm1,yys1,xl1,tb1,jd1,xyk1,yh1,zm1,sf1;
    private LoadingDialog loadingDialog;
    private Context activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        activity = getContext();
        loadingDialog = new LoadingDialog(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gdrz, container, false);
        gifView = (GifView) view.findViewById(R.id.gif_view);
        gifView.setGifImage(R.drawable.scroll);
        gifView.setShowDimension(1450, 100);
        ButterKnife.bind(this, view);
        if (UrlConfig.login!=0){
            loadingDialog.show();
//            if (UrlConfig.start!= 0&&UrlConfig.start!=1){
                DTBDPresreter presreter2 = new DTBDPresreter(this,activity);
                presreter2.getData();
//            }else {
//                DP dp = new DP(this,activity);
//                dp.getData();
//            }
            RZPresreter presreter = new RZPresreter(this,loadingDialog);
            presreter.getData();
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (UrlConfig.login!=0){
//            if (UrlConfig.start!= 0&&UrlConfig.start!=1){
                DTBDPresreter presreter2 = new DTBDPresreter(this,activity);
                presreter2.getData();
//            }else {
//                DP dp = new DP(this,activity);
//                dp.getData();
//            }
            RZPresreter presreter = new RZPresreter(this,loadingDialog);
            presreter.getData();
        }

        if (UrlConfig.rz!=0){
            rzFragmentText.setText("0");
            gdrzLin1.setVisibility(View.VISIBLE);
            gdrzText1.setVisibility(View.GONE);
            gdrzImg1.setVisibility(View.GONE);
            gdrzText2.setVisibility(View.VISIBLE);
            gdrzImg2.setVisibility(View.VISIBLE);
            gdrzLin11.setVisibility(View.GONE);

            gdrzLin10.setVisibility(View.VISIBLE);
            gdrzLin101.setVisibility(View.GONE);
            gdrzText4.setVisibility(View.VISIBLE);
            gdrzImg4.setVisibility(View.VISIBLE);
            gdrzText3.setVisibility(View.GONE);
            gdrzImg3.setVisibility(View.GONE);

            gdrzLin2.setVisibility(View.VISIBLE);
            gdrzLin21.setVisibility(View.GONE);
            gdrzText6.setVisibility(View.VISIBLE);
            gdrzImg6.setVisibility(View.VISIBLE);
            gdrzText5.setVisibility(View.GONE);
            gdrzImg5.setVisibility(View.GONE);

            gdrzLin3.setVisibility(View.GONE);
            gdrzLin31.setVisibility(View.VISIBLE);
            gdrzText26.setVisibility(View.VISIBLE);
            gdrzImg26.setVisibility(View.VISIBLE);
            gdrzText25.setVisibility(View.GONE);
            gdrzImg25.setVisibility(View.GONE);
            gdrzLin3.setVisibility(View.GONE);
            gdrzText30.setVisibility(View.VISIBLE);
            gdrzImg30.setVisibility(View.VISIBLE);
            gdrzText29.setVisibility(View.GONE);
            gdrzImg29.setVisibility(View.GONE);
            gdrzText28.setVisibility(View.VISIBLE);
            gdrzImg28.setVisibility(View.VISIBLE);
            gdrzText27.setVisibility(View.GONE);
            gdrzImg27.setVisibility(View.GONE);
            gdrzLin41.setVisibility(View.VISIBLE);
            gdrzLin4.setVisibility(View.GONE);
            gdrzLin51.setVisibility(View.VISIBLE);
            gdrzLin5.setVisibility(View.GONE);
            gdrzLin61.setVisibility(View.VISIBLE);
            gdrzLin6.setVisibility(View.GONE);
            gdrzText31.setVisibility(View.GONE);
            gdrzImg31.setVisibility(View.GONE);
            gdrzText32.setVisibility(View.VISIBLE);
            gdrzImg32.setVisibility(View.VISIBLE);
            gdrzLin71.setVisibility(View.VISIBLE);
            gdrzLin7.setVisibility(View.GONE);
            gdrzLin81.setVisibility(View.VISIBLE);
            gdrzLin8.setVisibility(View.GONE);
            gdrzText33.setVisibility(View.GONE);
            gdrzImg33.setVisibility(View.GONE);
            gdrzText34.setVisibility(View.VISIBLE);
            gdrzImg34.setVisibility(View.VISIBLE);
            gdrzText35.setVisibility(View.GONE);
            gdrzImg35.setVisibility(View.GONE);
            gdrzText36.setVisibility(View.VISIBLE);
            gdrzImg36.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onResponse(RZBean rzBean) {
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
        rzFragmentText.setText(rzBean.getInfo().getPrice().getAmount());
        for (int i = 0; i < rzBean.getInfo().getIdent().get(0).size(); i++) {
            if (rzBean.getInfo().getIdent().get(0).get(i).getStat().equals("0")) {
                if (rzBean.getInfo().getIdent().get(0).get(i).getId().equals("1")) {
                    sm = Integer.parseInt(rzBean.getInfo().getIdent().get(0).get(i).getStat());
                    gdrzLin11.setVisibility(View.GONE);
                    gdrzText1.setVisibility(View.GONE);
                    gdrzImg1.setVisibility(View.GONE);
                    gdrzLin1.setVisibility(View.VISIBLE);
                    gdrzText2.setVisibility(View.VISIBLE);
                    gdrzImg2.setVisibility(View.VISIBLE);
//                            1实名 1 2
//                            2运营商 5 6
//                            3学历 7 8
//                            4淘宝 9 10
//                            5京东 11 12
//                            6信用卡 13 14
//                            7央行 15 16
//                            8芝麻 17 18
//                            10身份 3 4
                } else if (rzBean.getInfo().getIdent().get(0).get(i).getId().equals("2")) {
                    sf = Integer.parseInt(rzBean.getInfo().getIdent().get(0).get(i).getStat());
                    gdrzLin101.setVisibility(View.GONE);
                    gdrzText3.setVisibility(View.GONE);
                    gdrzImg3.setVisibility(View.GONE);
                    gdrzLin10.setVisibility(View.VISIBLE);
                    gdrzText4.setVisibility(View.VISIBLE);
                    gdrzImg4.setVisibility(View.VISIBLE);
                } else if (rzBean.getInfo().getIdent().get(0).get(i).getId().equals("3")) {
                    zm = Integer.parseInt(rzBean.getInfo().getIdent().get(0).get(i).getStat());
                    gdrzLin81.setVisibility(View.GONE);
                    gdrzText17.setVisibility(View.GONE);
                    gdrzImg17.setVisibility(View.GONE);
                    gdrzLin8.setVisibility(View.VISIBLE);
                    gdrzImg18.setVisibility(View.VISIBLE);
                } else if (rzBean.getInfo().getIdent().get(0).get(i).getId().equals("4")) {
                    yys = Integer.parseInt(rzBean.getInfo().getIdent().get(0).get(i).getStat());
                    gdrzLin21.setVisibility(View.GONE);
                    gdrzText5.setVisibility(View.GONE);
                    gdrzImg5.setVisibility(View.GONE);
                    gdrzLin2.setVisibility(View.VISIBLE);
                    gdrzText6.setVisibility(View.VISIBLE);
                    gdrzImg6.setVisibility(View.VISIBLE);
                } else if (rzBean.getInfo().getIdent().get(0).get(i).getId().equals("5")) {
                    tb = Integer.parseInt(rzBean.getInfo().getIdent().get(0).get(i).getStat());
                    gdrzLin41.setVisibility(View.GONE);
                    gdrzText9.setVisibility(View.GONE);
                    gdrzImg9.setVisibility(View.GONE);
                    gdrzLin4.setVisibility(View.VISIBLE);
                    gdrzText10.setVisibility(View.VISIBLE);
                    gdrzImg10.setVisibility(View.VISIBLE);
                } else if (rzBean.getInfo().getIdent().get(0).get(i).getId().equals("6")) {
                    jd = Integer.parseInt(rzBean.getInfo().getIdent().get(0).get(i).getStat());
                    gdrzLin51.setVisibility(View.GONE);
                    gdrzText11.setVisibility(View.GONE);
                    gdrzImg11.setVisibility(View.GONE);
                    gdrzLin5.setVisibility(View.VISIBLE);
                    gdrzText12.setVisibility(View.VISIBLE);
                    gdrzImg12.setVisibility(View.VISIBLE);
                } else if (rzBean.getInfo().getIdent().get(0).get(i).getId().equals("7")) {
                    xl = Integer.parseInt(rzBean.getInfo().getIdent().get(0).get(i).getStat());
                    gdrzLin31.setVisibility(View.GONE);
                    gdrzText7.setVisibility(View.GONE);
                    gdrzImg7.setVisibility(View.GONE);
                    gdrzLin3.setVisibility(View.VISIBLE);
                    gdrzText8.setVisibility(View.VISIBLE);
                    gdrzImg8.setVisibility(View.VISIBLE);
                } else if (rzBean.getInfo().getIdent().get(0).get(i).getId().equals("8")) {
                    yh = Integer.parseInt(rzBean.getInfo().getIdent().get(0).get(i).getStat());
                    gdrzLin71.setVisibility(View.GONE);
                    gdrzText15.setVisibility(View.GONE);
                    gdrzImg15.setVisibility(View.GONE);
                    gdrzLin7.setVisibility(View.VISIBLE);
                    gdrzText16.setVisibility(View.VISIBLE);
                    gdrzImg16.setVisibility(View.VISIBLE);
                } else if (rzBean.getInfo().getIdent().get(0).get(i).getId().equals("9")) {
                    xyk = Integer.parseInt(rzBean.getInfo().getIdent().get(0).get(i).getStat());
                    gdrzLin61.setVisibility(View.GONE);
                    gdrzText13.setVisibility(View.GONE);
                    gdrzImg13.setVisibility(View.GONE);
                    gdrzLin6.setVisibility(View.VISIBLE);
                    gdrzText14.setVisibility(View.VISIBLE);
                    gdrzImg14.setVisibility(View.VISIBLE);
                }
            } else {
                if (rzBean.getInfo().getIdent().get(0).get(i).getId().equals("1")) {
                    sm = Integer.parseInt(rzBean.getInfo().getIdent().get(0).get(i).getStat());
                    gdrzLin11.setVisibility(View.GONE);
                    gdrzText1.setVisibility(View.VISIBLE);
                    gdrzImg1.setVisibility(View.VISIBLE);
                    gdrzLin1.setVisibility(View.VISIBLE);
                    gdrzText2.setVisibility(View.GONE);
                    gdrzImg2.setVisibility(View.GONE);
                } else if (rzBean.getInfo().getIdent().get(0).get(i).getId().equals("2")) {
                    sf = Integer.parseInt(rzBean.getInfo().getIdent().get(0).get(i).getStat());
                    gdrzLin101.setVisibility(View.GONE);
                    gdrzText3.setVisibility(View.VISIBLE);
                    gdrzImg3.setVisibility(View.VISIBLE);
                    gdrzLin10.setVisibility(View.VISIBLE);
                    gdrzText4.setVisibility(View.GONE);
                    gdrzImg4.setVisibility(View.GONE);
                } else if (rzBean.getInfo().getIdent().get(0).get(i).getId().equals("3")) {
                    zm = Integer.parseInt(rzBean.getInfo().getIdent().get(0).get(i).getStat());
                    gdrzLin81.setVisibility(View.GONE);
                    gdrzText17.setVisibility(View.VISIBLE);
                    gdrzImg17.setVisibility(View.VISIBLE);
                    gdrzLin8.setVisibility(View.VISIBLE);
                    gdrzText18.setVisibility(View.GONE);
                    gdrzImg18.setVisibility(View.GONE);
                } else if (rzBean.getInfo().getIdent().get(0).get(i).getId().equals("4")) {
                    yys = Integer.parseInt(rzBean.getInfo().getIdent().get(0).get(i).getStat());
                    gdrzLin21.setVisibility(View.GONE);
                    gdrzText5.setVisibility(View.VISIBLE);
                    gdrzImg5.setVisibility(View.VISIBLE);
                    gdrzLin2.setVisibility(View.VISIBLE);
                    gdrzText6.setVisibility(View.GONE);
                    gdrzImg6.setVisibility(View.GONE);
                } else if (rzBean.getInfo().getIdent().get(0).get(i).getId().equals("5")) {
                    tb = Integer.parseInt(rzBean.getInfo().getIdent().get(0).get(i).getStat());
                    gdrzLin41.setVisibility(View.GONE);
                    gdrzText9.setVisibility(View.VISIBLE);
                    gdrzImg9.setVisibility(View.VISIBLE);
                    gdrzLin4.setVisibility(View.VISIBLE);
                    gdrzText10.setVisibility(View.GONE);
                    gdrzImg10.setVisibility(View.GONE);
                } else if (rzBean.getInfo().getIdent().get(0).get(i).getId().equals("6")) {
                    jd = Integer.parseInt(rzBean.getInfo().getIdent().get(0).get(i).getStat());
                    gdrzLin51.setVisibility(View.GONE);
                    gdrzText11.setVisibility(View.VISIBLE);
                    gdrzImg11.setVisibility(View.VISIBLE);
                    gdrzLin5.setVisibility(View.VISIBLE);
                    gdrzText12.setVisibility(View.GONE);
                    gdrzImg12.setVisibility(View.GONE);
                } else if (rzBean.getInfo().getIdent().get(0).get(i).getId().equals("7")) {
                    xl = Integer.parseInt(rzBean.getInfo().getIdent().get(0).get(i).getStat());
                    gdrzLin31.setVisibility(View.GONE);
                    gdrzText7.setVisibility(View.VISIBLE);
                    gdrzImg7.setVisibility(View.VISIBLE);
                    gdrzLin3.setVisibility(View.VISIBLE);
                    gdrzText8.setVisibility(View.GONE);
                    gdrzImg8.setVisibility(View.GONE);
                } else if (rzBean.getInfo().getIdent().get(0).get(i).getId().equals("8")) {
                    yh = Integer.parseInt(rzBean.getInfo().getIdent().get(0).get(i).getStat());
                    gdrzLin71.setVisibility(View.GONE);
                    gdrzText15.setVisibility(View.VISIBLE);
                    gdrzImg15.setVisibility(View.VISIBLE);
                    gdrzLin7.setVisibility(View.VISIBLE);
                    gdrzText16.setVisibility(View.GONE);
                    gdrzImg16.setVisibility(View.GONE);
                } else if (rzBean.getInfo().getIdent().get(0).get(i).getId().equals("9")) {
                    xyk = Integer.parseInt(rzBean.getInfo().getIdent().get(0).get(i).getStat());
                    gdrzLin61.setVisibility(View.GONE);
                    gdrzText13.setVisibility(View.VISIBLE);
                    gdrzImg13.setVisibility(View.VISIBLE);
                    gdrzLin6.setVisibility(View.VISIBLE);
                    gdrzText14.setVisibility(View.GONE);
                    gdrzImg14.setVisibility(View.GONE);
                }
            }
        }

        for (int i = 0; i < rzBean.getInfo().getIdent().get(1).size(); i++) {
            if (rzBean.getInfo().getIdent().get(1).get(i).getStat().equals("0")) {
                if (rzBean.getInfo().getIdent().get(1).get(i).getId().equals("1")) {
                    sm1 = Integer.parseInt(rzBean.getInfo().getIdent().get(1).get(i).getStat());
                    gdrzLin11.setVisibility(View.VISIBLE);
                    gdrzText19.setVisibility(View.GONE);
                    gdrzImg19.setVisibility(View.GONE);
                    gdrzLin1.setVisibility(View.GONE);
                    gdrzText20.setVisibility(View.VISIBLE);
                    gdrzImg20.setVisibility(View.VISIBLE);
                } else if (rzBean.getInfo().getIdent().get(1).get(i).getId().equals("2")) {
                    sf1 = Integer.parseInt(rzBean.getInfo().getIdent().get(1).get(i).getStat());
                    gdrzLin101.setVisibility(View.VISIBLE);
                    gdrzText21.setVisibility(View.GONE);
                    gdrzImg21.setVisibility(View.GONE);
                    gdrzLin10.setVisibility(View.GONE);
                    gdrzText22.setVisibility(View.VISIBLE);
                    gdrzImg22.setVisibility(View.VISIBLE);
                } else if (rzBean.getInfo().getIdent().get(1).get(i).getId().equals("3")) {
                    zm1 = Integer.parseInt(rzBean.getInfo().getIdent().get(1).get(i).getStat());
                    gdrzLin81.setVisibility(View.VISIBLE);
                    gdrzText35.setVisibility(View.GONE);
                    gdrzImg35.setVisibility(View.GONE);
                    gdrzLin8.setVisibility(View.GONE);
                    gdrzText36.setVisibility(View.VISIBLE);
                    gdrzImg36.setVisibility(View.VISIBLE);
                } else if (rzBean.getInfo().getIdent().get(1).get(i).getId().equals("4")) {
                    yys1 = Integer.parseInt(rzBean.getInfo().getIdent().get(1).get(i).getStat());
                    gdrzLin21.setVisibility(View.VISIBLE);
                    gdrzText23.setVisibility(View.GONE);
                    gdrzImg23.setVisibility(View.GONE);
                    gdrzLin2.setVisibility(View.GONE);
                    gdrzText24.setVisibility(View.VISIBLE);
                    gdrzImg24.setVisibility(View.VISIBLE);
                } else if (rzBean.getInfo().getIdent().get(1).get(i).getId().equals("5")) {
                    tb1 = Integer.parseInt(rzBean.getInfo().getIdent().get(1).get(i).getStat());
                    gdrzLin41.setVisibility(View.VISIBLE);
                    gdrzText27.setVisibility(View.GONE);
                    gdrzImg27.setVisibility(View.GONE);
                    gdrzLin4.setVisibility(View.GONE);
                    gdrzText28.setVisibility(View.VISIBLE);
                    gdrzImg28.setVisibility(View.VISIBLE);
                } else if (rzBean.getInfo().getIdent().get(1).get(i).getId().equals("6")) {
                    jd1 = Integer.parseInt(rzBean.getInfo().getIdent().get(1).get(i).getStat());
                    gdrzLin51.setVisibility(View.VISIBLE);
                    gdrzText29.setVisibility(View.GONE);
                    gdrzImg29.setVisibility(View.GONE);
                    gdrzLin5.setVisibility(View.GONE);
                    gdrzText30.setVisibility(View.VISIBLE);
                    gdrzImg30.setVisibility(View.VISIBLE);
                } else if (rzBean.getInfo().getIdent().get(1).get(i).getId().equals("7")) {
                    xl1 = Integer.parseInt(rzBean.getInfo().getIdent().get(1).get(i).getStat());
                    gdrzLin31.setVisibility(View.VISIBLE);
                    gdrzText25.setVisibility(View.GONE);
                    gdrzImg25.setVisibility(View.GONE);
                    gdrzLin3.setVisibility(View.GONE);
                    gdrzText26.setVisibility(View.VISIBLE);
                    gdrzImg26.setVisibility(View.VISIBLE);
                } else if (rzBean.getInfo().getIdent().get(1).get(i).getId().equals("8")) {
                    yh1 = Integer.parseInt(rzBean.getInfo().getIdent().get(1).get(i).getStat());
                    gdrzLin71.setVisibility(View.VISIBLE);
                    gdrzText33.setVisibility(View.GONE);
                    gdrzImg33.setVisibility(View.GONE);
                    gdrzLin7.setVisibility(View.GONE);
                    gdrzText34.setVisibility(View.VISIBLE);
                    gdrzImg34.setVisibility(View.VISIBLE);
                } else if (rzBean.getInfo().getIdent().get(1).get(i).getId().equals("9")) {
                    xyk1 = Integer.parseInt(rzBean.getInfo().getIdent().get(1).get(i).getStat());
                    gdrzLin61.setVisibility(View.VISIBLE);
                    gdrzText31.setVisibility(View.GONE);
                    gdrzImg31.setVisibility(View.GONE);
                    gdrzLin6.setVisibility(View.GONE);
                    gdrzText32.setVisibility(View.VISIBLE);
                    gdrzImg32.setVisibility(View.VISIBLE);
                }
            } else {
                if (rzBean.getInfo().getIdent().get(1).get(i).getId().equals("1")) {
                    sm1 = Integer.parseInt(rzBean.getInfo().getIdent().get(1).get(i).getStat());
                    gdrzLin11.setVisibility(View.VISIBLE);
                    gdrzText19.setVisibility(View.VISIBLE);
                    gdrzImg19.setVisibility(View.VISIBLE);
                    gdrzLin1.setVisibility(View.GONE);
                    gdrzText20.setVisibility(View.GONE);
                    gdrzImg20.setVisibility(View.GONE);
                } else if (rzBean.getInfo().getIdent().get(1).get(i).getId().equals("2")) {
                    sf1 = Integer.parseInt(rzBean.getInfo().getIdent().get(1).get(i).getStat());
                    gdrzLin101.setVisibility(View.VISIBLE);
                    gdrzText21.setVisibility(View.VISIBLE);
                    gdrzImg21.setVisibility(View.VISIBLE);
                    gdrzLin10.setVisibility(View.GONE);
                    gdrzText22.setVisibility(View.GONE);
                    gdrzImg22.setVisibility(View.GONE);
                } else if (rzBean.getInfo().getIdent().get(1).get(i).getId().equals("3")) {
                    zm1 = Integer.parseInt(rzBean.getInfo().getIdent().get(1).get(i).getStat());
                    gdrzLin81.setVisibility(View.VISIBLE);
                    gdrzText35.setVisibility(View.VISIBLE);
                    gdrzImg35.setVisibility(View.VISIBLE);
                    gdrzLin8.setVisibility(View.GONE);
                    gdrzText36.setVisibility(View.GONE);
                    gdrzImg36.setVisibility(View.GONE);
                } else if (rzBean.getInfo().getIdent().get(1).get(i).getId().equals("4")) {
                    yys1 = Integer.parseInt(rzBean.getInfo().getIdent().get(1).get(i).getStat());
                    gdrzLin21.setVisibility(View.VISIBLE);
                    gdrzText23.setVisibility(View.VISIBLE);
                    gdrzImg23.setVisibility(View.VISIBLE);
                    gdrzLin2.setVisibility(View.GONE);
                    gdrzText24.setVisibility(View.GONE);
                    gdrzImg24.setVisibility(View.GONE);
                } else if (rzBean.getInfo().getIdent().get(1).get(i).getId().equals("5")) {
                    tb1 = Integer.parseInt(rzBean.getInfo().getIdent().get(1).get(i).getStat());
                    gdrzLin41.setVisibility(View.VISIBLE);
                    gdrzText27.setVisibility(View.VISIBLE);
                    gdrzImg27.setVisibility(View.VISIBLE);
                    gdrzLin4.setVisibility(View.GONE);
                    gdrzText28.setVisibility(View.GONE);
                    gdrzImg28.setVisibility(View.GONE);
                } else if (rzBean.getInfo().getIdent().get(1).get(i).getId().equals("6")) {
                    jd1 = Integer.parseInt(rzBean.getInfo().getIdent().get(1).get(i).getStat());
                    gdrzLin51.setVisibility(View.VISIBLE);
                    gdrzText29.setVisibility(View.VISIBLE);
                    gdrzImg29.setVisibility(View.VISIBLE);
                    gdrzLin5.setVisibility(View.GONE);
                    gdrzText30.setVisibility(View.GONE);
                    gdrzImg30.setVisibility(View.GONE);
                } else if (rzBean.getInfo().getIdent().get(1).get(i).getId().equals("7")) {
                    xl1 = Integer.parseInt(rzBean.getInfo().getIdent().get(1).get(i).getStat());
                    gdrzLin31.setVisibility(View.VISIBLE);
                    gdrzText25.setVisibility(View.VISIBLE);
                    gdrzImg25.setVisibility(View.VISIBLE);
                    gdrzLin3.setVisibility(View.GONE);
                    gdrzText26.setVisibility(View.GONE);
                    gdrzImg26.setVisibility(View.GONE);
                } else if (rzBean.getInfo().getIdent().get(1).get(i).getId().equals("8")) {
                    yh1 = Integer.parseInt(rzBean.getInfo().getIdent().get(1).get(i).getStat());
                    gdrzLin71.setVisibility(View.VISIBLE);
                    gdrzText33.setVisibility(View.VISIBLE);
                    gdrzImg33.setVisibility(View.VISIBLE);
                    gdrzLin7.setVisibility(View.GONE);
                    gdrzText34.setVisibility(View.GONE);
                    gdrzImg34.setVisibility(View.GONE);
                } else if (rzBean.getInfo().getIdent().get(1).get(i).getId().equals("9")) {
                    xyk1 = Integer.parseInt(rzBean.getInfo().getIdent().get(1).get(i).getStat());
                    gdrzLin61.setVisibility(View.VISIBLE);
                    gdrzText31.setVisibility(View.VISIBLE);
                    gdrzImg31.setVisibility(View.VISIBLE);
                    gdrzLin6.setVisibility(View.GONE);
                    gdrzText32.setVisibility(View.GONE);
                    gdrzImg32.setVisibility(View.GONE);
                }
            }
        }
    }

    @Override
    public void onResponse(DTBDBean dtbdBean) {
        UrlConfig.start = Integer.parseInt(dtbdBean.getInfo());
    }

//    @Override
//    public void onResponse(DTBD2Bean dtbd2Bean) {
//        UrlConfig.start = Integer.parseInt(dtbd2Bean.getInfo());
//    }

    @Override
    public void onFailure(String s) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.gdrz_lin1, R.id.gdrz_lin10, R.id.gdrz_lin2, R.id.gdrz_lin3, R.id.gdrz_lin4, R.id.gdrz_lin5, R.id.gdrz_lin6, R.id.gdrz_lin7, R.id.gdrz_lin8, R.id.gdrz_lin11, R.id.gdrz_lin101, R.id.gdrz_lin21, R.id.gdrz_lin31, R.id.gdrz_lin41, R.id.gdrz_lin51, R.id.gdrz_lin61, R.id.gdrz_lin71, R.id.gdrz_lin81})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gdrz_lin1:
                if (UrlConfig.login == 0){
//                            1实名 1 2
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }else {
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
                            Toast.makeText(context, "认证已完成,无需重复提交", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
                break;
            case R.id.gdrz_lin10:
//                            10身份 3 4
                if (UrlConfig.login == 0){
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }else {
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
                            Toast.makeText(context, "认证已完成,无需重复提交", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

                break;
            case R.id.gdrz_lin2:
//                2运营商 5 6
                if (UrlConfig.login == 0){
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }else {
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
                            Toast.makeText(context, "认证已完成,无需重复提交", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

                break;
            case R.id.gdrz_lin3:
                //                            3学历 7 8
                if (UrlConfig.login == 0){
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }else {
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
                            Toast.makeText(context, "认证已完成,无需重复提交", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
                break;
            case R.id.gdrz_lin4:
                //                            4淘宝 9 10
                if (UrlConfig.login == 0){
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }else {
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
                            Toast.makeText(context, "认证已完成,无需重复提交", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
                break;
            case R.id.gdrz_lin5:
                //                            5京东 11 12
                if (UrlConfig.login == 0){
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }else {
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
                            Toast.makeText(context, "认证已完成,无需重复提交", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
                break;
            case R.id.gdrz_lin6:
                //                            6信用卡 13 14
                if (UrlConfig.login == 0){
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }else {
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
                            Toast.makeText(context, "认证已完成,无需重复提交", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
                break;
            case R.id.gdrz_lin7:
                //                            7央行 15 16
                if (UrlConfig.login == 0){
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }else {
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
                            Toast.makeText(context, "认证已完成,无需重复提交", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
                break;
            case R.id.gdrz_lin8:
                //                            8芝麻 17 18
                if (UrlConfig.login == 0){
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }else {
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
                            Toast.makeText(context, "认证已完成,无需重复提交", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
                break;
            case R.id.gdrz_lin11:
                if (UrlConfig.login == 0){
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }else {
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
                            Toast.makeText(context, "认证已完成,无需重复提交", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
                break;
            case R.id.gdrz_lin101:
                if (UrlConfig.login == 0){
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }else {
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
                            Toast.makeText(context, "认证已完成,无需重复提交", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
                break;
            case R.id.gdrz_lin21:
                if (UrlConfig.login == 0){
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }else {
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
                            if (yys1 == 0){
                                intent = new Intent(context, YYSActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(context, "认证已完成,无需重复提交", Toast.LENGTH_SHORT).show();
                            }
                            break;
                    }
                }
                break;
            case R.id.gdrz_lin31:
                if (UrlConfig.login == 0){
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }else {
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
                            if (xl1 == 0){
                                intent = new Intent(context, XLRZActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(context, "认证已完成,无需重复提交", Toast.LENGTH_SHORT).show();
                            }
                            break;
                    }
                }
                break;
            case R.id.gdrz_lin41:
                if (UrlConfig.login == 0){
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }else {
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
                            if (tb1 == 0){
                                intent = new Intent(context, TBRZActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(context, "认证已完成,无需重复提交", Toast.LENGTH_SHORT).show();
                            }
                            break;
                    }
                }
                break;
            case R.id.gdrz_lin51:
                if (UrlConfig.login == 0){
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }else {
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
                            if (jd1 == 0){
                                intent = new Intent(context, JDRZActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(context, "认证已完成,无需重复提交", Toast.LENGTH_SHORT).show();
                            }
                            break;
                    }
                }
                break;
            case R.id.gdrz_lin61:
                if (UrlConfig.login == 0){
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }else {
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
                            if (xyk1 == 0){
                                intent = new Intent(context, XYKRZActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(context, "认证已完成,无需重复提交", Toast.LENGTH_SHORT).show();
                            }
                            break;
                    }
                }
                break;
            case R.id.gdrz_lin71:
                if (UrlConfig.login == 0){
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }else {
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
                            if (yh1 == 0){
                                intent = new Intent(context, YHRZActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(context, "认证已完成,无需重复提交", Toast.LENGTH_SHORT).show();
                            }
                            break;
                    }
                }
                break;
            case R.id.gdrz_lin81:
                if (UrlConfig.login == 0){
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }else {
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
                            Toast.makeText(context, "认证已完成,无需重复提交", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
                break;
        }
    }
}
