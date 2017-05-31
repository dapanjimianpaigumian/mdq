package com.sdjr.mdq.ui.jkgl;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.sdjr.mdq.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JKGLActivity extends AppCompatActivity {

    @Bind(R.id.jkgl_btn)
    Button jkglBtn;
    @Bind(R.id.jkgl_img01)
    ImageView jkglImg01;

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
        setContentView(R.layout.activity_jkgl);
        ButterKnife.bind(this);
        jkglImg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JKGLActivity.this.finish();
            }
        });
    }

    @OnClick(R.id.jkgl_btn)
    public void onViewClicked() {
        JKGLActivity.this.finish();
    }
}
