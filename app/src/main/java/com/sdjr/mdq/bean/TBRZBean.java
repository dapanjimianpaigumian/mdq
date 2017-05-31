package com.sdjr.mdq.bean;

/**
 * Created by 昇盾 on 2017/5/13.
 */

public class TBRZBean {

    /**
     * stat : 1
     * params : method=api.common.getStatus&token=56d015dc483f44a2a1a1f206817caed0&bizType=taobao&apiKey=3104028489553430&version=1.2.0&sign=48aabe20023804394609e1ad09490f0ae3f28560
     * token : 56d015dc483f44a2a1a1f206817caed0
     * msg :
     */

    private int stat;
    private String params;
    private String token;
    private String msg;

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
