package com.hy.manager.entity.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
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

    private Integer classes;

    private String className;

    private Integer isShow;


    private Integer seckillId;
    private BigDecimal seckillPrice;
    private Integer seckillNumber;
    private Integer residueNumber;
    private Integer purchaseNumber;
    private Integer counts;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public Integer getSellVolume() {
        return sellVolume;
    }

    public void setSellVolume(Integer sellVolume) {
        this.sellVolume = sellVolume;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUpStatus() {
        return upStatus;
    }

    public void setUpStatus(Integer upStatus) {
        this.upStatus = upStatus;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public Date getMarketDate() {
        return marketDate;
    }

    public void setMarketDate(Date marketDate) {
        this.marketDate = marketDate;
    }

    public String getProductMaterials() {
        return productMaterials;
    }

    public void setProductMaterials(String productMaterials) {
        this.productMaterials = productMaterials;
    }

    public String getProductUser() {
        return productUser;
    }

    public void setProductUser(String productUser) {
        this.productUser = productUser;
    }

    public Integer getImages() {
        return images;
    }

    public void setImages(Integer images) {
        this.images = images;
    }

    public Integer getClasses() {
        return classes;
    }

    public void setClasses(Integer classes) {
        this.classes = classes;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }
}
