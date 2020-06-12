package com.hy.manager.mapper.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.manager.entity.order.Returnthings;
import com.hy.manager.entity.order.Seckill;
import com.hy.manager.entity.product.Product;
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

    //秒杀列表
    @SelectProvider(type = ReturnThingsDao.class, method = "selectSeckill")
    public List<Seckill> selectSeckill(Seckill seckill);


    //上架/下架
    @Update("update seckill set putOrNot=#{putOrNot} where seckillId=#{seckillId}")
    public void putOrNot(Integer seckillId,Integer putOrNot);

    //新增
    @Insert("insert into seckill(title,status,starTime,endTime,putOrNot,seckillStarTime,seckillEndTime) values(#{title},1,#{starTime},#{endTime},1,#{seckillStarTime},#{seckillEndTime})")
    public void addSeckill(Seckill seckill);

    //商品条数
    @Select("select count(seckillId) from product where seckillId=#{seckillId}")
    public Integer seckillCounts(Integer seckillId);


    //删除秒杀
    @Update("update seckill set status=3  where seckillId=#{seckillId}")
    public Integer deleteSeckill(Integer seckillId);

    //修改秒杀
    @Update("update seckill set title=#{title},status=#{status},starTime=#{starTime},endTime=#{endTime},putOrNot=#{putOrNot},seckillStarTime=#{seckillStarTime},seckillEndTime=#{seckillEndTime} where seckillId=#{seckillId}")
    public void updateSeckill(Seckill seckill);

    //修改秒杀
    @Update("update seckill set status=#{status},putOrNot=#{putOrNot} where seckillId=#{seckillId}")
    public void updateStatus(Integer seckillId,Integer status,Integer putOrNot);


    //查询秒杀商品
    @Select("select * from product where upStatus=1 and status=1 and seckillId=#{seckillId}")
    public List<Product> productList(Integer seckillId);


    //在活动中下架商品
    @Update("update product set seckillId=null where pid=#{pid}")
    public void deleterProduct(Integer pid);

    //查询所有商品
    @Select("select p.* from product p where p.seckillId is null or p.seckillId in(select seckillId from  seckill where status !=1) and p.upStatus=1 and p.status=1 ")
    public List<Product> allProductList();

    //修改商品
    @Update("update product set seckillPrice=#{seckillPrice},seckillNumber=#{seckillNumber},residueNumber=#{residueNumber},purchaseNumber=#{purchaseNumber} where pid=#{pid}")
    public void updateProductSubmint(Product product);

    //批量查询
    @SelectProvider(type = ReturnThingsDao.class, method = "search")
    public List<Product> search(@Param("batchList")String[] batchList);
}
