package com.sdjr.mdq.ui.tbrz;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sdjr.mdq.R;
import com.sdjr.mdq.bean.DTBDBean;
import com.sdjr.mdq.bean.TBRZ2Bean;
import com.sdjr.mdq.bean.TBRZBean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.ui.jdrz.JDRZActivity;
import com.sdjr.mdq.ui.sfrz.SFRZActivity;
import com.sdjr.mdq.ui.sqjk.DTBDContract;
import com.sdjr.mdq.ui.sqjk.DTBDPresreter;
import com.sdjr.mdq.ui.xlrz.XLRZActivity;
import com.sdjr.mdq.ui.xykrz.XYKRZActivity;
import com.sdjr.mdq.ui.xzlx.XZLXActivity;
import com.sdjr.mdq.ui.yhrz.YHRZActivity;
import com.sdjr.mdq.ui.yys.YYSActivity;
import com.sdjr.mdq.ui.zm.ZMFActivity;
import com.sdjr.mdq.widget.LoadingDialog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class TBRZActivity extends AppCompatActivity implements TBRZContract.View ,DTBDContract.View{
    private ImageView tbrzText1;
    private ImageView tbrzImg1;
    private ImageView tbrzimg01;
    private boolean text = false;
    private String params,token;
    private int stat;
    private Context context;
    private Bitmap bitmap;
    private LoadingDialog loadingDialog;
    private Context activity;
    private Button tbrzbtn;

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
        setContentView(R.layout.activity_tbrz);
        tbrzText1 = (ImageView) findViewById(R.id.tbrz_text1);
        tbrzImg1 = (ImageView) findViewById(R.id.tbrz_img1);
        tbrzbtn = (Button) findViewById(R.id.tbrz_btn);
        loadingDialog = new LoadingDialog(this);
        tbrzimg01 = (ImageView) findViewById(R.id.tbrz_img01);
        initView();
        context = getApplicationContext();
        TBRZPresreter presreter = new TBRZPresreter(this,params,token);
        presreter.getData();
    }

    public void initView() {
        tbrzbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TBRZPresreter presreter = new TBRZPresreter(TBRZActivity.this, params, token);
                presreter.getData2();
            }
        });
        tbrzText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TBRZActivity.this,TBRZ2Activity.class);
                startActivity(intent);
            }
        });
        tbrzimg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TBRZActivity.this.finish();
            }
        });
        tbrzImg1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                saveImageToGallery(context,bitmap);
                return false;
            }
        });
        tbrzImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingDialog.show();
                TBRZPresreter presreter = new TBRZPresreter(TBRZActivity.this,params,token);
                presreter.getData();
            }
        });
    }

    public static boolean checkPackage(Context context ,String packageName)
    {
         if (packageName == null || "".equals(packageName))
         return false;
         try{
         context.getPackageManager().getApplicationInfo(packageName, PackageManager.GET_UNINSTALLED_PACKAGES );
         return true;
         }catch (PackageManager.NameNotFoundException e){
         return false;
         }
    }
    private void openTaobaoShopping() {
         if (checkPackage(this, "com.taobao.taobao")) {
             Intent intent = new Intent();
             intent.setAction("android.intent.action.VIEW");
//            https://detail.tmall.com/item.htm?id=535823983028&spm=a21bo.7932663.item.2.0mvUrk&scm=1007.13596.65361.100200300000014
             String url = "taobao://www.taobao.com";
             Uri uri = Uri.parse(url);
             intent.setData(uri);
             startActivity(intent);
             } else {
             //处理没有安装淘宝的情况
             new AlertDialog.Builder(this)
                     .setMessage("是否下载并安装淘宝完成认证?")
                     .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             Intent action = new Intent(Intent.ACTION_VIEW);
                             action.setData(Uri.parse("com.taobao.taobao"));
                             startActivity(action);
                         }
                     }).setNegativeButton("算了", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     dialog.dismiss();
                 }
             }).show();
             }
          }
    @Override
    public void onResponse(TBRZBean tbrzBean) {
        params = tbrzBean.getParams();
        token = tbrzBean.getToken();
        TBRZPresreter presreter = new TBRZPresreter(this, params, token);
        presreter.getData2();
    }

    @Override
    public void onResponse2(TBRZ2Bean tbrz2Bean) {
        stat = tbrz2Bean.getStat();
        if (tbrz2Bean.getStat() == 3) {
            TBRZPresreter presreter = new TBRZPresreter(this, params, token);
            presreter.getData2();
        }else if (tbrz2Bean.getStat()==1){
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            String strInput=tbrz2Bean.getValue();
            byte[] bytes = Base64.decode(strInput, Base64.DEFAULT);
            bitmap =  BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            tbrzImg1.setImageBitmap(bitmap);
        }else if (tbrz2Bean.getStat()==4){
            TBRZPresreter presreter = new TBRZPresreter(this, params, token);
            presreter.getData2();
        }else if (tbrz2Bean.getStat() == 2){
            Toast.makeText(this, "恭喜您，认证成功", Toast.LENGTH_SHORT).show();
            DTBDPresreter presreter = new DTBDPresreter(TBRZActivity.this,activity);
            presreter.getData();
        }
    }

    @Override
    public void onResponse(DTBDBean dtbdBean) {
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
        UrlConfig.start = Integer.parseInt(dtbdBean.getInfo());
        switch (UrlConfig.start){
            case 1:
                Intent intent = new Intent(this, XZLXActivity.class);
                TBRZActivity.this.finish();
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, SFRZActivity.class);
                TBRZActivity.this.finish();
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(this, ZMFActivity.class);
                TBRZActivity.this.finish();
                startActivity(intent);
                break;
            case 4:

                intent = new Intent(this, YYSActivity.class);
                TBRZActivity.this.finish();
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(this, TBRZActivity.class);
                TBRZActivity.this.finish();
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(this, JDRZActivity.class);
                TBRZActivity.this.finish();
                startActivity(intent);
                break;
            case 7:
                intent = new Intent(this, XLRZActivity.class);
                TBRZActivity.this.finish();
                startActivity(intent);
                break;
            case 8:
                intent = new Intent(this, YHRZActivity.class);
                TBRZActivity.this.finish();
                startActivity(intent);
                break;
            case 9:
                intent = new Intent(this, XYKRZActivity.class);
                TBRZActivity.this.finish();
                startActivity(intent);
                break;
            case 10:
                Toast.makeText(this, "您的基本认证已完成", Toast.LENGTH_SHORT).show();
                TBRZActivity.this.finish();
                break;
        }
    }

    @Override
    public void onFailure(String s) {

    }

    public void saveImageToGallery(Context context, Bitmap bmp) {
        if (bmp == null){
            Toast.makeText(context, "保存出错了1...", Toast.LENGTH_SHORT).show();
            return;
        }
        // 首先保存图片
        File appDir = new File(Environment.getExternalStorageDirectory(), "/DCIM");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            Toast.makeText(context, "文件未发现", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(context, "保存出错了2...", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }catch (Exception e){
            Toast.makeText(context, "保存出错了3...", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        // 最后通知图库更新
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri uri = Uri.fromFile(file);
        intent.setData(uri);
        context.sendBroadcast(intent);
        openTaobaoShopping();
    }
}
