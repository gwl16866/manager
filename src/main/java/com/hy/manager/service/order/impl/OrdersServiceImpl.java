package com.hy.manager.service.order.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.manager.entity.order.Orders;
import com.hy.manager.mapper.order.OrdersMapper;
import com.hy.manager.service.order.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private OrdersMapper ordersMapper;

    //订单列表
    public List<Orders> selectOrders(String orderOrProduct,String nameOrPhone,String time) {
        return ordersMapper.selectOrders(orderOrProduct, nameOrPhone,time);
    }


    //订单列表详情
    public Orders lookOrders(String orderNumber) {
        return ordersMapper.lookOrders(orderNumber);
    }

    //修改
    public void  updateInfo(String cname,String caddress,String cphone,Integer id){
        ordersMapper.updateInfo(cname,caddress,cphone,id);
    };

}
