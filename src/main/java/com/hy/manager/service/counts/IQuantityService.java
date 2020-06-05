package com.hy.manager.service.counts;

import com.hy.manager.entity.counts.Quantity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
public interface IQuantityService extends IService<Quantity> {
    //库存列表
    public List<Quantity> selectQuantity(String productOrNumber, Integer status,String time);

}
