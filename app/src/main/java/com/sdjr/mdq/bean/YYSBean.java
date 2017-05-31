package com.sdjr.mdq.bean;

/**
 * Created by user on 2017/5/10.
 */

public class YYSBean {

    /**
     * stat : 1
     * msg : 写入成功
     * info : {"params":"method=api.common.getStatus&token=e15d6170a5cb48fca988bdf4d984f842&bizType=mobile&apiKey=3104028489553430&version=1.2.0&sign=85ef23d5a7e7c7a8ae50ff89b738ea7c77fa71a5","token":"e15d6170a5cb48fca988bdf4d984f842"}
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
         * params : method=api.common.getStatus&token=e15d6170a5cb48fca988bdf4d984f842&bizType=mobile&apiKey=3104028489553430&version=1.2.0&sign=85ef23d5a7e7c7a8ae50ff89b738ea7c77fa71a5
         * token : e15d6170a5cb48fca988bdf4d984f842
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
