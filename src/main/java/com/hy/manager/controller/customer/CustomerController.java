package com.hy.manager.controller.customer;


import com.hy.manager.entity.customer.Address;
import com.hy.manager.entity.customer.Customer;
import com.hy.manager.entity.customer.CustomerOrderProduct;
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
    @ResponseBody
    @RequestMapping("/userselect")
    public List<CustomerOrderProduct> userselect(String id){

        return customerService.userselect(id);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/addselect")
    public List<CustomerOrderProduct> addselect(String id){

        return customerService.addselect(id);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/orderselect")
    public List<CustomerOrderProduct> orderselect(String id){
        System.out.println(id);
        return customerService.orderselect(id);
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/ordersselect")
    public CustomerOrderProduct ordersselect(String id){

        return customerService.ordersselect(id);
    }

    @CrossOrigin
    @RequestMapping("/upd")
    public void upd(Customer customer){
        customerService.upd(customer);
    }

    @CrossOrigin
    @RequestMapping("/custupd")
    public void custupd(Customer customer){
        customerService.custupd(customer);
    }

    @CrossOrigin
    @RequestMapping("/addupd")
    public void addupd(Address address){
        System.out.println(address.getId());
        customerService.addupd(address);
    }



    @CrossOrigin
    @RequestMapping("/del")
    public String del(String id){
        customerService.del(id);
        return "0";
    }


}
