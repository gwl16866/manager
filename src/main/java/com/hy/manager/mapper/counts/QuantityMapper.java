package com.hy.manager.mapper.counts;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.manager.entity.counts.Quantity;
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
public interface QuantityMapper extends BaseMapper<Quantity> {
    //库存列表
    @SelectProvider(type = QuantityDao.class, method = "selectQuantity")
    public List<Quantity> selectQuantity(String productOrNumber, String controlClass,String time);
}
