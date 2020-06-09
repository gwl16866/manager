package com.hy.manager.mapper.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.manager.entity.order.Returnthings;
import com.hy.manager.mapper.order.Dao.ReturnThingsDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

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
public interface ReturnthingsMapper extends BaseMapper<Returnthings> {

    //退货列表
    @SelectProvider(type = ReturnThingsDao.class, method = "selectReturnThings")
    public List<Returnthings> selectReturnThings(String serverNumber,String nameOrPhone,String time,Integer applyStatus);

    //同意或者拒绝退货
    @Update("update returnthings set applyStatus=#{applyStatus},dispose=now() where id=#{id}")
    public void agreeReturn(Integer id,Integer applyStatus);

    //批量
    @UpdateProvider(type = ReturnThingsDao.class, method = "batch")
    public void batch(String[] batchList,String type);
}
