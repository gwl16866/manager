package com.hy.manager.controller.order;

import com.github.pagehelper.PageHelper;
import com.hy.manager.Date.ResultData;
import com.hy.manager.entity.order.Returnthings;
import com.hy.manager.service.order.IReturnthingsService;
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
@RequestMapping("/re/returnthings")
public class ReturnthingsController {

    @Autowired
   private IReturnthingsService iReturnthingsService;

    //退货查询
    @ResponseBody
    @RequestMapping("/selectReturnThings")
    public  ResultData selectReturnThings(@RequestParam("currentPage") int currentPage,
                               @RequestParam("pageSize") int pageSize,String serverNumber,String nameOrPhone,String time,Integer applyStatus){
        ResultData resultData=new ResultData();
        List<Returnthings> returnthingsListSize=iReturnthingsService.selectReturnThings(serverNumber,nameOrPhone,time,applyStatus);
        PageHelper.startPage(currentPage, pageSize);
        List<Returnthings> returnthingsList=iReturnthingsService.selectReturnThings(serverNumber,nameOrPhone,time,applyStatus);
        resultData.setDataSize(returnthingsListSize.size());
        resultData.setData(returnthingsList);
        return resultData;
    }

    //同意或者拒绝退货
    @ResponseBody
    @RequestMapping("/agreeReturn")
    public Integer agreeReturn(Integer id,Integer applyStatus){
        try {
            iReturnthingsService.agreeReturn(id,applyStatus);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }


    //批量同意或者拒绝退款
    @ResponseBody
    @RequestMapping("/batch")
    public Integer batch(String[] batchList,String type){
        try {
            iReturnthingsService.batch(batchList,type);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

}
