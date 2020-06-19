package com.hy.manager.entity.product;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @TableField("marketDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")//前端到后端
    private String marketDate;

    @TableField("productMaterials")
    private String productMaterials;

    @TableField("productUser")
    private String productUser;

    @TableField(exist = false)
    private Integer images;

    @TableField("classes")
    private Integer classes;

    @TableField("counts")
    private Integer counts;

    @TableField("alarmCount")
    private Integer alarmCount;

    @TableField(value = "className",exist = false)
    private String className;




    @TableField("isShow")
    private Integer isShow;


    @TableField(value = "addList",exist = false)
    private List<AddProduct> addList;

    @TableField("seckillPrice")
    private BigDecimal seckillPrice;

    @TableField("seckillNumber")
    private Integer seckillNumber;

    @TableField("residueNumber")
    private Integer residueNumber;

    @TableField("purchaseNumber")
    private Integer purchaseNumber;

    @TableField("seckillId")
    private Integer seckillId;
}
