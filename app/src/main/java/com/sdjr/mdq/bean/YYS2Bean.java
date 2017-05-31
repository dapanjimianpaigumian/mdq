package com.sdjr.mdq.bean;

/**
 * Created by 昇盾 on 2017/5/12.
 */

public class YYS2Bean {

    /**
     * stat : 1
     * msg : 请输入短信验证码
     * info : {"url":null,"token":"4cb3bd9ba66942d5988c551d12d1bb6c"}
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
         * url : null
         * token : 4cb3bd9ba66942d5988c551d12d1bb6c
         */

        private Object url;
        private String token;

        public Object getUrl() {
            return url;
        }

        public void setUrl(Object url) {
            this.url = url;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
