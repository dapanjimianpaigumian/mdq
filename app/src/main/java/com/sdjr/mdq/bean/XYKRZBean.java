package com.sdjr.mdq.bean;

/**
 * Created by user on 2017/5/10.
 */

public class XYKRZBean {

    /**
     * stat : 1
     * msg : 写入成功
     * info : {"params":"method=api.common.getStatus&token=c6a09206d0a145f396a410e337ab8424&apiKey=3104028489553430&version=1.0.0&sign=d3ed1b5b3314ed23ca2ea8aac0647f03fefe5753","token":"c6a09206d0a145f396a410e337ab8424"}
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
         * params : method=api.common.getStatus&token=c6a09206d0a145f396a410e337ab8424&apiKey=3104028489553430&version=1.0.0&sign=d3ed1b5b3314ed23ca2ea8aac0647f03fefe5753
         * token : c6a09206d0a145f396a410e337ab8424
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
