package com.hy.manager.entity.counts;

import lombok.Data;

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
public class Quantity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer productId;

    private Integer orderId;

    private Integer count;

    private Integer userId;

    private String controlClass;

    private Integer status;


}
