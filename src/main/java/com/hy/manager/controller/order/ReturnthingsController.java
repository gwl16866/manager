package com.hy.manager.controller.order;

import com.github.pagehelper.PageHelper;
import com.hy.manager.Date.ResultData;
import com.hy.manager.entity.order.Returnthings;
import com.hy.manager.entity.order.Seckill;
import com.hy.manager.entity.order.SeckillTwo;
import com.hy.manager.entity.product.Product;
import com.hy.manager.service.order.IReturnthingsService;
import com.hy.manager.service.product.IProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
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
    @Autowired
    IProductService iProductService;

    //退货查询
    @ResponseBody
    @RequestMapping("/selectReturnThings")
    public ResultData selectReturnThings(@RequestParam("currentPage") int currentPage,
                                         @RequestParam("pageSize") int pageSize, String serverNumber, String nameOrPhone, String time, Integer applyStatus) {
        ResultData resultData = new ResultData();
        List<Returnthings> returnthingsListSize = iReturnthingsService.selectReturnThings(serverNumber, nameOrPhone, time, applyStatus);
        PageHelper.startPage(currentPage, pageSize);
        List<Returnthings> returnthingsList = iReturnthingsService.selectReturnThings(serverNumber, nameOrPhone, time, applyStatus);
        resultData.setDataSize(returnthingsListSize.size());
        resultData.setData(returnthingsList);
        return resultData;
    }

    //同意或者拒绝退货
    @ResponseBody
    @RequestMapping("/agreeReturn")
    public Integer agreeReturn(Integer id, Integer applyStatus) {
        try {
            iReturnthingsService.agreeReturn(id, applyStatus);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    //批量同意或者拒绝退款
    @ResponseBody
    @RequestMapping("/batch")
    public Integer batch(String[] batchList, String type) {
        try {
            iReturnthingsService.batch(batchList, type);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    //时间判断
    public static boolean compTime(String s1, String s2) {
        try {
            if (s1.indexOf(":") < 0 || s1.indexOf(":") < 0) {
                System.out.println("格式不正确");
            } else {
                String[] array1 = s1.split(":");
                int total1 = Integer.valueOf(array1[0]) * 3600 + Integer.valueOf(array1[1]) * 60 + Integer.valueOf(array1[2]);
                String[] array2 = s2.split(":");
                int total2 = Integer.valueOf(array2[0]) * 3600 + Integer.valueOf(array2[1]) * 60 + Integer.valueOf(array2[2]);
                return total1 - total2 > 0 ? true : false;
            }
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    //秒杀
    @ResponseBody
    @RequestMapping("/selectSeckill")
    public ResultData selectSeckill(@RequestParam("currentPage") int currentPage,
                                    @RequestParam("pageSize") int pageSize, Seckill seckill,SeckillTwo seckillTwo) {
        ResultData resultData = new ResultData();
        List<Seckill> seckillListSize = iReturnthingsService.selectSeckill(seckill);

        PageHelper.startPage(currentPage, pageSize);
        List<SeckillTwo> seckillList = iReturnthingsService.selectSeckillTwo(seckill);


        //查询条数
        for (SeckillTwo ab : seckillList) {
            if (null == ab.getProductCounts() || "".equals(ab.getProductCounts())) {
                ab.setCounts(0);
             } else{
                Integer i = (ab.getProductCounts().length() + 1) / 2;
               ab.setCounts(i);
            }
        }

        //查询条数
        for (Seckill a : seckillListSize) {
            //判断是否结束
            Date date = new Date();
            if (date.compareTo(a.getStarTime()) > 0 && date.compareTo(a.getEndTime()) <0) {
                System.out.println("开始时间+++++++++++++++++++++++++"+a.getStarTime());
                a.setStatus(1);
                iReturnthingsService.updateStatus(a.getSeckillId(), a.getStatus(), a.getPutOrNot());
            } else {
                SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
                a.setStatus(2);
                a.setPutOrNot(2);
                //修改状态
                iReturnthingsService.updateStatus(a.getSeckillId(), a.getStatus(), a.getPutOrNot());
            }
        }

        resultData.setDataSize(seckillListSize.size());
        resultData.setData(seckillList);
        return resultData;
    }

    //上架/下架
    @ResponseBody
    @RequestMapping("/putOrNot")
    public Integer putOrNot(Integer seckillId, Integer putOrNot) {
        try {
            iReturnthingsService.putOrNot(seckillId, putOrNot);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    //新增秒杀活动
    @ResponseBody
    @RequestMapping("/addSeckill")
    public Integer addSeckill(SeckillTwo seckill) {
        try {
            iReturnthingsService.addSeckill(seckill);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    //删除秒杀活动
    @ResponseBody
    @RequestMapping("/deleteSeckill")
    public Integer deleteSeckill(Integer seckillId) {
        try {
            iReturnthingsService.deleteSeckill(seckillId);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    //修改秒杀活动
    @ResponseBody
    @RequestMapping("/updateSeckill")
    public Integer updateSeckill(@Param("seckill") SeckillTwo seckill) {
        System.out.println(seckill.getTitle()+"============"+seckill.getStarTime());
        try {
            iReturnthingsService.updateSeckill(seckill);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    //根据秒杀查询商品
    @ResponseBody
    @RequestMapping("/productList")
    public ResultData productList(@RequestParam("currentPage") int currentPage,
                                  @RequestParam("pageSize") int pageSize, Integer seckillId) {
        Seckill seckill = iReturnthingsService.pc(seckillId);

        ResultData resultData = new ResultData();
        List<Product> productListSize = iReturnthingsService.productList(seckill.getProductCounts());

        PageHelper.startPage(currentPage, pageSize);
        List<Product> productList = iReturnthingsService.productList(seckill.getProductCounts());
        resultData.setDataSize(productListSize.size());
        resultData.setData(productList);
        return resultData;
    }

    //在活动中删除商品
    @ResponseBody
    @RequestMapping("/deleterProduct")
    public Integer deleterProduct(Integer pid,Integer seckillId) {
        try {
            Seckill seckill = iReturnthingsService.pc(seckillId);
            iReturnthingsService.deletepid(pid,seckill.getProductCounts(),seckillId);
            iReturnthingsService.deleterProduct(pid);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    //查询所有商品
    @ResponseBody
    @RequestMapping("/allProductList")
    public ResultData allProductList(@RequestParam("currentPage") int currentPage,
                                     @RequestParam("pageSize") int pageSize) {
        ResultData resultData = new ResultData();
        List<Product> productListSize = iReturnthingsService.allProductList();

        PageHelper.startPage(currentPage, pageSize);
        List<Product> productList = iReturnthingsService.allProductList();
        resultData.setDataSize(productListSize.size());
        resultData.setData(productList);
        return resultData;
    }

    //修改商品
    @ResponseBody
    @RequestMapping("/updateProductSubmint")
    public Integer updateProductSubmint(Product product) {
        try {
            iReturnthingsService.updateProductSubmint(product);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    //批量查询
    @ResponseBody
    @RequestMapping("/search")
    public ResultData search(@Param("batchList") String[] batchList) {
        ResultData resultData = new ResultData();
        List<Product> productList = iReturnthingsService.search(batchList);
        resultData.setData(productList);
        return resultData;
    }

    //批量添加
    @ResponseBody
    @PostMapping("/batchAdd")
    public Integer batchAdd(@RequestBody List<Product> product, @RequestParam("seckillId") Integer seckillId) {
        Seckill seckill = iReturnthingsService.pc(seckillId);
        StringBuffer a = new StringBuffer();
        for (int i = 0; i < product.size(); i++) {
            product.get(i).setSeckillId(seckillId);
            a.append(product.get(i).getPid());
            if (i < product.size() - 1) {
                a.append(",");
            }
        }
        if (!seckill.getProductCounts().equals("") && seckill.getProductCounts()!=null){
            a.append(",");
            a.append(seckill.getProductCounts());
        }
        try {
            iReturnthingsService.setProductCounts(a.toString(), seckillId);
            iProductService.saveOrUpdateBatch(product, product.size());
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

}
