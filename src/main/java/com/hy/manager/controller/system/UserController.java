package com.hy.manager.controller.system;


import com.hy.manager.entity.customer.Customer;
import com.hy.manager.entity.system.FourObject;
import com.hy.manager.entity.system.User;
import com.hy.manager.service.system.IUserService;
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
@RequestMapping("/system/user")
public class UserController {

    @Resource
    private IUserService userService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/listselect")
    public List<User> listselect(){
        return userService.listselect();
    }

    @CrossOrigin
    @RequestMapping("/userupd")
    public void userupd(User user){
        userService.userupd(user);
    }
    @CrossOrigin
    @RequestMapping("/del")
    public String del(String uid){
        System.out.println(uid);
        userService.del(uid);
        return "0";
    }

    @CrossOrigin
    @RequestMapping("/add")
    public String add(User user){
        userService.add(user);
        return "0";
    }

    @CrossOrigin
    @RequestMapping("/count")
    public int count(){
       return userService.count();
    }

    @CrossOrigin
    @RequestMapping("/returnmoney")
    public int returnmoney(){
        return userService.returnmonry();
    }

    @CrossOrigin
    @RequestMapping("/sales")
    public int sales(){
        return userService.sales();
    }

    @CrossOrigin
    @RequestMapping("/ordercount")
    public int ordercount(){
        return userService.ordercount();
    }

    @CrossOrigin
    @RequestMapping("/selectFour")
    public FourObject selectFour() {
        FourObject fo = new FourObject();
        fo.setPeoples(userService.selectSumUsers());
        fo.setMessage(userService.selectMessage());
        fo.setMoney(userService.selectMoney());
        fo.setShopping(userService.selectShopping());
        return fo;
    }
}
