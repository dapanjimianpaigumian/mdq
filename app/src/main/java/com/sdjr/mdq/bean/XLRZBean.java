package com.sdjr.mdq.bean;

/**
 * Created by user on 2017/5/10.
 */

public class XLRZBean {

    /**
     * stat : 1
     * msg : 写入成功
     * info : {"params":"method=api.common.getStatus&apiKey=3104028489553430&token=0c180e1784b24a3fb30f8e71ab629e38&version=1.0.0&sign=a89a873c7d5206112fb0d0ee60e6cbca81b1788d","token":"0c180e1784b24a3fb30f8e71ab629e38"}
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
         * params : method=api.common.getStatus&apiKey=3104028489553430&token=0c180e1784b24a3fb30f8e71ab629e38&version=1.0.0&sign=a89a873c7d5206112fb0d0ee60e6cbca81b1788d
         * token : 0c180e1784b24a3fb30f8e71ab629e38
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
