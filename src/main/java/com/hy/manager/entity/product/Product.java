package com.hy.manager.entity.product;

import java.math.BigDecimal;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@Data
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer pid;

    private String productName;

    private BigDecimal price;

    private String productNumber;

    private Integer sellVolume;

    private Integer status;

    private Integer upStatus;

    private String image;

    private String productModel;

    private String productColor;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")//前端到后端
    private Date marketDate;

    private String productMaterials;

    private String productUser;

    private Integer images;


}
