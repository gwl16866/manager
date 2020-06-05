package com.hy.manager.service.order;

import com.hy.manager.entity.order.Returnmoney;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.manager.entity.order.Returnreason;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
public interface IReturnmoneyService extends IService<Returnmoney> {
    //退款列表
    public List<Returnmoney> selectReturnMoney(String serverNumber,Integer applyStatus,String time);

    //退款原因列表
    public List<Returnreason> selectReturnReason();

    //退款原因是否启用
    public void OpenOrNotStatus(Integer id,Integer reasonStatus);

    //删除退款原因
    public void deleteReason(Integer id);

}
