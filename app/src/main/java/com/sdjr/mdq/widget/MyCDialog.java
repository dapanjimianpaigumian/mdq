package com.sdjr.mdq.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.sdjr.mdq.R;


/**
 * Created by 昇盾 on 2017/5/22.
 */

public class MyCDialog extends Dialog {
    private View contentView;
    public static String consult;
    private Context mContext;
    private TextView mycDialogText1,mycDialogText2,mycDialogText3,mycDialogText4;
    private ImageView mycDialogImg1,mycDialogImg2,mycDialogImg3,mycDialogImg4;
    private MyCDialogListener listener;

    //    public MyCDialog(Context context) {
//        this(context, R.style.MyAnimDialog);
//    }
    public interface MyCDialogListener{
        public void onClick(View view);
    }

    public MyCDialog(Context context,int theme,MyCDialogListener listener) {
        super(context,theme);
    }

    public MyCDialog(Context context, int themeResId) {
        super(context, themeResId);
        //加载布局并给布局的控件设置点击事件
        mContext = getContext();
        contentView = getLayoutInflater().inflate(R.layout.mycdialog, null);
//        mycDialogText1 = (TextView) contentView.findViewById(R.id.myc_dialog_text1);
//        mycDialogText2 = (TextView) contentView.findViewById(R.id.myc_dialog_text2);
//        mycDialogText3 = (TextView) contentView.findViewById(R.id.myc_dialog_text3);
//        mycDialogText4 = (TextView) contentView.findViewById(R.id.myc_dialog_text4);
//        mycDialogImg1 = (ImageView) contentView.findViewById(R.id.myc_dialog_img1);
//        mycDialogImg2 = (ImageView) contentView.findViewById(R.id.myc_dialog_img2);
//        mycDialogImg3 = (ImageView) contentView.findViewById(R.id.myc_dialog_img3);
//        mycDialogImg4 = (ImageView) contentView.findViewById(R.id.myc_dialog_img4);
//        mycDialogText1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                consult = "任意时间";
//                mycDialogText1.setTextColor(mContext.getResources().getColor(R.color.home));
//                mycDialogText2.setTextColor(mContext.getResources().getColor(R.color.hei));
//                mycDialogText3.setTextColor(mContext.getResources().getColor(R.color.hei));
//                mycDialogText4.setTextColor(mContext.getResources().getColor(R.color.hei));
//                mycDialogImg1.setVisibility(View.VISIBLE);
//                mycDialogImg2.setVisibility(View.GONE);
//                mycDialogImg3.setVisibility(View.GONE);
//                mycDialogImg4.setVisibility(View.GONE);
//            }
//        });
//        mycDialogText2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                consult = "上午";
//                mycDialogText1.setTextColor(mContext.getResources().getColor(R.color.hei));
//                mycDialogText2.setTextColor(mContext.getResources().getColor(R.color.home));
//                mycDialogText3.setTextColor(mContext.getResources().getColor(R.color.hei));
//                mycDialogText4.setTextColor(mContext.getResources().getColor(R.color.hei));
//                mycDialogImg1.setVisibility(View.GONE);
//                mycDialogImg2.setVisibility(View.VISIBLE);
//                mycDialogImg3.setVisibility(View.GONE);
//                mycDialogImg4.setVisibility(View.GONE);
//            }
//        });
//        mycDialogText3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                consult = "下午";
//                mycDialogText1.setTextColor(mContext.getResources().getColor(R.color.hei));
//                mycDialogText2.setTextColor(mContext.getResources().getColor(R.color.hei));
//                mycDialogText3.setTextColor(mContext.getResources().getColor(R.color.home));
//                mycDialogText4.setTextColor(mContext.getResources().getColor(R.color.hei));
//                mycDialogImg1.setVisibility(View.GONE);
//                mycDialogImg2.setVisibility(View.GONE);
//                mycDialogImg3.setVisibility(View.VISIBLE);
//                mycDialogImg4.setVisibility(View.GONE);
//            }
//        });
//        mycDialogText4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                consult = "晚上";
//                mycDialogText1.setTextColor(mContext.getResources().getColor(R.color.hei));
//                mycDialogText2.setTextColor(mContext.getResources().getColor(R.color.hei));
//                mycDialogText3.setTextColor(mContext.getResources().getColor(R.color.hei));
//                mycDialogText4.setTextColor(mContext.getResources().getColor(R.color.home));
//                mycDialogImg1.setVisibility(View.GONE);
//                mycDialogImg2.setVisibility(View.GONE);
//                mycDialogImg3.setVisibility(View.GONE);
//                mycDialogImg4.setVisibility(View.VISIBLE);
//            }
//        });
        super.setContentView(contentView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 预先设置Dialog的一些属性
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams p = dialogWindow.getAttributes();
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        getWindow().setAttributes(p);
        p.height = (int) (d.getHeight() * 0.4);
        p.width = d.getWidth();
        p.gravity = Gravity.LEFT | Gravity.CENTER;
        dialogWindow.setAttributes(p);
    }

}
