package com.hy.manager.controller.system;


import com.github.pagehelper.PageHelper;
import com.hy.manager.Date.ResultData;
import com.hy.manager.entity.product.ClassModel;
import com.hy.manager.entity.system.Permiss;
import com.hy.manager.entity.system.Role;
import com.hy.manager.entity.system.RoleData;
import com.hy.manager.mapper.system.RoleMapper;
import com.hy.manager.service.system.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;


    /**
     * 查询role列表
     * @param currentPage
     * @param pageSize
     * @param name
     * @return
     */
    @RequestMapping("/queryRoles")
    public ResultData queryRoles(@RequestParam("currentPage") int currentPage,
                                 @RequestParam("pageSize") int pageSize,
                                 String name){
        ResultData resultData = new ResultData();
        List<Role> list = roleService.queryRoles(name);
        PageHelper.startPage(currentPage,pageSize);
        resultData.setData(roleService.queryRoles(name));
        resultData.setDataSize(list.size());
        return resultData;

    }

    /**
     * 查询所有可用角色
     * @return
     */
    @RequestMapping("/queryGoodRoles")
    public List<Role> queryGoodRoles(){
        return roleService.queryGoodRoles();
    }





    /**
     * 添加新角色
     * @param role
     * @return
     */
    @RequestMapping("/addRole")
    public Integer addRole(Role role){
        return roleService.addRole(role);
    }



    /**
     * 修改状态 是否可以使用
     * @param role
     * @return
     */
    @RequestMapping("/updateRoleStatus")
    public Integer updateRoleStatus(Role role){
        return roleService.updateRoleStatus(role);
    }

    /**
     * 修改名字
     * @param role
     * @return
     */
    @RequestMapping("/updateRoleName")
    public Integer updateRoleName(Role role){
        return roleService.updateRoleName(role);
    }


    /**
     * 根据uid查询角色
     * @return
     */
    @RequestMapping("/queryRolesById")
    public List<Integer> queryRolesById(Integer uid){
        return roleService.queryRolesById(uid);
    }


    /**
     * 查询全部权限 以及 角色权限
     * @param rid
     * @return
     */
    @RequestMapping("/queryRolePerms")
    public RoleData setRolePerms(Integer rid) {
        RoleData roleData = new RoleData();
        //装全部权限
        List<Permiss> list = new ArrayList<>();
        //查询一级权限
        List<Permiss> first = roleService.queryFirstPermission();
        //递归查询 二三级 权限
        if(first.size()>0 && !first.isEmpty()){
            list =  roleService.recursionHands(first);
        }
        //根据rid查角色权限
        List<Integer> roleHavePerms = roleService.roleHaveHand(rid);

        roleData.setAllPerms(list);
        roleData.setHavePerms(roleHavePerms);
        return roleData;
    }


    @RequestMapping("/deleteRolePermsByRid")
    public Integer deleteRolePermsByRid(String[] havePerms,Integer rid){
      return  roleService.deleteAndAddRolePerms(havePerms,rid);
    }







}
