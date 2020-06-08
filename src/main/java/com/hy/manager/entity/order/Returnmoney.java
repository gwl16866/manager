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
public class Returnmoney implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String serverNumber;

    //申请时间
    private String applyTime;

    private Integer userId;

    private BigDecimal returnMoney;

    //申请状态
    private Integer applyStatus;

    private String dispose;

    private Integer orderId;

    private Integer returnReason;

    private String linkMan;

    //退货原因
    private String reason;

    //客户账号
    private String account;

    //客户姓名
    private String name;

    //订单账号
    private String orderNumber;

    //客户手机号
    private String phoneNo;
//退款金额
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
    //地址
    private String address;
}
