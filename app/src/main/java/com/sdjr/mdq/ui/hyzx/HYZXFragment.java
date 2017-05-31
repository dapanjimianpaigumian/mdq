package com.sdjr.mdq.ui.hyzx;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.sdjr.mdq.R;
import com.sdjr.mdq.bean.HYZXBean;
import com.sdjr.mdq.config.UrlConfig;
import com.sdjr.mdq.ui.cjwt.CJWTActivity;
import com.sdjr.mdq.ui.gywm.GYWMActivity;
import com.sdjr.mdq.ui.login.LoginActivity;
import com.sdjr.mdq.ui.sz.SZActivity;
import com.sdjr.mdq.ui.xxzx.XXZXActivity;
import com.sdjr.mdq.widget.SelectPicturePopup;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class HYZXFragment extends Fragment implements HYZXContract.View {
    @Bind(R.id.hyzx_cjwt)
    RelativeLayout hyzxCjwt;
    //    @Bind(R.id.hyzx_sz)
//    RelativeLayout hyzxSz;
    @Bind(R.id.hyzx_xxzx)
    RelativeLayout hyzxXxzx;
    @Bind(R.id.hyzx_gywm)
    RelativeLayout hyzxGywm;
    @Bind(R.id.hyzx_tx_img)
    SimpleDraweeView hyzxTxImg;
    @Bind(R.id.hyzx_lin)
    LinearLayout hyzxLin;
    @Bind(R.id.hyzx_lin1)
    LinearLayout hyzxLin1;
    @Bind(R.id.hyzx_lin2)
    LinearLayout hyzxLin2;
    @Bind(R.id.hyzx_tx_img1)
    SimpleDraweeView hyzxTxImg1;
    @Bind(R.id.hyzx_meiy_text1)
    TextView hyzxMeiyText1;
    @Bind(R.id.hyzx_tx_text)
    TextView hyzxTxText;
    @Bind(R.id.hyzx_sz)
    TextView hyzxSz;
    @Bind(R.id.hyzx_name)
    TextView hyzxName;
    @Bind(R.id.hyzx_text1)
    TextView hyzxText1;
    private Context context;
    private View view;
    private static final int REQUEST_CODE_SETTING = 300;
    public static final int REQUEST_CODE_PICTURE = 1;
    public static final int REQUEST_CODE_CAMERA = 2;
    public static final int aa = 3;
    private String picturePath;
    private Uri imageUri;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        Fresco.initialize(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_hyzx, container, false);
        ButterKnife.bind(this, view);
        if (UrlConfig.login == 0) {
            hyzxLin1.setVisibility(View.VISIBLE);
            hyzxLin2.setVisibility(View.GONE);
        } else if (UrlConfig.login != 0) {
            hyzxLin1.setVisibility(View.GONE);
            hyzxLin2.setVisibility(View.VISIBLE);
            HYZXPresreter presreter = new HYZXPresreter(this);
            presreter.getData();
        }
        hyzxLin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
            }
        });
        hyzxSz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UrlConfig.login == 0) {
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(context, SZActivity.class);
                    startActivity(intent);
                }
            }
        });
        hyzxXxzx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UrlConfig.login == 0) {
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(context, XXZXActivity.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (UrlConfig.login == 0) {
            hyzxLin1.setVisibility(View.VISIBLE);
            hyzxLin2.setVisibility(View.GONE);
        } else if (UrlConfig.login != 0) {
            hyzxLin1.setVisibility(View.GONE);
            hyzxLin2.setVisibility(View.VISIBLE);
            HYZXPresreter presreter = new HYZXPresreter(this);
            presreter.getData();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.hyzx_cjwt, R.id.hyzx_xxzx, R.id.hyzx_gywm, R.id.hyzx_tx_img})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hyzx_cjwt:
                Intent intent = new Intent(context, CJWTActivity.class);
                startActivity(intent);
                break;
//            case R.id.hyzx_sz:
//                if (UrlConfig.login == 0) {
//                    intent = new Intent(context, LoginActivity.class);
//                    startActivity(intent);
//                } else if (UrlConfig.login == 1) {
//                    intent = new Intent(context, SZActivity.class);
//                    startActivity(intent);
//                }
//                break;
            case R.id.hyzx_xxzx:
                if (UrlConfig.login == 0) {
                    intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                } else if (UrlConfig.login == 1) {
                    intent = new Intent(context, XXZXActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.hyzx_gywm:
                intent = new Intent(context, GYWMActivity.class);
                startActivity(intent);
                break;
            case R.id.hyzx_tx_img:
                if (AndPermission.hasPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)) {

                } else {
                    AndPermission.with(this)
                            .requestCode(101)
                            .permission(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
                            .send();
                }
                final SelectPicturePopup spp = new SelectPicturePopup(context);
                spp.showPopup(hyzxLin);
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
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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
                        Bitmap bitmap = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(imageUri));
                        DraweeController failureImageDraweeController = Fresco.newDraweeControllerBuilder()
                                .setUri(imageUri)
                                .setTapToRetryEnabled(false)  //同时设置不可重试.
                                .setOldController(hyzxTxImg.getController())
                                .build();
                        hyzxTxImg.setController(failureImageDraweeController);
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
    }

    private void setPic(String path) {
        imageUri = Uri.parse(path);
        DraweeController failureImageDraweeController = Fresco.newDraweeControllerBuilder()
                .setUri(imageUri)
                .setTapToRetryEnabled(false)  //同时设置不可重试.
                .setOldController(hyzxTxImg.getController())
                .build();
        hyzxTxImg.setController(failureImageDraweeController);
        Glide.with(this).load(new File(path)).into(hyzxTxImg);
    }

    private void sendPicByUri(Uri selectedImage) {
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(selectedImage,
                filePathColumn, null, null, null);
        String st8 = "未能找到任何图片";
        if (cursor != null) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();
            cursor = null;
            if (picturePath == null || picturePath.equals("null")) {
                Toast toast = Toast.makeText(context, st8, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
            setPic(picturePath);
        } else {
            File file = new File(selectedImage.getPath());
            if (!file.exists()) {
                Toast toast = Toast.makeText(context, st8, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
            setPic(file.getAbsolutePath());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        AndPermission.onRequestPermissionsResult(requestCode, permissions, grantResults, listener);
    }

    private PermissionListener listener = new PermissionListener() {
        @Override
        public void onSucceed(int requestCode, List<String> grantedPermissions) {
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
            if (AndPermission.hasAlwaysDeniedPermission(HYZXFragment.this, deniedPermissions)) {
                // 用默认的提示语。
                AndPermission.defaultSettingDialog(HYZXFragment.this, REQUEST_CODE_SETTING).show();

            }
        }
    };

    @Override
    public void onResponse(HYZXBean hyzxBean) {
        if (hyzxBean.getInfo()!=null){
            hyzxName.setText(hyzxBean.getInfo().getPhone());
            hyzxText1.setText(hyzxBean.getInfo().getType());
        }
    }

    @Override
    public void onFailure(String s) {

    }
}
