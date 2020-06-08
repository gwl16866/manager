package com.hy.manager.controller.customer;


import com.hy.manager.entity.customer.Customer;
import com.hy.manager.entity.customer.customerOrderProduct;
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
    public List<Customer> userselect(String id){

        return customerService.userselect(id);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/addselect")
    public List<Customer> addselect(String id){

        return customerService.addselect(id);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/orderselect")
    public List<customerOrderProduct> orderselect(String id){
        System.out.println(id);
        return customerService.orderselect(id);
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/ordersselect")
    public List<customerOrderProduct> ordersselect(String id){
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
    public void addupd(Customer customer){
        customerService.addupd(customer);
    }



    @CrossOrigin
    @RequestMapping("/del")
    public String del(String id){
        customerService.del(id);
        return "0";
    }


}
