package com.sdjr.mdq.bean;

/**
 * Created by 昇盾 on 2017/5/10.
 */

public class WSBean {

    /**
     * stat : 1
     * info : 1111
     * msg : 请求成功
     */

    private String stat;
    private String info;
    private String msg;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
