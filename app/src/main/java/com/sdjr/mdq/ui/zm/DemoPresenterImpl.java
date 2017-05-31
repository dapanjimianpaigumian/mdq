package com.sdjr.mdq.ui.zm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.moblie.zmxy.antgroup.creditsdk.app.ICreditListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by befairyliu on 16/1/30.
 */
public class DemoPresenterImpl implements DemoPresenter {

    private static final String TAG = "ZHIMA_DemoPresenterImpl";
    private DemoView demoView;
    private Activity activity;
    public static int zmf = 0;

    public DemoPresenterImpl(Activity activity, DemoView demoView) {
        this.activity = activity;
        this.demoView = demoView;

    }

    @Override
    public void doCreditRequest() {
        //测试数据，此部分数据，请由商户服务端生成下发，具体见开放平台商户对接文档
        //请注意params、sign为encode过后的数据
        //String params = "ApO88WwMflzmDXYX1aTdnz0L3%2FUF8kHXtd5GF1tFJKzDSo2tmOcRmaoDYGiSNUpVyx4jqWl2HgM30v0hOXNDUlKA5ZGrExYmT5qMPbtplGFHpJe4k%2ByZHHIz6CJFuYcq8b2fGMg%2FXAH0Hq2XV2Yhu9ZOahx5W8ryJPnBh8kt1ks%3D";
        //String appId = "1000100";
        //String sign = "XusqllQQjawQPF2pmFelPuWrS6zLwLpTzKG5HoSNDyYEshqdjjs1MgOAL7LP8RHceCLu5PPh5SbKAM0ghtR5e%2FvA25eeOY1V4WAVtQq%2FGer197sUNzJsXONAgGAT1ukwJ%2FTIGew384iqRXIf4nV%2BcUjCmlWTC7NXkwKgBE%2FrNdo%3D";
        String params = ZMFActivity.params;
        String appId = "1002224";
        String sign = ZMFActivity.sign;
        //extParams参数可以放置一些额外的参数，例如当biz_params参数忘记组织auth_code参数时，可以通过extParams参数带入auth_code。
        //不过建议auth_code参数组织到biz_params里面进行加密加签。
        Map<String, String> extParams = new HashMap<>();
        //extParams.put("auth_code", "M_FACE");

        try {
            //请求授权
            CreditAuthHelper.creditAuth(activity, appId, params, sign, extParams, new ICreditListener() {
                @Override
                public void onComplete(Bundle result) {
                    //toast message
                    demoView.toastMessage("授权成功");
                    //从result中获取params参数,然后解析params数据,可以获取open_id。
                    if (result != null) {
                        Set<String> keys = result.keySet();
                        for (String key : keys) {
                            Log.d(TAG, key + " = " + result.getString(key));
                        }
                    }
                    zmf = 2;
                    Intent intent = new Intent(activity,ZMFActivity.class);
                    activity.startActivity(intent);
                }

                @Override
                public void onError(Bundle result) {
                    //toast message
                    demoView.toastMessage("授权错误");
                    Log.d(TAG, "DemoPresenterImpl.doCreditAuthRequest.onError.");
                }


                @Override
                public void onCancel() {
                    //toast message
                    demoView.toastMessage("授权失败");
                    Log.d(TAG, "DemoPresenterImpl.doCreditAuthRequest.onCancel.");
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "DemoPresenterImpl.doCreditAuthRequest.exception=" + e.toString());
        }
    }
}
