package com.sdjr.mdq.ui.sfrz2;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sdjr.mdq.R;
import com.sdjr.mdq.bean.SFRZ2Bean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.widget.LoadingDialog;
import com.sdjr.mdq.widget.MyBottomDialog;
import com.sdjr.mdq.widget.SelectPicturePopup;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SFRZ2Activity extends AppCompatActivity implements SFRZ2Contract.View {
    @Bind(R.id.sfrz2_img1)
    ImageView sfrz2Img1;
    @Bind(R.id.sfrz2_img2)
    ImageView sfrz2Img2;
    @Bind(R.id.sfrz2_text2)
    TextView sfrz2Text2;
    @Bind(R.id.sfrz2_img3)
    ImageView sfrz2Img3;
    @Bind(R.id.sfrz2_text3)
    TextView sfrz2Text3;
    @Bind(R.id.sfrz2_scro)
    LinearLayout sfrz2Scro;
    @Bind(R.id.sfrz2_img11)
    ImageView sfrz2Img11;
    @Bind(R.id.sfrz2_img22)
    ImageView sfrz2Img22;
    @Bind(R.id.sfrz2_img33)
    ImageView sfrz2Img33;
    private ImageView sfrz2img01;
    private static final int REQUEST_CODE_SETTING = 300;
    public static final int REQUEST_CODE_PICTURE = 1;
    public static final int REQUEST_CODE_CAMERA = 2;
    public static final int aa = 3;
    public static final int REQUEST_CODE_PICTURE2 = 21;
    public static final int REQUEST_CODE_CAMERA2 = 22;
    public static final int bb = 23;
    public static final int REQUEST_CODE_PICTURE3 = 31;
    public static final int REQUEST_CODE_CAMERA3 = 32;
    public static final int cc = 33;
    private String picturePath;
    private String picturePath2;
    private String picturePath3;
    private Uri imageUri;
    private Uri imageUri2;
    private Uri imageUri3;
    private File w1, w2, w3;
    private LoadingDialog loadingDialog;
    private Button sfrz2Btn;

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
        setContentView(R.layout.activity_sfrz2);
        ButterKnife.bind(this);
        loadingDialog = new LoadingDialog(this);
        sfrz2img01 = (ImageView) findViewById(R.id.sfrz2_img01);
        sfrz2Btn = (Button) findViewById(R.id.sfrz2_btn);
        initView();
        //继承Dialog来实现底部弹出Dialog
        findViewById(R.id.sfrz2_text1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UrlConfig.SCTP_DIALOG = 1;
                MyBottomDialog dialog = new MyBottomDialog(SFRZ2Activity.this);
                dialog.show();
            }
        });
    }

    public void initView() {
        sfrz2img01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SFRZ2Activity.this.finish();
            }
        });
        sfrz2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
