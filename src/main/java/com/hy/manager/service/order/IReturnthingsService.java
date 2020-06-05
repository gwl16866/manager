package com.hy.manager.service.order;

import com.hy.manager.entity.order.Returnthings;
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
public interface IReturnthingsService extends IService<Returnthings> {

    public List<Returnthings> selectReturnThings(String serverNumber,String nameOrPhone,String time);
}
