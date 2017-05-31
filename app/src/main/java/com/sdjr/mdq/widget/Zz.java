package com.sdjr.mdq.widget;

import android.text.TextUtils;

/**
 * Created by user on 2017/4/17.
 */

public class Zz {

//    验证用户密码："^[a-zA-Z]\w{5,17}$"正确格式为：以字母开头，长度在6~18之间，只能包含字符、数字和下划线。
//    验证是否含有^%&',;=?$\"等字符："[^%&',;=?$\x22]+"。
//    只能输入汉字："^[\u4e00-\u9fa5]{0,}$"
//    验证Email地址："^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$"。
//    验证InternetURL："^http://([\w-]+\.)+[\w-]+(/[\w-./?%&=]*)?$"。
//    验证电话号码："^(\(\d{3,4}-)|\d{3.4}-)?\d{7,8}$"正确格式为："XXX-XXXXXXX"、"XXXX-XXXXXXXX"、"XXX-XXXXXXX"、"XXX-XXXXXXXX"、"XXXXXXX"和"XXXXXXXX"。
//    验证身份证号（15位或18位数字）："^\d{15}|\d{18}$"。
//    验证一年的12个月："^(0?[1-9]|1[0-2])$"正确格式为："01"～"09"和"1"～"12"。
//    验证一个月的31天："^((0?[1-9])|((1|2)[0-9])|30|31)$"正确格式为；"01"～"09"和"1"～"31"。
   /**
     * 验证手机格式
   */
   public static boolean isMobileNO(String mobiles) {
            /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9

    ------------------------------------------------
    13(老)号段：130、131、132、133、134、135、136、137、138、139
    14(新)号段：145、147
    15(新)号段：150、151、152、153、154、155、156、157、158、159
    17(新)号段：170、171、173、175、176、177、178
    18(3G)号段：180、181、182、183、184、185、186、187、188、189
        */
    String telRegex = "[1][34578]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、4、5、7、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
    if (TextUtils.isEmpty(mobiles)) return false;
    else return mobiles.matches(telRegex);
   }

    /**
     * 验证是否为汉字
     */
    public static boolean isUsName(String mobiles) {
        String telRegex = "^[\u4e00-\u9fa5]{0,}$";
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }

    /**
     * 验证是否为汉字
     */
    public static boolean isEmail(String mobiles) {
        String telRegex = "^^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }

    /**
     * 验证是否为汉字
     */
    public static boolean isSFZ(String mobiles) {
        String telRegex = "^(\\d{14}|\\d{17})(\\d|[xX])$";
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }
}
