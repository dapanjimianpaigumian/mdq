package com.sdjr.mdq.bean;

/**
 * Created by 昇盾 on 2017/5/13.
 */

public class ZM2bean {

    /**
     * stat : 0
     * msg : 身份证号码或姓名不正确，请确认后重新提交
     */

    private int stat;
    private String msg;

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
