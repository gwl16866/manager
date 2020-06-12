package com.hy.manager.service.order.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.manager.entity.order.Returnthings;
import com.hy.manager.entity.order.Seckill;
import com.hy.manager.entity.product.Product;
import com.hy.manager.mapper.order.ReturnthingsMapper;
import com.hy.manager.service.order.IReturnthingsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@Service
public class ReturnthingsServiceImpl extends ServiceImpl<ReturnthingsMapper, Returnthings> implements IReturnthingsService {

    @Autowired
    private ReturnthingsMapper returnthingsMapper;

    //退货列表
    public List<Returnthings> selectReturnThings(String serverNumber, String nameOrPhone, String time, Integer applyStatus) {
        return returnthingsMapper.selectReturnThings(serverNumber, nameOrPhone, time, applyStatus);
    }

    //同意退货
    public void agreeReturn(Integer id, Integer applyStatus) {
        returnthingsMapper.agreeReturn(id, applyStatus);
    }

    //批量
    public void batch(String[] batchList, String type) {
        returnthingsMapper.batch(batchList, type);
    }

    //秒杀
    public List<Seckill> selectSeckill(Seckill seckill) {
        return returnthingsMapper.selectSeckill(seckill);
    }

    //上架/下架
    public void putOrNot(Integer seckillId, Integer putOrNot) {
        returnthingsMapper.putOrNot(seckillId, putOrNot);
    }



    //新增秒杀
    public void addSeckill(Seckill seckill) {
        returnthingsMapper.addSeckill(seckill);
    }



    //商品数量
    public Integer seckillCounts(Integer seckillId) {
        return returnthingsMapper.seckillCounts(seckillId);
    }



    //删除秒杀
    public Integer deleteSeckill(Integer seckillId) {
        return returnthingsMapper.deleteSeckill(seckillId);
    }



    //修改秒杀
    public void updateSeckill(Seckill seckill) {
        returnthingsMapper.updateSeckill(seckill);
    }

    //修改活动状态
    public void updateStatus(Integer seckillId, Integer status, Integer putOrNot) {
        returnthingsMapper.updateStatus(seckillId, status, putOrNot);
    }
//    //修改活动状态
//    public void updateSta(Integer seckillId, Integer status) {
//        returnthingsMapper.updateSta(seckillId, status);
//    }


    //查询秒杀商品
    public  List<Product> productList(Integer seckillId){
        return  returnthingsMapper.productList(seckillId);
    };

    //在活动中下架商品
    public void deleterProduct(Integer pid){
        returnthingsMapper.deleterProduct(pid);
    }

    //查询所有商品
    public List<Product> allProductList(){
        return  returnthingsMapper.allProductList();
    };

    //修改商品
    public void updateProductSubmint(Product product){
        returnthingsMapper.updateProductSubmint(product);
    };

    //批量查询
    public List<Product> search(@Param("batchList")String[] batchList){
       return  returnthingsMapper.search(batchList);
    }
}
