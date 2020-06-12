package com.hy.manager.controller.order;

import com.github.pagehelper.PageHelper;
import com.hy.manager.Date.ResultData;
import com.hy.manager.entity.order.Returnthings;
import com.hy.manager.entity.order.Seckill;
import com.hy.manager.entity.product.Product;
import com.hy.manager.service.order.IReturnthingsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
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
        //查询条数  以及判断是否结束
        for (Seckill a : seckillList) {
            a.setCounts(iReturnthingsService.seckillCounts(a.getSeckillId()));

            Date date=new Date();
            if(date.compareTo(a.getStarTime())>0 && date.compareTo(a.getEndTime())<0){
                a.setStatus(1);
                iReturnthingsService.updateStatus(a.getSeckillId(),a.getStatus(),a.getPutOrNot());
            }else{
                a.setStatus(2);
                a.setPutOrNot(2);

                //修改状态
                iReturnthingsService.updateStatus(a.getSeckillId(),a.getStatus(),a.getPutOrNot());
            }
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
    public Integer addSeckill(Seckill seckill){
        try {
            iReturnthingsService.addSeckill(seckill);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }


    //删除秒杀活动
    @ResponseBody
    @RequestMapping("/deleteSeckill")
    public Integer deleteSeckill(Integer seckillId){
        try {
            iReturnthingsService.deleteSeckill(seckillId);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }


    //修改秒杀活动
    @ResponseBody
    @RequestMapping("/updateSeckill")
    public Integer updateSeckill(Seckill seckill){
        try {
            iReturnthingsService.updateSeckill(seckill);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

//根据秒杀查询商品
@ResponseBody
@RequestMapping("/productList")
public  ResultData productList(@RequestParam("currentPage") int currentPage,
                                 @RequestParam("pageSize") int pageSize,Integer seckillId){
    ResultData resultData=new ResultData();
    List<Product> productListSize=iReturnthingsService.productList(seckillId);

    PageHelper.startPage(currentPage, pageSize);
    List<Product> productList=iReturnthingsService.productList(seckillId);
    resultData.setDataSize(productListSize.size());
    resultData.setData(productList);
    return resultData;
}

    //在活动中下架商品
    @ResponseBody
    @RequestMapping("/deleterProduct")
    public Integer deleterProduct(Integer pid){
        try {
            iReturnthingsService.deleterProduct(pid);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

    //查询所有商品
    @ResponseBody
    @RequestMapping("/allProductList")
    public  ResultData allProductList(@RequestParam("currentPage") int currentPage,
                                   @RequestParam("pageSize") int pageSize){
        ResultData resultData=new ResultData();
        List<Product> productListSize=iReturnthingsService.allProductList();

        PageHelper.startPage(currentPage, pageSize);
        List<Product> productList=iReturnthingsService.allProductList();
        resultData.setDataSize(productListSize.size());
        resultData.setData(productList);
        return resultData;
    }

    //修改商品
    @ResponseBody
    @RequestMapping("/updateProductSubmint")
    public Integer updateProductSubmint(Product product){
        try {
            iReturnthingsService.updateProductSubmint(product);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }



    //批量查询
    @ResponseBody
    @RequestMapping("/search")
    public  ResultData search(@Param("batchList")String[] batchList){
        System.out.println("con++++++++++++++++++++++++"+batchList);
        ResultData resultData=new ResultData();
        List<Product> productList=iReturnthingsService.search(batchList);
        resultData.setData(productList);
        return resultData;
    }

    //批量添加
    @ResponseBody
    @RequestMapping("/batchAdd")
    public Integer batchAdd(List<Product> product,String[] batchList,Integer seckillId){

        System.out.println(product);

        return 1;
    }

}
