package com.sdjr.mdq.ui.qyxx;

import android.Manifest;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.sdjr.mdq.R;
import com.sdjr.mdq.bean.QYXX2Bean;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LXRActivity extends AppCompatActivity implements LRXContract.View {
    @Bind(R.id.lxr_text)
    TextView lxrText;
    @Bind(R.id.lxr_img01)
    ImageView lxrImg01;
    private ListView contactsView;
    private LXRAdapter adapter;
    public static String name;
    public static String tel;
    private static final int REQUEST_CODE_SETTING = 101;

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
        setContentView(R.layout.activity_lxr);
        ButterKnife.bind(this);
        if (AndPermission.hasPermission(this, Manifest.permission.WRITE_CONTACTS, Manifest.permission.READ_CONTACTS)) {
        } else {
            AndPermission.with(this)
                    .requestCode(102)
                    .permission(Manifest.permission.WRITE_CONTACTS, Manifest.permission.READ_CONTACTS)
                    .send();
        }
        LXR2.LXR(this);
        contactsView = (ListView) findViewById(R.id.contacts_view);
        if (LXR2.list.size() != 0) {
            lxrText.setVisibility(View.GONE);
            adapter = new LXRAdapter(this, LXR2.list);
            contactsView.setAdapter(adapter);
            JSONArray jsonArray = new JSONArray();
            JSONObject tmpObj = null;
            int count = LXR2.list.size();
            for (int i = 0; i < count; i++) {
                tmpObj = new JSONObject();
                try {
                    tmpObj.put("phonename", LXR2.list.get(i).getName());
                    tmpObj.put("tel", LXR2.list.get(i).getNumber());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jsonArray.put(tmpObj);
                tmpObj = null;
            }
            String data = jsonArray.toString(); // 将JSONArray转换得到String

            LXRPresreter presreter = new LXRPresreter(this, data);
            presreter.getData();
            contactsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    name = LXR2.list.get(i).getName();
                    tel = LXR2.list.get(i).getNumber();
                    LXRActivity.this.finish();
                }
            });
        } else {
            lxrText.setVisibility(View.VISIBLE);
        }
        lxrImg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LXRActivity.this.finish();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        AndPermission.onRequestPermissionsResult(requestCode, permissions, grantResults, listener);
    }

    private PermissionListener listener = new PermissionListener() {
        @Override
        public void onSucceed(int requestCode, List<String> grantPermissions) {
            // 权限申请成功回调。
            if (requestCode == 100) {

            } else if (requestCode == 101) {

            }
        }

        @Override
        public void onFailed(int requestCode, List<String> deniedPermissions) {
            // 权限申请失败回调。
            // 用户否勾选了不再提示并且拒绝了权限，那么提示用户到设置中授权。
            if (AndPermission.hasAlwaysDeniedPermission(LXRActivity.this, deniedPermissions)) {
                // 用默认的提示语。
//                AndPermission.defaultSettingDialog(LXRActivity.this, REQUEST_CODE_SETTING).show();
//                AndPermission.defaultSettingDialog(LXRActivity.this, REQUEST_CODE_SETTING).show();
            }
        }
    };

    @Override
    public void onResponse(QYXX2Bean qyxx2Bean) {

    }

    @Override
    public void onFailure(String s) {

    }
}
