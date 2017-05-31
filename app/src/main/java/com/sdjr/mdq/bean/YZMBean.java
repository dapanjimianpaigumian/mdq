package com.sdjr.mdq.bean;

/**
 * Created by 昇盾 on 2017/5/2.
 */

public class YZMBean {

    /**
     * stat : 1
     * msg : 短信发送成功，请注意查收
     * info : 667196
     */

    private String stat;
    private String msg;
    private int info;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }
}
