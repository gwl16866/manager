package com.hy.manager.controller.order;

import com.github.pagehelper.PageHelper;
import com.hy.manager.Date.ResultData;
import com.hy.manager.entity.order.Returnthings;
import com.hy.manager.entity.order.Seckill;
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



    //秒杀
    @ResponseBody
    @RequestMapping("/selectSeckill")
    public  ResultData selectSeckill(@RequestParam("currentPage") int currentPage,
                                          @RequestParam("pageSize") int pageSize,Seckill seckill){
        ResultData resultData=new ResultData();
        List<Seckill> seckillListSize=iReturnthingsService.selectSeckill(seckill);

        PageHelper.startPage(currentPage, pageSize);
        List<Seckill> seckillList=iReturnthingsService.selectSeckill(seckill);
        //查询条数
        for (Seckill a : seckillList) {
            a.setCounts(iReturnthingsService.seckillCounts(a.getSeckillId()));
        }
        resultData.setDataSize(seckillListSize.size());
        resultData.setData(seckillList);
        return resultData;
    }



    //上架/下架
    @ResponseBody
    @RequestMapping("/putOrNot")
    public Integer putOrNot(Integer seckillId,Integer putOrNot){
        try {
            iReturnthingsService.putOrNot(seckillId,putOrNot);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

    //新增秒杀活动
    @ResponseBody
    @RequestMapping("/addSeckill")
    public Integer addSeckill(String title , String starTime, String endTime, String seckillStarTime, String seckillEndTime){
        try {
            iReturnthingsService.addSeckill(title, starTime, endTime, seckillStarTime, seckillEndTime);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }
}
