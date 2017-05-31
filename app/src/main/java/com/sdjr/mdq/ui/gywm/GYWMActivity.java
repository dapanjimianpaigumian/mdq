package com.sdjr.mdq.ui.gywm;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.sdjr.mdq.R;
import com.sdjr.mdq.config.UrlConfig;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GYWMActivity extends AppCompatActivity {
    @Bind(R.id.gywm_text)
    TextView gywmText;
    private ImageView gywmimg01;
    WebView mWebview;
    WebSettings mWebSettings;

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
        setContentView(R.layout.activity_gywm);
        ButterKnife.bind(this);
        gywmimg01 = (ImageView) findViewById(R.id.gywm_img01);
        mWebview = (WebView) findViewById(R.id.webview);
        mWebSettings = mWebview.getSettings();
        if (UrlConfig.web == 1) {
            gywmText.setText("常见问题");
            Bundle bundle = getIntent().getExtras();
            String Url = bundle.getString("URL");
            mWebview.loadUrl(Url);
            UrlConfig.web = 0;
        } else if (UrlConfig.web == 0){
            gywmText.setText("关于我们");
            mWebview.loadUrl(UrlConfig.webview + 25);
        }else if (UrlConfig.web == 2){
            Bundle bundle = getIntent().getExtras();
            String name = bundle.getString("name");
            int id = bundle.getInt("id");
            gywmText.setText(name);
            mWebview.loadUrl(UrlConfig.webview + id);
        }
        Log.i("asd", "onCreate: ============="+UrlConfig.web);

        //设置不用系统浏览器打开,直接显示在当前Webview
        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        initView();
    }

    //点击返回上一页面而不是退出浏览器
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebview.canGoBack()) {
            mWebview.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    //销毁Webview
    @Override
    protected void onDestroy() {
        if (mWebview != null) {
            mWebview.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWebview.clearHistory();

            ((ViewGroup) mWebview.getParent()).removeView(mWebview);
            mWebview.destroy();
            mWebview = null;
        }
        super.onDestroy();
    }

    public void initView() {
        gywmimg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GYWMActivity.this.finish();
            }
        });
    }
}

