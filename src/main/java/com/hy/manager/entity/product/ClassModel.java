package com.hy.manager.entity.product;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClassModel implements Serializable {

    private Integer id;
    private Integer fid;
    private Integer type;
    private String twoModel;

}
