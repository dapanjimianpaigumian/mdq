package com.sdjr.mdq.bean;

/**
 * Created by 昇盾 on 2017/5/13.
 */

public class ZMbean {

    /**
     * stat : 1
     * Url : https://zmopenapi.zmxy.com.cn/openapi.do?app_id=1002224&charset=UTF-8&method=zhima.customer.certification.certify&platform=zmop&sign=zjvos1I8L7%2Fy8KT19mmsHQ4aGFP5F8FUf9W8OIv5JdA0zyGb5bFsXXp8bbiXATbqK%2Fi33QmoL1ehA7u2%2BAi7a5KsTM8f4DleJhmDw6J8m8yupd7YhvNAIeIhZgCT9wrChqveiuwXxGUINRDG8GrnPQ%2Bb1MTN3Pp9Gi6E2HyrZfs%3D&version=1.0&params=ZkYyd2kWlI6SMTXSEUGLna%2FjYSXr%2F%2FOmfyhLtLTyCDQxH8qBCiv5ssviyuIxQ5Sr%2FowoIGvtFNJEXc4ItHof%2FNlhO9Q8S9eySuqD8r8A%2BYWpJYxt7DssE05Gd2cYS%2FAEpb7z9OILAzKLCfM8VqkXi2LZQPr%2BCRMFzkbgYM3VRXE%3D
     * Identifier : {"success":true,"biz_no":"ZM201705133000000494900137128328"}
     */

    private String stat;
    private String Url;
    private IdentifierBean Identifier;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public IdentifierBean getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(IdentifierBean Identifier) {
        this.Identifier = Identifier;
    }

    public static class IdentifierBean {
        /**
         * success : true
         * biz_no : ZM201705133000000494900137128328
         */

        private boolean success;
        private String biz_no;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getBiz_no() {
            return biz_no;
        }

        public void setBiz_no(String biz_no) {
            this.biz_no = biz_no;
        }
    }
}
