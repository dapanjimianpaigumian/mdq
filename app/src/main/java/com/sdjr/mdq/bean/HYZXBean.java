package com.sdjr.mdq.bean;

/**
 * Created by user on 2017/5/10.
 */

public class HYZXBean {

    /**
     * stat : 1
     * msg : 会员用户信息
     * info : {"phone":"13653582497","type":"未完善信息","headimgurl":""}
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
         * phone : 13653582497
         * type : 未完善信息
         * headimgurl :
         */

        private String phone;
        private String type;
        private String headimgurl;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getHeadimgurl() {
            return headimgurl;
        }

        public void setHeadimgurl(String headimgurl) {
            this.headimgurl = headimgurl;
        }
    }
}
