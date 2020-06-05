package com.hy.manager.controller.counts;

import com.hy.manager.entity.counts.Quantity;
import com.hy.manager.service.counts.IQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@Controller
@RequestMapping("/ku/quantity")
public class QuantityController {

    @Autowired
    IQuantityService iQuantityService;

    //库存列表
    @RequestMapping("/selectQuantity")
    @ResponseBody
    public List<Quantity> selectQuantity(String productOrNumber, Integer status,String time){
        return  iQuantityService.selectQuantity(productOrNumber, status,time);
    }

}
