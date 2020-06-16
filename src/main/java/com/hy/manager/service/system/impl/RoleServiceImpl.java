package com.hy.manager.service.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.manager.entity.system.Permiss;
import com.hy.manager.entity.system.Role;
import com.hy.manager.mapper.system.RoleMapper;
import com.hy.manager.service.system.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> queryRoles(String name) {
        return roleMapper.queryRoles(name);
    }

    @Override
    public List<Role> queryGoodRoles() {
        return roleMapper.queryGoodRoles();
    }

    @Override
    public List<Integer> queryRolesById(Integer uid) {
        return roleMapper.queryRolesById(uid);
    }

    @Override
    public Integer addRole(Role role) {
        return roleMapper.addRole(role);
    }

    @Override
    public Integer deleteAndAddRolePerms(String[] havePerms, Integer rid) {
        Integer i = roleMapper.deleteRolePermsByRid(rid);
        Integer n = roleMapper.addRolePerms(havePerms,rid);
        if(i >= 1 && n>= 1){
            return 1;
        }else{
            return 0;
        }


    }

    @Override
    public Integer updateRoleStatus(Role role) {
        return roleMapper.updateRoleStatus(role);
    }

    @Override
    public Integer updateRoleName(Role role) {
        return roleMapper.updateRoleName(role);
    }

    @Override
    public List<Permiss> queryFirstPermission() {
        return roleMapper.queryFirstPermission();
    }

    @Override
    public List<Permiss> secondThirdHand(Integer parentId) {
        return roleMapper.secondThirdHand(parentId);
    }

    @Override
    public List<Permiss> recursionHands(List<Permiss> list) {
        if(null != list && !list.isEmpty()){
            for(Permiss firstHands:list){
                List<Permiss> secondList=secondThirdHand(firstHands.getPid());
                firstHands.setRolesList(secondList);
                recursionHands(secondList);
            }
        }
        return list;
    }

    @Override
    public List<Integer> roleHaveHand(Integer rid) {
        return roleMapper.roleHaveHand(rid);
    }
}
