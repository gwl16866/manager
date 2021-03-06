package com.hy.manager.mapper.system;

import com.hy.manager.entity.system.DeskPojo;
import com.hy.manager.entity.system.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.manager.mapper.customer.CustomerProvider;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
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


    @SelectProvider(type =UserProvider.class, method = "selectUser")
    public List<User> listselect(User user);

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

    @Select("SELECT COUNT(*) val,DATE_FORMAT(insert_date,'%m') month FROM user GROUP BY DATE_FORMAT(insert_date,'%Y%m')ORDER BY DATE_FORMAT(insert_date,'%Y%m')")
    public ArrayList<DeskPojo> selectSumUsers();

    @Select("SELECT COUNT(*)val,DATE_FORMAT(applyTime,'%m') month FROM returnmoney GROUP BY DATE_FORMAT(applyTime,'%Y%m') ORDER BY DATE_FORMAT(applyTime,'%Y%m')")
    public ArrayList<DeskPojo> selectMessage();

    @Select("SELECT sum(sumMoney) val,DATE_FORMAT(submitDate,'%m') month FROM orders GROUP BY DATE_FORMAT(submitDate,'%Y%m') ORDER BY DATE_FORMAT(submitDate,'%Y%m')")
    public ArrayList<DeskPojo> selectMoney();

    @Select("SELECT COUNT(*)val,DATE_FORMAT(submitDate,'%m') month FROM orders GROUP BY DATE_FORMAT(submitDate,'%Y%m') ORDER BY DATE_FORMAT(submitDate,'%Y%m')")
    public ArrayList<DeskPojo> selectShopping();

    @InsertProvider(type = RoleProvider.class,method = "addUserRoles")
    public Integer addUserRoles(@Param("uid") Integer uid,@Param("haveRoles") String[] haveRoles);


    @Delete("delete from userrole where uid =#{uid}")
    public Integer deleteUserRoles(Integer uid);


    @Select("select * from user where userName=#{userName}")
    public User login(String userName);


}
