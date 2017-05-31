package com.sdjr.mdq.bean;

import java.util.List;

/**
 * Created by 昇盾 on 2017/5/11.
 */

public class RZBean {


    /**
     * stat : 1
     * info : {"price":{"amount":"0.00"},"ident":[[{"id":"1","stat":"0"},{"id":"2","stat":"0"},{"id":"4","stat":"0"},{"id":"3","stat":"0"},{"id":"5","stat":"0"},{"id":"6","stat":"0"},{"id":"7","stat":"0"},{"id":"8","stat":"0"},{"id":"9","stat":"0"}],[{"id":"1","stat":"0"},{"id":"2","stat":"0"},{"id":"3","stat":"0"},{"id":"4","stat":"0"},{"id":"5","stat":"0"},{"id":"6","stat":"0"},{"id":"8","stat":"0"},{"id":"9","stat":"0"},{"id":"7","stat":"0"}]]}
     * msg : 请求成功
     */

    private String stat;
    private InfoBean info;
    private String msg;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class InfoBean {
        /**
         * price : {"amount":"0.00"}
         * ident : [[{"id":"1","stat":"0"},{"id":"2","stat":"0"},{"id":"4","stat":"0"},{"id":"3","stat":"0"},{"id":"5","stat":"0"},{"id":"6","stat":"0"},{"id":"7","stat":"0"},{"id":"8","stat":"0"},{"id":"9","stat":"0"}],[{"id":"1","stat":"0"},{"id":"2","stat":"0"},{"id":"3","stat":"0"},{"id":"4","stat":"0"},{"id":"5","stat":"0"},{"id":"6","stat":"0"},{"id":"8","stat":"0"},{"id":"9","stat":"0"},{"id":"7","stat":"0"}]]
         */

        private PriceBean price;
        private List<List<IdentBean>> ident;

        public PriceBean getPrice() {
            return price;
        }

        public void setPrice(PriceBean price) {
            this.price = price;
        }

        public List<List<IdentBean>> getIdent() {
            return ident;
        }

        public void setIdent(List<List<IdentBean>> ident) {
            this.ident = ident;
        }

        public static class PriceBean {
            /**
             * amount : 0.00
             */

            private String amount;

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }
        }

        public static class IdentBean {
            /**
             * id : 1
             * stat : 0
             */

            private String id;
            private String stat;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getStat() {
                return stat;
            }

            public void setStat(String stat) {
                this.stat = stat;
            }
        }
    }
}
