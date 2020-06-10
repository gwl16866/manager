package com.hy.manager.mapper.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.manager.entity.order.Returnthings;
import com.hy.manager.entity.order.Seckill;
import com.hy.manager.mapper.order.Dao.ReturnThingsDao;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@Mapper
public interface ReturnthingsMapper extends BaseMapper<Returnthings> {

    //退货列表
    @SelectProvider(type = ReturnThingsDao.class, method = "selectReturnThings")
    public List<Returnthings> selectReturnThings(String serverNumber,String nameOrPhone,String time,Integer applyStatus);

    //同意或者拒绝退货
    @Update("update returnthings set applyStatus=#{applyStatus},dispose=now() where id=#{id}")
    public void agreeReturn(Integer id,Integer applyStatus);

    //批量
    @UpdateProvider(type = ReturnThingsDao.class, method = "batch")
    public void batch(String[] batchList,String type);

    //退货列表
    @SelectProvider(type = ReturnThingsDao.class, method = "selectSeckill")
    public List<Seckill> selectSeckill(Seckill seckill);


    //上架/下架
    @Update("update seckill set putOrNot=#{putOrNot} where seckillId=#{seckillId}")
    public void putOrNot(Integer seckillId,Integer putOrNot);

    //新增
    @Insert("insert into seckill(title,status,starTime,endTime,putOrNot,seckillStarTime,seckillEndTime) values(#{title},1,#{starTime},#{endTime},1,#{seckillStarTime},#{seckillEndTime})")
    public void addSeckill(String title , String starTime, String endTime, String seckillStarTime, String seckillEndTime);

    //商品条数
    @Select("select count(seckillId) from product where seckillId=#{seckillId}")
    public Integer seckillCounts(Integer seckillId);

}
