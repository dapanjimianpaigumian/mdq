package com.sdjr.mdq.bean;

/**
 * Created by 昇盾 on 2017/5/12.
 */

public class YYS3Bean {

    /**
     * stat : 1
     * msg : 写入成功
     * info : {"token":"aff6ea71860c471f96c9ea88ee5bc784"}
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
         * token : aff6ea71860c471f96c9ea88ee5bc784
         */

        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
