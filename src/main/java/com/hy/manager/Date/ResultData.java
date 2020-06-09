package com.hy.manager.Date;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResultData implements Serializable {
    private List data;
    private int code;
    private int dataSize;

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getDataSize() {
        return dataSize;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }
}
