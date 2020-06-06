package com.hy.manager.service.customer;

import com.hy.manager.entity.customer.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

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

    List<Customer> listselect(Customer customer);
    void upd(Customer customer);
    void del(String id);

}
