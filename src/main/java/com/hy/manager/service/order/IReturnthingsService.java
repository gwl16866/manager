package com.hy.manager.service.order;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.manager.entity.order.Returnthings;

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
}
