package com.sdjr.mdq.ui.qyxx;

/**
 * Created by user on 2017/5/10.
 */

public class PhoneInfo {
    private String name;
    private String number;

    public PhoneInfo(String name ,String number){
        setNumber(number);
        setName(name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
