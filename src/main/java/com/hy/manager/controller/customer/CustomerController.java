package com.hy.manager.controller.customer;


import com.hy.manager.entity.customer.Customer;
import com.hy.manager.service.customer.ICustomerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@RestController
@RequestMapping("/cu/customer")
public class CustomerController {

    @Resource
    private ICustomerService customerService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/select")
    public List<Customer> listselect(Customer customer){
        return customerService.listselect(customer);
    }

    @CrossOrigin
    @RequestMapping("/upd")
    public void upd(Customer customer){
        customerService.upd(customer);
    }

    @CrossOrigin
    @RequestMapping("/del")
    public String del(String id){
        customerService.del(id);
        return "0";
    }


}
