package com.hy.manager.service.order.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.manager.entity.order.Returnthings;
import com.hy.manager.mapper.order.ReturnthingsMapper;
import com.hy.manager.service.order.IReturnthingsService;
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
public class ReturnthingsServiceImpl extends ServiceImpl<ReturnthingsMapper, Returnthings> implements IReturnthingsService {

    @Autowired
    private ReturnthingsMapper returnthingsMapper;

    //退货列表
    public List<Returnthings> selectReturnThings(String serverNumber,String nameOrPhone,String time,Integer applyStatus){
        return returnthingsMapper.selectReturnThings(serverNumber,nameOrPhone,time,applyStatus);
    }

    //同意退货
    public void agreeReturn(Integer id,Integer applyStatus){
        returnthingsMapper.agreeReturn(id,applyStatus);
    }

    //批量
    public void batch(String[] batchList,String type){
            returnthingsMapper.batch(batchList,type);
    }
}
