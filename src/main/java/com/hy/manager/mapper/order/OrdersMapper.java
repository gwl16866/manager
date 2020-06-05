package com.hy.manager.mapper.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.manager.entity.order.Orders;
import com.hy.manager.mapper.order.Dao.OrderDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

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
}
