package com.hy.manager.mapper.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.manager.entity.order.Returnthings;
import com.hy.manager.mapper.order.Dao.ReturnThingsDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

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
    public List<Returnthings> selectReturnThings(String serverNumber,String nameOrPhone,String time);

}