//            loadingDialog.show();
            w2 = new File(picturePath2);
            w3 = new File(picturePath3);
            w1 = new File(picturePath);

            Bitmap bitmap = tpys(picturePath);
            try {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(w1));
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
                bos.flush();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Bitmap bitmap2 = tpys(picturePath2);
            try {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(w2));
                bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, bos);
                bos.flush();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Bitmap bitmap3 = tpys(picturePath3);
            try {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(w3));
                bitmap3.compress(Bitmap.CompressFormat.JPEG, 100, bos);
                bos.flush();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            loadingDialog.show();
            SFRZ2Presreter presreter = new SFRZ2Presreter(this, w1, w2, w3);
            presreter.getData();
        }
    }

    public Bitmap tpys(String string){
        BitmapFactory.Options newOpts = new
                BitmapFactory.Options();
        // 开始读入图片，此时把options.inJustDecodeBounds 设回true了
        newOpts.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(string, newOpts);// 此时返回bm为空

        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        // 现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
        float hh = 800f;// 这里设置高度为800f
        float ww = 480f;// 这里设置宽度为480f
        // 缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;// be=1表示不缩放
        if (w > h && w > ww) {// 如果宽度大的话根据宽度固定大小缩放
            be = (int) (newOpts.outWidth / ww);
        } else if (w < h && h > hh) {// 如果高度高的话根据宽度固定大小缩放
            be = (int) (newOpts.outHeight / hh);
        }
        if (be <= 0)
            be = 1;
        newOpts.inSampleSize = be;// 设置缩放比例
        // 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        bitmap = BitmapFactory.decodeFile(string, newOpts);
        return bitmap;
    }

    public boolean isUserNameAndPwdValid() {
        if (picturePath == null) {
            Toast.makeText(SFRZ2Activity.this, "请上传身份证正面",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (picturePath2 == null) {
            Toast.makeText(SFRZ2Activity.this, "请上传身份证反面",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (picturePath3 == null) {
            Toast.makeText(SFRZ2Activity.this, "请上传手持身份证照",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @OnClick({R.id.sfrz2_img1, R.id.sfrz2_img2, R.id.sfrz2_text2, R.id.sfrz2_img3, R.id.sfrz2_text3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sfrz2_img1:
                if (AndPermission.hasPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)) {

                } else {
                    AndPermission.with(this)
                            .requestCode(101)
                            .permission(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
                            .send();
                }
                final SelectPicturePopup spp = new SelectPicturePopup(SFRZ2Activity.this);
                spp.showPopup(sfrz2Scro);
                spp.setOnClickFlagDialogListener(new SelectPicturePopup.OnClickFlagDialogListener() {
                    @Override
                    public void getFlag(int flag) {
                        if (flag == 1) {
                            spp.dismiss();
                            Intent intent;
                            if (Build.VERSION.SDK_INT < 19) {
                                intent = new Intent(Intent.ACTION_GET_CONTENT);
                                intent.setType("image/*");
                            } else {
                                intent = new Intent(
                                        Intent.ACTION_PICK,
                                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            }
                            startActivityForResult(intent, REQUEST_CODE_PICTURE);
                        } else if (flag == 0) {
                            spp.dismiss();
                            File out = new File(Environment.getExternalStorageDirectory(), "otu.jpg");
                            try {
                                if (out.exists()) {
                                    out.delete();
                                }
                                out.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            imageUri = Uri.fromFile(out);
                            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                            startActivityForResult(intent, REQUEST_CODE_CAMERA);//启动相机程序
                        }
                    }
                });
                break;
            case R.id.sfrz2_img2:
                final SelectPicturePopup spp2 = new SelectPicturePopup(SFRZ2Activity.this);
                spp2.showPopup(sfrz2Scro);
                spp2.setOnClickFlagDialogListener(new SelectPicturePopup.OnClickFlagDialogListener() {
                    @Override
                    public void getFlag(int flag) {
                        if (flag == 1) {
                            spp2.dismiss();
                            Intent intent;
                            if (Build.VERSION.SDK_INT < 19) {
                                intent = new Intent(Intent.ACTION_GET_CONTENT);
                                intent.setType("image/*");
                            } else {
                                intent = new Intent(
                                        Intent.ACTION_PICK,
                                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            }
                            startActivityForResult(intent, REQUEST_CODE_PICTURE2);
                        } else if (flag == 0) {
                            spp2.dismiss();
                            File out = new File(Environment.getExternalStorageDirectory(), "otu2.jpg");
                            try {
                                if (out.exists()) {
                                    out.delete();
                                }
                                out.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            imageUri2 = Uri.fromFile(out);
                            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri2);
                            startActivityForResult(intent, REQUEST_CODE_CAMERA2);//启动相机程序
                        }
                    }
                });
                break;
            case R.id.sfrz2_text2:
                UrlConfig.SCTP_DIALOG = 2;
                MyBottomDialog dialog2 = new MyBottomDialog(SFRZ2Activity.this);
                dialog2.show();
                break;
            case R.id.sfrz2_img3:
                final SelectPicturePopup spp3 = new SelectPicturePopup(SFRZ2Activity.this);
                spp3.showPopup(sfrz2Scro);
                spp3.setOnClickFlagDialogListener(new SelectPicturePopup.OnClickFlagDialogListener() {
                    @Override
                    public void getFlag(int flag) {
                        if (flag == 1) {
                            spp3.dismiss();
                            Intent intent;
                            if (Build.VERSION.SDK_INT < 19) {
                                intent = new Intent(Intent.ACTION_GET_CONTENT);
                                intent.setType("image/*");
                            } else {
                                intent = new Intent(
                                        Intent.ACTION_PICK,
                                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            }
                            startActivityForResult(intent, REQUEST_CODE_PICTURE3);
                        } else if (flag == 0) {
                            spp3.dismiss();
                            File out = new File(Environment.getExternalStorageDirectory(), "otu3.jpg");
                            try {
                                if (out.exists()) {
                                    out.delete();
                                }
                                out.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            imageUri3 = Uri.fromFile(out);
                            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri3);
                            startActivityForResult(intent, REQUEST_CODE_CAMERA3);//启动相机程序
                        }
                    }
                });
                break;
            case R.id.sfrz2_text3:
                UrlConfig.SCTP_DIALOG = 3;
                MyBottomDialog dialog3 = new MyBottomDialog(SFRZ2Activity.this);
                dialog3.show();

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_CAMERA:
                if (resultCode == RESULT_OK) {
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri, "image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, aa);//启动裁剪程序
                }
                break;
            case aa:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        sfrz2Img11.setImageBitmap(bitmap);
                        sfrz2Img1.setVisibility(View.GONE);
                        picturePath = imageUri.getPath();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
        if (requestCode == REQUEST_CODE_PICTURE) {
            if (data != null) {
                Uri selectedImage = data.getData();
                if (selectedImage != null) {
                    sendPicByUri(selectedImage);
                }
            }
        }

        switch (requestCode) {
            case REQUEST_CODE_CAMERA2:
                if (resultCode == RESULT_OK) {
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri2, "image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri2);
                    startActivityForResult(intent, bb);//启动裁剪程序
                }
                break;
            case bb:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri2));
                        sfrz2Img22.setImageBitmap(bitmap);
                        sfrz2Img2.setVisibility(View.GONE);
                        picturePath2 = imageUri2.getPath();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
        if (requestCode == REQUEST_CODE_PICTURE3) {
            if (data != null) {
                Uri selectedImage3 = data.getData();
                if (selectedImage3 != null) {
                    sendPicByUri3(selectedImage3);
                }
            }
        }

        switch (requestCode) {
            case REQUEST_CODE_CAMERA3:
                if (resultCode == RESULT_OK) {
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri3, "image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri3);
                    startActivityForResult(intent, cc);//启动裁剪程序
                }
                break;
            case cc:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri3));
                        sfrz2Img33.setImageBitmap(bitmap);
                        sfrz2Img3.setVisibility(View.GONE);
                        picturePath3 = imageUri3.getPath();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
        if (requestCode == REQUEST_CODE_PICTURE2) {
            if (data != null) {
                Uri selectedImage2 = data.getData();
                if (selectedImage2 != null) {
                    sendPicByUri2(selectedImage2);
                }
            }
        }
    }

    private void setPic(String path) {
        sfrz2Img1.setVisibility(View.GONE);
        Glide.with(this).load(new File(path)).into(sfrz2Img11);
    }

    private void setPic2(String path) {
        sfrz2Img2.setVisibility(View.GONE);
        Glide.with(this).load(new File(path)).skipMemoryCache(true).into(sfrz2Img22);
    }

    private void setPic3(String path) {
        sfrz2Img3.setVisibility(View.GONE);
        Glide.with(this).load(new File(path)).into(sfrz2Img33);
    }

    /**
     * 根据图库图片uri发送图片
     *
     * @param selectedImage
     */
    private void sendPicByUri(Uri selectedImage) {
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = this.getContentResolver().query(selectedImage,
                filePathColumn, null, null, null);
        String st8 = "未能找到任何图片";
        if (cursor != null) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();
            cursor = null;
            if (picturePath == null || picturePath.equals("null")) {
                Toast toast = Toast.makeText(this, st8, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
            setPic(picturePath);
        } else {
            File file = new File(selectedImage.getPath());
            if (!file.exists()) {
                Toast toast = Toast.makeText(this, st8, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
            setPic(file.getAbsolutePath());
        }
    }

    private void sendPicByUri2(Uri selectedImage) {
        String[] filePathColumn2 = {MediaStore.Images.Media.DATA};
        Cursor cursor2 = this.getContentResolver().query(selectedImage,
                filePathColumn2, null, null, null);
        String st8 = "未能找到任何图片";
        if (cursor2 != null) {
            cursor2.moveToFirst();
            int columnIndex = cursor2.getColumnIndex(filePathColumn2[0]);
            picturePath2 = cursor2.getString(columnIndex);
            cursor2.close();
            cursor2 = null;
            if (picturePath2 == null || picturePath2.equals("null")) {
                Toast toast = Toast.makeText(this, st8, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
            setPic2(picturePath2);
        } else {
            File file = new File(selectedImage.getPath());
            if (!file.exists()) {
                Toast toast = Toast.makeText(this, st8, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
            setPic2(file.getAbsolutePath());
        }
    }

    private void sendPicByUri3(Uri selectedImage) {
        String[] filePathColumn3 = {MediaStore.Images.Media.DATA};
        Cursor cursor3 = this.getContentResolver().query(selectedImage,
                filePathColumn3, null, null, null);
        String st8 = "未能找到任何图片";
        if (cursor3 != null) {
            cursor3.moveToFirst();
            int columnIndex = cursor3.getColumnIndex(filePathColumn3[0]);
            picturePath3 = cursor3.getString(columnIndex);
            cursor3.close();
            cursor3 = null;
            if (picturePath3 == null || picturePath3.equals("null")) {
                Toast toast = Toast.makeText(this, st8, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
            setPic3(picturePath3);
        } else {
            File file = new File(selectedImage.getPath());
            if (!file.exists()) {
                Toast toast = Toast.makeText(this, st8, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
            setPic3(file.getAbsolutePath());
        }
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
                // TODO 相应代码。
            } else if (requestCode == 101) {
                // TODO 相应代码。
            }
        }

        @Override
        public void onFailed(int requestCode, List<String> deniedPermissions) {
// 权限申请失败回调。
            // 用户否勾选了不再提示并且拒绝了权限，那么提示用户到设置中授权。
            if (AndPermission.hasAlwaysDeniedPermission(SFRZ2Activity.this, deniedPermissions)) {
                // 用默认的提示语。
                AndPermission.defaultSettingDialog(SFRZ2Activity.this, REQUEST_CODE_SETTING).show();

            }
        }
    };

    @Override
    public void onResponse(SFRZ2Bean sfrz2Bean) {
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
        if (sfrz2Bean.getStat().equals("1")){
            SFRZ2Activity.this.finish();
        }else {
            Toast.makeText(this, sfrz2Bean.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(String s) {

    }

}
