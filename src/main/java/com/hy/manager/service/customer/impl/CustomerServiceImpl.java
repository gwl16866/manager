package com.hy.manager.service.customer.impl;

import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.manager.entity.customer.Customer;
import com.hy.manager.entity.customer.customerOrderProduct;
import com.hy.manager.mapper.customer.CustomerMapper;
import com.hy.manager.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
@Transactional
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Resource
    private CustomerMapper customerMapper;


    @Override
    public List<Customer> listselect(Customer customer) {
        return customerMapper.listselect(customer);
    }

    @Override
    public List<Customer> userselect(String id) {
        return customerMapper.userselect(id);
    }

    @Override
    public List<Customer> addselect(String id) {
        return customerMapper.addselect(id);
    }

    @Override
    public List<customerOrderProduct> orderselect(String id) {
        return customerMapper.orderselect(id);
    }

    @Override
    public List<customerOrderProduct> ordersselect(String id) {
        return customerMapper.ordersselect(id);
    }

    @Override
    public void upd(Customer customer){
        customerMapper.upd(customer);
    }

    @Override
    public void custupd(Customer customer) {
        customerMapper.custupd(customer);
    }

    @Override
    public void addupd(Customer customer) {
        customerMapper.addupd(customer);
    }


    @Override
    public void del(String id) {
         customerMapper.del(id);
    }
}
