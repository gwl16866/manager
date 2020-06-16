package com.hy.manager.controller.order;

import com.github.pagehelper.PageHelper;
import com.hy.manager.Date.ResultData;
import com.hy.manager.entity.order.Orders;
import com.hy.manager.service.order.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResultData selectOrders(@RequestParam("currentPage") int currentPage,
                                   @RequestParam("pageSize") int pageSize, String orderOrProduct, String nameOrPhone, String time) {
        ResultData resultData = new ResultData();
        List<Orders> ordersListSize = iOrdersService.selectOrders(orderOrProduct, nameOrPhone, time);
        PageHelper.startPage(currentPage, pageSize);
        List<Orders> ordersList = iOrdersService.selectOrders(orderOrProduct, nameOrPhone, time);
        resultData.setDataSize(ordersListSize.size());
        resultData.setData(ordersList);
        return resultData;
    }

    //订单列表详情
    @RequestMapping("/lookOrders")
    @ResponseBody
    public Orders lookOrders(String orderNumber) {
      Orders orders=  iOrdersService.lookOrders(orderNumber);
        return orders;
    }


    //修改订单信息
    //修改商品
    @ResponseBody
    @RequestMapping("/updateInfo")
    public Integer updateInfo(String cname,String caddress,String cphone,Integer id) {
        try {
            iOrdersService.updateInfo(cname,caddress,cphone,id);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

}
