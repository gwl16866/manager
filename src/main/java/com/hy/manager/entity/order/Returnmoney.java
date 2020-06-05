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

    private String serverNumber;

    //申请时间
    private String applyTime;

    private Integer userId;

    private BigDecimal returnMoney;

    private Integer applyStatus;

    private String dispose;

    private Integer orderId;

    private Integer returnReason;

    private String linkMan;

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
}
