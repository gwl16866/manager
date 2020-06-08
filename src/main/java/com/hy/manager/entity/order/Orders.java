package com.hy.manager.entity.order;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@Data
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    //订单编号
    private String orderNumber;

    //提交时间
    private String submitDate;

    private Integer userId;

    //商品总价
    private BigDecimal sumMoney;
    //商品单价
    private BigDecimal price;
    //订单状态
    private Integer status;

    //自动确认收货时间
    private Integer autoReceiveTime;

    //订单应收时间
    private String maybeReceiveTime;

    //商品编号
    private Integer productId;

    private String orderResource;

    //客户账号
    private String account;

    //客户昵称
    private String name;

    //商品名称
    private String productName;

    //客户手机号
    private String phoneNo;
    //客户地址
    private String address;

    //数量
    private Integer counts;

    //商品图片
    private String image;
    //商品规格
    private String productModel;
    //商品颜色
    private String productColor;
    //商品货号
    private String productNumber;
}
