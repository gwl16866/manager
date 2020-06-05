package com.hy.manager.service.order;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.manager.entity.order.Orders;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
public interface IOrdersService extends IService<Orders> {
    public List<Orders> selectOrders(String orderOrProduct,String nameOrPhone,String time);
}
