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

    private Integer id;
    private Integer productId;

    private Integer orderId;

    private Integer count;

    private Integer userId;

    //库存类型
    private Integer controlClass;

    private Integer status;

    //库存操作时间
    private String quantityTime;

    //商品图片
    private String image;

    //商品名称
    private String productName;

    //商品货号
    private String productNumber;

    //订单编号
    private String orderNumber;

    //数量
    private Integer counts;
}
