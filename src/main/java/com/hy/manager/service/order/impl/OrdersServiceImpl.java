package com.hy.manager.service.order.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.manager.entity.order.Orders;
import com.hy.manager.mapper.order.OrdersMapper;
import com.hy.manager.service.order.IOrdersService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

}
