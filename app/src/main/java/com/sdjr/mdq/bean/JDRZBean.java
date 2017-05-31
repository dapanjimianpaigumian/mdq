package com.sdjr.mdq.bean;

/**
 * Created by user on 2017/5/10.
 */

public class JDRZBean {

    /**
     * stat : 1
     * msg : 写入成功
     * info : {"params":"method=api.common.getStatus&token=52cb3b300b6f46fda002258a398782b4&bizType=jd&apiKey=3104028489553430&version=1.2.0&sign=1d8f4c174695631dbeb3d6c6b5538802562d7859","token":"52cb3b300b6f46fda002258a398782b4"}
     */

    private String stat;
    private String msg;
    private InfoBean info;

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

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public static class InfoBean {
        /**
         * params : method=api.common.getStatus&token=52cb3b300b6f46fda002258a398782b4&bizType=jd&apiKey=3104028489553430&version=1.2.0&sign=1d8f4c174695631dbeb3d6c6b5538802562d7859
         * token : 52cb3b300b6f46fda002258a398782b4
         */

        private String params;
        private String token;

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
    }
}
