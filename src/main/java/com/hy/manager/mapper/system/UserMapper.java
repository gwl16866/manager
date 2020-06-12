package com.hy.manager.mapper.system;

import com.hy.manager.entity.system.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where status=1")
    public List<User> listselect();

    @Update("update user set userName=#{userName},password=#{password},sex=#{sex},phoneNo=#{phoneNo},email=#{email} where uid=#{uid} ")
    public void userupd(User user);

    @Delete("update user set status=2 where uid=#{value}")
    public void del(String uid);

    @Insert("insert into user(userName,password,sex,phoneNo,email,status) values(#{userName},#{password},#{sex},#{phoneNo},#{email},1)")
    public  void add(User user);

    @Select("select count(*) from user")
    public int count();

    @Select("select count(*) from returnmoney")
    public int returnmonery();

    @Select("select sum(sumMoney) from orders")
    public int sales();

    @Select("select count(*) from orders")
    public int ordercount();
}
