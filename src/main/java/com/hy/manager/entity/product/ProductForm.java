package com.hy.manager.entity.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductForm implements Serializable {


    private String productName;

    private BigDecimal price;

    private String productNumber;

    private Integer sellVolume;

    private Integer status;

    private Integer upStatus;

    private String image;

    private String model;

    private String color;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")//前端到后端
    private Date marketDate;

    private String productMaterials;

    private String productUser;

    private Integer images;

    private Integer classes;

    private String className;

    private Integer isShow;


}
