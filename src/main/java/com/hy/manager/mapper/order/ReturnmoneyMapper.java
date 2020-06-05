package com.hy.manager.mapper.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.manager.entity.order.Returnmoney;
import com.hy.manager.entity.order.Returnreason;
import com.hy.manager.mapper.order.Dao.ReturnMoneyDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

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
public interface ReturnmoneyMapper extends BaseMapper<Returnmoney> {

    //退款列表
    @SelectProvider(type = ReturnMoneyDao.class, method = "selectReturnMoney")
    public List<Returnmoney> selectReturnMoney(String serverNumber,Integer applyStatus,String time);

    //退款原因列表
    @Select("select * from returnreason")
    public List<Returnreason> selectReturnReason();

    //退款原因是否启用
    @Update("update returnreason set reasonStatus=#{reasonStatus} where id=#{id}")
    public void OpenOrNotStatus(Integer id,Integer reasonStatus);

    //删除退款原因
    @Update("delete from returnreason  where id=#{id}")
    public void deleteReason(Integer id);


}
