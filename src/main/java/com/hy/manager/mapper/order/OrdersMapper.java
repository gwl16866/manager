package com.hy.manager.mapper.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.manager.entity.order.Orders;
import com.hy.manager.mapper.order.Dao.OrderDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

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
public interface OrdersMapper extends BaseMapper<Orders> {
    //订单列表
    @SelectProvider(type = OrderDao.class, method = "selectOrders")
    public List<Orders> selectOrders(String orderOrProduct,String nameOrPhone,String time);

    //查看订单详情
    @Select("select o.*,c.*,p.* from orders o,product p,customer c where o.userId=c.id and o.productId=p.pid and o.orderNumber =#{orderNumber} ")
    public Orders lookOrders(String orderNumber);


    //修改
    @Update("update orders set cname=#{cname},caddress=#{caddress},cphone=#{cphone} where id=#{id}")
    public void updateInfo(String cname,String caddress,String cphone,Integer id);
}
