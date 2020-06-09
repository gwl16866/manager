package com.hy.manager.entity.order;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@Data
public class Returnthings implements Serializable {

    private static final long serialVersionUID = 1L;
private Integer id;
    private String serverNumber;

    private String applyTime;

    private Integer userId;

    private BigDecimal returnMoney;

    private Integer applyStatus;

    private String dispose;

    private Integer orderId;

    private Integer returnReason;

    private String reason;

    //客户账号
    private String account;

    //客户姓名
    private String name;

    //订单账号
    private String orderNumber;

    //客户手机号
    private String phoneNo;

    private BigDecimal sumMoney;
    //图片
    private String image;
    private String productName;
    private BigDecimal price;
    //商品规格
    private String productModel;
    //商品颜色
    private String productColor;
    //商品货号
    private String productNumber;
    //客户地址
    private String aname;
}
