package com.hy.manager.mapper.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.manager.entity.order.Returnmoney;
import com.hy.manager.entity.order.Returnreason;
import com.hy.manager.mapper.order.Dao.ReturnMoneyDao;
import org.apache.ibatis.annotations.*;

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
    public List<Returnmoney> selectReturnMoney(String serverNumber,String nameOrPhone,String time,Integer applyStatus);

    //退款原因列表
    @Select("select * from returnreason")
    public List<Returnreason> selectReturnReason();

    //退款原因是否启用
    @Update("update returnreason set reasonStatus=#{reasonStatus} where id=#{id}")
    public void OpenOrNotStatus(Integer id,Integer reasonStatus);

    //删除退款原因
    @Update("delete from returnreason  where id=#{id}")
    public void deleteReason(Integer id);

    //修改退款原因
    @Update("update returnreason set reason=#{reason} where id=#{id}")
    public void updateReason(Integer id,String reason);

    //新增退款原因
    @Insert("insert into returnreason(reason,reasonTime,reasonStatus) values (#{reason},now(),1)")
    public void addReason(String reason);

    //同意或者拒绝退款
    @Update("update returnmoney set applyStatus=#{applyStatus},dispose=now() where id=#{id}")
    public void agreeReturn(Integer id,Integer applyStatus);


    //批量
    @UpdateProvider(type = ReturnMoneyDao.class, method = "batch")
    public void batch(String[] batchList,String type);

}
