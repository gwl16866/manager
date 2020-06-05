package com.hy.manager.controller.order;

import com.hy.manager.entity.order.Orders;
import com.hy.manager.service.order.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@Controller
@RequestMapping("/o/orders")
public class OrdersController {

    @Autowired
    private IOrdersService iOrdersService;

    //订单列表
    @RequestMapping("/selectOrders")
    @ResponseBody
    public List<Orders> selectOrders(String orderOrProduct,String nameOrPhone,String time){
       List<Orders> ordersList= iOrdersService.selectOrders(orderOrProduct,nameOrPhone,time);
        return ordersList;
    }

}
