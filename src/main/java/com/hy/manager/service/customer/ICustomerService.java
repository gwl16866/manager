package com.hy.manager.service.customer;

import com.hy.manager.entity.customer.Customer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.manager.entity.customer.customerOrderProduct;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
public interface ICustomerService extends IService<Customer> {
//查询全部
    List<Customer> listselect(Customer customer);
    //查询用户详情
    List<Customer> userselect(String id);
    //查询详细地址
    List<Customer> addselect(String id);
    //查询订单目录
    List<customerOrderProduct> orderselect(String id);
    //查询订单详细
    List<customerOrderProduct> ordersselect(String id);
    //修改
    void upd(Customer customer);
    //修改用户详情
    void custupd(Customer customer);
    //修改地址详情
    void addupd(Customer customer);

    //删除
    void del(String id);

}
