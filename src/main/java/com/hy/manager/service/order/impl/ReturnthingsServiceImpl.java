package com.hy.manager.service.order.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.manager.entity.order.Returnthings;
import com.hy.manager.entity.order.Seckill;
import com.hy.manager.mapper.order.ReturnthingsMapper;
import com.hy.manager.service.order.IReturnthingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public List<Returnthings> selectReturnThings(String serverNumber,String nameOrPhone,String time,Integer applyStatus){
        return returnthingsMapper.selectReturnThings(serverNumber,nameOrPhone,time,applyStatus);
    }

    //同意退货
    public void agreeReturn(Integer id,Integer applyStatus){
        returnthingsMapper.agreeReturn(id,applyStatus);
    }

    //批量
    public void batch(String[] batchList,String type){
            returnthingsMapper.batch(batchList,type);
    }
    //秒杀
    public List<Seckill> selectSeckill(Seckill seckill){
        return  returnthingsMapper.selectSeckill(seckill);
    }

    //上架/下架
    public void putOrNot(Integer seckillId,Integer putOrNot){
        returnthingsMapper.putOrNot(seckillId,putOrNot);
    };


    //新增秒杀
    public void addSeckill(String title , String starTime, String endTime, String seckillStarTime, String seckillEndTime){
        returnthingsMapper.addSeckill(title, starTime, endTime, seckillStarTime, seckillEndTime);
    };

    //商品数量
    public Integer seckillCounts(Integer seckillId){
        return returnthingsMapper.seckillCounts(seckillId);
    };
}
