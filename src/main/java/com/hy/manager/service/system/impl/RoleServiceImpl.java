package com.hy.manager.service.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
    public Integer updateRoleStatus(Role role) {
        return roleMapper.updateRoleStatus(role);
    }

    @Override
    public Integer updateRoleName(Role role) {
        return roleMapper.updateRoleName(role);
    }
}
