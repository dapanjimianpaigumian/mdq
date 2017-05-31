package com.sdjr.mdq.bean;

import java.util.List;

/**
 * Created by 昇盾 on 2017/5/3.
 */

public class DTBDBean {


    /**
     * stat : 1
     * info : 2
     * purviews : {"step5":[{"id":"40","T":"yunying","R":"1"},{"id":"44","T":"gongjijin","R":"0"},{"id":"46","T":"taobao","R":"1"},{"id":"43","T":"shebao","R":"0"},{"id":"42","T":"xuexin","R":"0"},{"id":"47","T":"jd","R":"0"},{"id":"48","T":"xinyongka","R":"0"},{"id":"45","T":"zhengxin","R":"0"}],"step1":[{"id":"53","T":"borrow","R":"1"},{"id":"12","T":"credits","R":"1"},{"id":"10","T":"address","R":"1"},{"id":"9","T":"car_loan","R":"1"},{"id":"51","T":"jin_liabilities","R":"1"},{"id":"11","T":"graduation","R":"1"},{"id":"8","T":"house_loan","R":"1"},{"id":"50","T":"bao_liabilities","R":"1"},{"id":"49","T":"zhima_score","R":"0"},{"id":"14","T":"home_tel","R":"1"},{"id":"13","T":"credit_limit","R":"1"},{"id":"1","T":"name","R":"1"},{"id":"2","T":"idcard","R":"1"},{"id":"6","T":"marriage","R":"1"},{"id":"15","T":"QQ","R":"1"},{"id":"7","T":"houses","R":"1"},{"id":"3","T":"jiedaibao","R":"1"},{"id":"4","T":"emails","R":"1"},{"id":"52","T":"recommend","R":"1"}],"step2":[{"id":"19","T":"workmate","R":"1"},{"id":"17","T":"mother","R":"1"},{"id":"16","T":"father","R":"1"},{"id":"18","T":"family","R":"0"},{"id":"20","T":"friend","R":"1"}],"step4":[{"id":"36","T":"front","R":"1"},{"id":"39","T":"more_img","R":"1"},{"id":"37","T":"back","R":"1"},{"id":"38","T":"handsID","R":"1"}],"step3":[{"id":"26","T":"com_email","R":"1"},{"id":"22","T":"com_scale","R":"1"},{"id":"21","T":"company","R":"0"},{"id":"23","T":"com_type","R":"0"},{"id":"27","T":"com_position","R":"0"},{"id":"25","T":"com_tel","R":"0"},{"id":"24","T":"salary","R":"0"}]}
     * msg : 请求成功
     */

    private String stat;
    private String info;
    private PurviewsBean purviews;
    private String msg;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public PurviewsBean getPurviews() {
        return purviews;
    }

    public void setPurviews(PurviewsBean purviews) {
        this.purviews = purviews;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class PurviewsBean {
        private List<Step5Bean> step5;
        private List<Step1Bean> step1;
        private List<Step2Bean> step2;
        private List<Step4Bean> step4;
        private List<Step3Bean> step3;

        public List<Step5Bean> getStep5() {
            return step5;
        }

        public void setStep5(List<Step5Bean> step5) {
            this.step5 = step5;
        }

        public List<Step1Bean> getStep1() {
            return step1;
        }

        public void setStep1(List<Step1Bean> step1) {
            this.step1 = step1;
        }

        public List<Step2Bean> getStep2() {
            return step2;
        }

        public void setStep2(List<Step2Bean> step2) {
            this.step2 = step2;
        }

        public List<Step4Bean> getStep4() {
            return step4;
        }

        public void setStep4(List<Step4Bean> step4) {
            this.step4 = step4;
        }

        public List<Step3Bean> getStep3() {
            return step3;
        }

        public void setStep3(List<Step3Bean> step3) {
            this.step3 = step3;
        }

        public static class Step5Bean {
            /**
             * id : 40
             * T : yunying
             * R : 1
             */

            private String id;
            private String T;
            private String R;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getT() {
                return T;
            }

            public void setT(String T) {
                this.T = T;
            }

            public String getR() {
                return R;
            }

            public void setR(String R) {
                this.R = R;
            }
        }

        public static class Step1Bean {
            /**
             * id : 53
             * T : borrow
             * R : 1
             */

            private String id;
            private String T;
            private String R;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getT() {
                return T;
            }

            public void setT(String T) {
                this.T = T;
            }

            public String getR() {
                return R;
            }

            public void setR(String R) {
                this.R = R;
            }
        }

        public static class Step2Bean {
            /**
             * id : 19
             * T : workmate
             * R : 1
             */

            private String id;
            private String T;
            private String R;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getT() {
                return T;
            }

            public void setT(String T) {
                this.T = T;
            }

            public String getR() {
                return R;
            }

            public void setR(String R) {
                this.R = R;
            }
        }

        public static class Step4Bean {
            /**
             * id : 36
             * T : front
             * R : 1
             */

            private String id;
            private String T;
            private String R;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getT() {
                return T;
            }

            public void setT(String T) {
                this.T = T;
            }

            public String getR() {
                return R;
            }

            public void setR(String R) {
                this.R = R;
            }
        }

        public static class Step3Bean {
            /**
             * id : 26
             * T : com_email
             * R : 1
             */

            private String id;
            private String T;
            private String R;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getT() {
                return T;
            }

            public void setT(String T) {
                this.T = T;
            }

            public String getR() {
                return R;
            }

            public void setR(String R) {
                this.R = R;
            }
        }
    }
}
