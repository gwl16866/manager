package com.hy.manager.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.manager.entity.system.Permiss;
import com.hy.manager.entity.system.Role;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
public interface IRoleService extends IService<Role> {

    public List<Role> queryRoles(String name);
    public List<Role> queryGoodRoles();
    public List<Integer> queryRolesById(Integer uid);
    public Integer addRole(Role role);
    public Integer deleteAndAddRolePerms(String[] havePerms,Integer rid);
    public Integer updateRoleStatus(Role role);
    public Integer updateRoleName(Role role);
    public  List<Permiss> queryFirstPermission();
    public List<Permiss> secondThirdHand(Integer parentId);
    public List<Permiss> recursionHands(List<Permiss> list);
    public List<Integer> roleHaveHand(Integer rid);

}
