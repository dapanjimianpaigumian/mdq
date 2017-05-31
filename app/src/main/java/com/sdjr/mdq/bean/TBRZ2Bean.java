package com.sdjr.mdq.bean;

/**
 * Created by 昇盾 on 2017/5/13.
 */

public class TBRZ2Bean {

    /**
     * stat : 1
     * value : iVBORw0KGgoAAAANSUhEUgAAAIwAAACMCAIAAAAhotZpAAAC2UlEQVR4nO2dy26EMAwAS9X//+WtetkDoikmtsnQmePuAtGOLJw4j+31en3I2nze3QD5GyUBUBIAJQFQEgAlAfg6/HTbtp7HjzsA42Ykdh52D9rd+fZ/w0gCoCQASgKgJADHicOOuld0iFAzQg8K3bn/3zCSACgJgJIAKAnAqcRhR907edzzDzWj7rmhZuy4lnQYSQCUBEBJAJQE4Eri0Mb4fT4uKITSisWnTBlJAJQEQEkAlARg6cQhccShbZ5CBUYSACUBUBIAJQG4kji09c/rUoOZ2sS4GRUYSQCUBEBJAJQE4FTicFd3vW7UYHznmZGOCowkAEoCoCQASgKwLVXer1tz0TCFsQ4jCYCSACgJgJIAnNrHoa3nn/jyr1tzMYOrKh6LkgAoCYCSAJwacUjMI0KpQd2PQ8zUNcbNOHmtkQRASQCUBEBJABJKFXU1/9Abe5E8IvHHb4wkAEoCoCQASgLQveV0W9Vjx0zSMbNDxPhbd458DkoCoCQASgLQvRwzsX+eOIuhbhAhJTMykgAoCYCSACgJwHGpYpERh8TJBW0k1lPeGEkAlARASQCUBODKIVdtJzuEmjFz7V2HdJ5shpEEQEkAlARASQDySxUzB0zMUDfHYWbKw7iRznF4DkoCoCQASgKQcDpm4ojD7QsfD68NMZOS/IaRBEBJAJQEQEkAlt45ErFNk8dqyw9KAqAkAEoC0D05ckfbIMLMne/aR/ONkQRASQCUBEBJAK5MjpyhboVlXVqReHamqyoei5IAKAmAkgAkzHEYc1cpZGYgIHEQIZQoOeIARkkAlARASQCuJA5r0rZzZH8hw0gCoCQASgKgJABLJw512yuESgaJaz1cjvlYlARASQCUBKB7y+nQndtqIok5SOjakxhJAJQEQEkAlATgVOLQtshiZkPHlB0T0rFU8V9QEgAlAVASgLX2cZBDjCQASgKgJABKAqAkAEoCoCQA38gQfiIVmHVbAAAAAElFTkSuQmCC
     * params : method=api.common.getStatus&token=ca2f259e2b524c27a783acdacd5c3883&bizType=taobao&apiKey=3104028489553430&version=1.2.0&sign=05996502dcefe5fc2ab610fbe5ad2f4c141558ed
     * token : ca2f259e2b524c27a783acdacd5c3883
     * msg :
     */

    private int stat;
    private String value;
    private String params;
    private String token;
    private String msg;

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
