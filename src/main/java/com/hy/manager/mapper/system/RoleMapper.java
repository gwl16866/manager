package com.hy.manager.mapper.system;

import com.hy.manager.entity.product.ClassesBo;
import com.hy.manager.entity.system.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.manager.mapper.product.ProductProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
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
public interface RoleMapper extends BaseMapper<Role> {



    /**
     * @return 查询所有角色分页
     */
    @SelectProvider(type = RoleProvider.class,method = "queryRoles")
    public List<Role> queryRoles(String name);


    /**
     * 添加角色
     * @param role
     * @return
     */
    @Insert("insert into role(roleName,status) values (#{roleName},#{status})")
    public Integer addRole(Role role);


    /**
     * 修改状态
     * @param role
     * @return
     */
    @Update("update role set status=#{status} where rid=#{rid}")
    public Integer updateRoleStatus(Role role);


    @Update("update role set roleName=#{roleName} where rid=#{rid}")
    public Integer updateRoleName(Role role);




}
