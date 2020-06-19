package com.hy.manager.service.order;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.manager.entity.order.Returnthings;
import com.hy.manager.entity.order.Seckill;
import com.hy.manager.entity.order.SeckillTwo;
import com.hy.manager.entity.product.Product;
import org.apache.ibatis.annotations.Param;

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
    //秒杀
    public List<SeckillTwo> selectSeckillTwo(Seckill seckill);

    //上架/下架
    public void putOrNot(Integer seckillId,Integer putOrNot);

    //新增秒杀活动
    public void addSeckill(SeckillTwo seckill);


    //商品数量
    public Integer seckillCounts(Integer seckillId);

    //删除秒杀
    public Integer deleteSeckill(Integer seckillId);


    //修改秒杀
    public void updateSeckill(SeckillTwo seckill);

    //修改活动状态
    public void updateStatus(Integer seckillId,Integer status,Integer putOrNot);
/*    //修改活动状态
    public void updateSta(Integer seckillId,Integer status);*/

    //查询秒杀商品
    public List<Product> productList(String c);


    //在活动中删除商品
    public void deleterProduct(Integer pid);
    public void deletepid(Integer pid,String c,Integer seckillId);

    //查询所有商品
    public List<Product> allProductList();

    //修改商品
    public void updateProductSubmint(Product product);


    //批量查询
    public List<Product> search(@Param("batchList")String[] batchList);


    public void setProductCounts(String productCounts,Integer seckillId);
    public Seckill pc(Integer seckillId);

}
