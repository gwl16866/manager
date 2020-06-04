package com.hy.manager.service.counts.impl;

import com.hy.manager.entity.counts.Quantity;
import com.hy.manager.mapper.counts.QuantityMapper;
import com.hy.manager.service.counts.IQuantityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
