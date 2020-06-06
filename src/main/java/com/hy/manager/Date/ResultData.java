package com.hy.manager.Date;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResultData implements Serializable {
    private List data;
    private int code;
    private int dataSize;



}
