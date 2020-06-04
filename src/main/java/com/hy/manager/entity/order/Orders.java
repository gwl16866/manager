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
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orderNumber;

    private String submitDate;

    private Integer userId;

    private BigDecimal sumMoney;

    private Integer status;

    private Integer autoReceiveTime;

    private String maybeReceiveTime;

    private Integer productId;

    private String orderResource;


}
