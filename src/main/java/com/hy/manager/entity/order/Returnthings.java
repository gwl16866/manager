package com.hy.manager.entity.order;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

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

    private String serverNumber;

    private String applyTime;

    private Integer userId;

    private BigDecimal returnMoney;

    private Integer applyStatus;

    private String dispose;

    private Integer orderId;

    private Integer returnReason;


}
