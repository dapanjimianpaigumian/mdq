package com.sdjr.mdq.ui.xzlxxyb;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.sdjr.mdq.R;
import com.sdjr.mdq.ui.xzlx.XZLXActivity;

public class XZLXXYB2Activity extends AppCompatActivity {
    private ImageView xzlxxybimg01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_xzlxxyb2);
        xzlxxybimg01 = (ImageView) findViewById(R.id.xzlxxyb_img01);

        initView();
    }

    public void initView(){
        xzlxxybimg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XZLXXYB2Activity.this.finish();
            }
        });
    }
}
