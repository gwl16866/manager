package com.hy.manager.entity.product;

import java.math.BigDecimal;

import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@Data
@TableName("product")
public class Product  {


    @TableId("pid")
    private Integer pid;

    @TableField("productName")
    private String productName;

    @TableField("price")
    private BigDecimal price;

    @TableField("productNumber")
    private String productNumber;

    @TableField("sellVolume")
    private Integer sellVolume;

    @TableField("status")
    private Integer status;

    @TableField("upStatus")
    private Integer upStatus;

    @TableField("image")
    private String image;

    @TableField("productModel")
    private String productModel;

    @TableField("productColor")
    private String productColor;




    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")//前端到后端
    @TableField("marketDate")
    private String marketDate;

    @TableField("productMaterials")
    private String productMaterials;

    @TableField("productUser")
    private String productUser;

    @TableField(exist = false)
    private Integer images;

    @TableField("classes")
    private Integer classes;

    @TableField(exist = false)
    private String className;

    @TableField(exist = false)
    private Integer isShow;

    @TableField("counts")
    private Integer counts;

}
