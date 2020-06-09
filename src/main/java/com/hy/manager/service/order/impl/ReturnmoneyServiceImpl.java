package com.hy.manager.service.order.impl;

import com.hy.manager.entity.order.Returnmoney;
import com.hy.manager.entity.order.Returnreason;
import com.hy.manager.mapper.order.ReturnmoneyMapper;
import com.hy.manager.service.order.IReturnmoneyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class ReturnmoneyServiceImpl extends ServiceImpl<ReturnmoneyMapper, Returnmoney> implements IReturnmoneyService {

    @Autowired
    private ReturnmoneyMapper returnmoneyMapper;
//退款列表
    public List<Returnmoney> selectReturnMoney(String serverNumber,String nameOrPhone,String time,Integer applyStatus){
        return returnmoneyMapper.selectReturnMoney(serverNumber,nameOrPhone,time,applyStatus);
    }

    //退款原因列表
    public List<Returnreason> selectReturnReason(){
        return returnmoneyMapper.selectReturnReason();
    }

    //退款原因是否启用
    public void OpenOrNotStatus(Integer id,Integer reasonStatus){
        returnmoneyMapper.OpenOrNotStatus(id,reasonStatus);
    }

    //删除退款原因
    public void deleteReason(Integer id){
        returnmoneyMapper.deleteReason(id);
    }

    //修改退款原因
    public void updateReason(Integer id,String reason){
        returnmoneyMapper.updateReason(id,reason);
    }


    //新增退款原因
    public void addReason(String reason){
        returnmoneyMapper.addReason(reason);
    }

    //同意退款
    public void agreeReturn(Integer id,Integer applyStatus){
        returnmoneyMapper.agreeReturn(id,applyStatus);
    }

    //批量
    public void batch(String[] batchList,String type){
        returnmoneyMapper.batch(batchList,type);
    };
}
