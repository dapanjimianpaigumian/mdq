package com.sdjr.mdq.bean;

import java.util.List;

/**
 * Created by user on 2017/5/10.
 */

public class CJWTBean {

    /**
     * stat : 1
     * msg : 获取成功
     * info : [{"id":"45","name":"运营商认证常见问题","url":"http://bao.financesd.cn/list/details.html?id=45"},{"id":"29","name":"央行征信认证如何获取身份验证码","url":"http://bao.financesd.cn/list/details.html?id=29"},{"id":"30","name":"申请借款常见问题","url":"http://bao.financesd.cn/list/details.html?id=30"},{"id":"27","name":"淘宝认证常见问题","url":"http://bao.financesd.cn/list/details.html?id=27"},{"id":"28","name":"京东认证常见问题","url":"http://bao.financesd.cn/list/details.html?id=28"},{"id":"46","name":"信用卡认证常见问题","url":"http://bao.financesd.cn/list/details.html?id=46"},{"id":"47","name":"芝麻认证常见问题","url":"http://bao.financesd.cn/list/details.html?id=47"},{"id":"50","name":"学历认证遇到问题","url":"http://bao.financesd.cn/list/details.html?id=50"},{"id":"51","name":"新手引导","url":"http://bao.financesd.cn/list/details.html?id=51"}]
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
         * id : 45
         * name : 运营商认证常见问题
         * url : http://bao.financesd.cn/list/details.html?id=45
         */

        private String id;
        private String name;
        private String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
