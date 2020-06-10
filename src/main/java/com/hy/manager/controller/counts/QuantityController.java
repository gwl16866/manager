package com.hy.manager.controller.counts;

import com.github.pagehelper.PageHelper;
import com.hy.manager.Date.ResultData;
import com.hy.manager.entity.counts.Quantity;
import com.hy.manager.service.counts.IQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResultData selectQuantity(@RequestParam("currentPage") int currentPage,
                                     @RequestParam("pageSize") int pageSize,String productOrNumber, String controlClass, String time){
        ResultData resultData=new ResultData();
        List<Quantity> quantityListSize=  iQuantityService.selectQuantity(productOrNumber, controlClass,time);

        PageHelper.startPage(currentPage, pageSize);
        List<Quantity> quantityList=  iQuantityService.selectQuantity(productOrNumber, controlClass,time);
        resultData.setDataSize(quantityListSize.size());
        resultData.setData(quantityList);

        return resultData;
    }

}
