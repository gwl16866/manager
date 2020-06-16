package com.hy.manager.mapper.system;

import com.hy.manager.entity.product.ClassesBo;
import com.hy.manager.entity.system.Permiss;
import com.hy.manager.entity.system.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.manager.entity.system.Rolepermission;
import com.hy.manager.mapper.product.ProductProvider;
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
public interface RoleMapper extends BaseMapper<Role> {



    /**
     * @return 查询所有角色分页
     */
    @SelectProvider(type = RoleProvider.class,method = "queryRoles")
    public List<Role> queryRoles(String name);

    @Select("select * from role where status=1")
    public List<Role> queryGoodRoles();

    /**
     * 根据用户id查询拥有角色
     * @param uid
     * @return
     */
    @Select("select rid from userrole where uid =#{uid}")
    public List<Integer> queryRolesById(Integer uid);

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

    /**
     * 修改角色名称
     * @param role
     * @return
     */
    @Update("update role set roleName=#{roleName} where rid=#{rid}")
    public Integer updateRoleName(Role role);



    /**
     * 查询一级权限
     * @return
     */
    @Select("select pid,permissionName from permiss where parentId is null")
    public List<Permiss> queryFirstPermission();


    /**
     * 根据父级id查询权限
     * @param parentId
     * @return
     */
    @Select(" select pid,permissionName from permiss where parentId=#{parentId}")
    public List<Permiss> secondThirdHand(Integer parentId);



    /**
     * rid 查询角色权限
     */
    @Select("select pid from rolepermission where rid =#{rid}")
    public List<Integer> roleHaveHand(Integer rid);



    @Delete("delete from rolepermission where rid=#{rid}")
    public Integer deleteRolePermsByRid(Integer rid);



    @InsertProvider(type = RoleProvider.class,method = "addRolePerms")
    public Integer addRolePerms(@Param("haveRoles") String [] havePerms,@Param("rid") Integer rid);

}
