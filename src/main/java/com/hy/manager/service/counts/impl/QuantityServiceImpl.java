package com.hy.manager.service.counts.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.manager.entity.counts.Quantity;
import com.hy.manager.mapper.counts.QuantityMapper;
import com.hy.manager.service.counts.IQuantityService;
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
public class QuantityServiceImpl extends ServiceImpl<QuantityMapper, Quantity> implements IQuantityService {

    @Autowired
    QuantityMapper quantityMapper;

    //库存列表
    public List<Quantity> selectQuantity(String productOrNumber, String controlClass,String time){
        return quantityMapper.selectQuantity(productOrNumber, controlClass,time);
    };
}
