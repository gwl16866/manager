package com.hy.manager.entity.system;

import java.io.Serializable;

public class DeskPojo implements Serializable {
    private String month;
    private String val;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
