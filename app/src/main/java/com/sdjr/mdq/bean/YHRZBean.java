package com.sdjr.mdq.bean;

/**
 * Created by user on 2017/5/10.
 */

public class YHRZBean {

    /**
     * stat : 1
     * msg : 写入成功
     * info : {"params":"method=api.common.getStatus&token=06c42687b8254635bcfe1fbb3aecad93&apiKey=3104028489553430&version=1.0.0&sign=c7c9096e6ce4991b1d2d0b90b863e7adc6ca8511","token":"06c42687b8254635bcfe1fbb3aecad93"}
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
         * params : method=api.common.getStatus&token=06c42687b8254635bcfe1fbb3aecad93&apiKey=3104028489553430&version=1.0.0&sign=c7c9096e6ce4991b1d2d0b90b863e7adc6ca8511
         * token : 06c42687b8254635bcfe1fbb3aecad93
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
