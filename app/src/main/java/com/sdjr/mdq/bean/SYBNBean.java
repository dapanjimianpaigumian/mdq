package com.sdjr.mdq.bean;

import java.util.List;

/**
 * Created by 昇盾 on 2017/5/18.
 */

public class SYBNBean {

    /**
     * stat : 1
     * msg : 获取成功
     * info : [{"url":"","image":"http://bao.financesd.cn/data/file/8/b/5/591ab11249960.jpg"},{"url":"","image":"http://bao.financesd.cn/data/file/b/9/2/591e5a4931562.jpg"}]
     */

    private String stat;
    private String msg;
    private List<InfoBean> info;

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

    public List<InfoBean> getInfo() {
        return info;
    }

    public void setInfo(List<InfoBean> info) {
        this.info = info;
    }

    public static class InfoBean {
        /**
         * url :
         * image : http://bao.financesd.cn/data/file/8/b/5/591ab11249960.jpg
         */

        private String url;
        private String image;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
