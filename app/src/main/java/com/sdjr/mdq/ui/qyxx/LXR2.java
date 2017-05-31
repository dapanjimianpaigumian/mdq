package com.sdjr.mdq.ui.qyxx;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.yanzhenjie.permission.AndPermission;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017/5/10.
 */

public class LXR2 {
    public static List<PhoneInfo> list = new ArrayList<>();

    public static String LXR(Context context){
        list.clear();
        Cursor cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        String phoneNumber;
        String phoneName;
        if (cursor!=null){
            while (cursor.moveToNext()){
                phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                phoneName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                PhoneInfo phoneInfo = new PhoneInfo(phoneName,phoneNumber);
                list.add(phoneInfo);
            }
        }
        return null;
    }
}
