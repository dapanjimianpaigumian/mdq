package com.sdjr.mdq.bean;

/**
 * Created by user on 2017/5/10.
 */

public class ZYGWBean {

    /**
     * stat : 1
     * msg : 获取成功
     * info : {"sum":"3291","qq":"800806068"}
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
         * sum : 3291
         * qq : 800806068
         */

        private String sum;
        private String qq;

        public String getSum() {
            return sum;
        }

        public void setSum(String sum) {
            this.sum = sum;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }
    }
}
