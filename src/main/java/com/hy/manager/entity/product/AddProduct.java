package com.hy.manager.entity.product;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddProduct implements Serializable {



    private Integer index;
    private String model;
    private String color;
    private String price;
    private Integer counts;
    private Integer alarm;





}
