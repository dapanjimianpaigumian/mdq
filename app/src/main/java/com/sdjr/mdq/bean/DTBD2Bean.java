package com.sdjr.mdq.bean;

import java.util.List;

/**
 * Created by user on 2017/5/26.
 */

public class DTBD2Bean {

    /**
     * stat : 1
     * info : 1
     * purviews : [{"identity":"1","purviews":{"step1":[{"id":"1","T":"name","R":"1"},{"id":"2","T":"idcard","R":"1"}],"step2":[{"id":"16","T":"father","R":"1"},{"id":"18","T":"family","R":"1"},{"id":"20","T":"friend","R":"1"}],"step4":[{"id":"36","T":"front","R":"1"},{"id":"37","T":"back","R":"1"},{"id":"38","T":"handsID","R":"1"}],"step5":[{"id":"40","T":"yunying","R":"1"},{"id":"41","T":"zhima","R":"1"},{"id":"46","T":"taobao","R":"1"},{"id":"42","T":"xuexin","R":"0"},{"id":"45","T":"zhengxin","R":"0"},{"id":"47","T":"jd","R":"0"},{"id":"48","T":"xinyongka","R":"0"}],"step3":[{"id":"21","T":"company","R":"1"},{"id":"25","T":"com_tel","R":"0"}]}},{"identity":"3","purviews":null},{"identity":"2","purviews":{"step1":[{"id":"1","T":"name","R":"1"},{"id":"2","T":"idcard","R":"1"},{"id":"4","T":"emails","R":"1"},{"id":"53","T":"borrow","R":"1"},{"id":"5","T":"education","R":"0"},{"id":"6","T":"marriage","R":"1"},{"id":"12","T":"credits","R":"0"},{"id":"7","T":"houses","R":"0"}],"step2":[{"id":"18","T":"family","R":"1"},{"id":"20","T":"friend","R":"0"},{"id":"19","T":"workmate","R":"0"}],"step4":[{"id":"36","T":"front","R":"1"},{"id":"37","T":"back","R":"1"},{"id":"38","T":"handsID","R":"1"},{"id":"39","T":"more_img","R":"1"}],"step5":[{"id":"40","T":"yunying","R":"1"},{"id":"41","T":"zhima","R":"1"},{"id":"46","T":"taobao","R":"1"},{"id":"47","T":"jd","R":"0"},{"id":"45","T":"zhengxin","R":"0"},{"id":"48","T":"xinyongka","R":"0"},{"id":"42","T":"xuexin","R":"0"}],"step3":[{"id":"21","T":"company","R":"1"},{"id":"25","T":"com_tel","R":"0"}]}}]
     * msg : 请求成功
     */

    private String stat;
    private String info;
    private String msg;
    private List<PurviewsBeanX> purviews;

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<PurviewsBeanX> getPurviews() {
        return purviews;
    }

    public void setPurviews(List<PurviewsBeanX> purviews) {
        this.purviews = purviews;
    }

    public static class PurviewsBeanX {
        /**
         * identity : 1
         * purviews : {"step1":[{"id":"1","T":"name","R":"1"},{"id":"2","T":"idcard","R":"1"}],"step2":[{"id":"16","T":"father","R":"1"},{"id":"18","T":"family","R":"1"},{"id":"20","T":"friend","R":"1"}],"step4":[{"id":"36","T":"front","R":"1"},{"id":"37","T":"back","R":"1"},{"id":"38","T":"handsID","R":"1"}],"step5":[{"id":"40","T":"yunying","R":"1"},{"id":"41","T":"zhima","R":"1"},{"id":"46","T":"taobao","R":"1"},{"id":"42","T":"xuexin","R":"0"},{"id":"45","T":"zhengxin","R":"0"},{"id":"47","T":"jd","R":"0"},{"id":"48","T":"xinyongka","R":"0"}],"step3":[{"id":"21","T":"company","R":"1"},{"id":"25","T":"com_tel","R":"0"}]}
         */

        private String identity;
        private PurviewsBean purviews;

        public String getIdentity() {
            return identity;
        }

        public void setIdentity(String identity) {
            this.identity = identity;
        }

        public PurviewsBean getPurviews() {
            return purviews;
        }

        public void setPurviews(PurviewsBean purviews) {
            this.purviews = purviews;
        }

        public static class PurviewsBean {
            private List<Step1Bean> step1;
            private List<Step2Bean> step2;
            private List<Step4Bean> step4;
            private List<Step5Bean> step5;
            private List<Step3Bean> step3;

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

            public List<Step5Bean> getStep5() {
                return step5;
            }

            public void setStep5(List<Step5Bean> step5) {
                this.step5 = step5;
            }

            public List<Step3Bean> getStep3() {
                return step3;
            }

            public void setStep3(List<Step3Bean> step3) {
                this.step3 = step3;
            }

            public static class Step1Bean {
                /**
                 * id : 1
                 * T : name
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
                 * id : 16
                 * T : father
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

            public static class Step3Bean {
                /**
                 * id : 21
                 * T : company
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
}
