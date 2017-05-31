package com.sdjr.mdq.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.sdjr.mdq.R;
import com.sdjr.mdq.config.UrlConfig;


/**
 * Description: Do one thing at a time, and do well.</br>
 * Autor: Created by jinkun on 2016/5/11.
 */
public class MyBottomDialog extends Dialog {
    private View contentView;

    public MyBottomDialog(Context context) {
        this(context, R.style.MyAnimDialog);
    }

    public MyBottomDialog(Context context, int themeResId) {
        super(context, themeResId);
        //加载布局并给布局的控件设置点击事件
        if (UrlConfig.SCTP_DIALOG == 1){
            contentView = getLayoutInflater().inflate(R.layout.sctp_dialog, null);
        }else if (UrlConfig.SCTP_DIALOG == 2){
            contentView = getLayoutInflater().inflate(R.layout.sctp_dialog2, null);
        }else if (UrlConfig.SCTP_DIALOG == 3){
            contentView = getLayoutInflater().inflate(R.layout.sctp_dialog3, null);
        }
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
        p.gravity = Gravity.LEFT | Gravity.BOTTOM;
        dialogWindow.setAttributes(p);
    }
}
