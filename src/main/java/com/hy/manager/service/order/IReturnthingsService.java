package com.hy.manager.service.order;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.manager.entity.order.Returnthings;
import com.hy.manager.entity.order.Seckill;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
public interface IReturnthingsService extends IService<Returnthings> {
//退货列表
    public List<Returnthings> selectReturnThings(String serverNumber,String nameOrPhone,String time,Integer applyStatus);

    //同意退货
    public void agreeReturn(Integer id,Integer applyStatus);

    //批量
    public void batch(String[] batchList,String type);

    //秒杀
    public List<Seckill> selectSeckill(Seckill seckill);

    //上架/下架
    public void putOrNot(Integer seckillId,Integer putOrNot);

    //新增秒杀活动
    public void addSeckill(String title , String starTime, String endTime, String seckillStarTime, String seckillEndTime);


    //商品数量
    public Integer seckillCounts(Integer seckillId);
}
