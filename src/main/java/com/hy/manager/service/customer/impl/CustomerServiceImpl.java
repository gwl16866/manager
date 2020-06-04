package com.hy.manager.service.customer.impl;

import com.hy.manager.entity.customer.Customer;
import com.hy.manager.mapper.customer.CustomerMapper;
import com.hy.manager.service.customer.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}
