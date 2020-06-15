package com.hy.manager.controller.system;


import com.github.pagehelper.PageHelper;
import com.hy.manager.Date.ResultData;
import com.hy.manager.entity.product.ClassModel;
import com.hy.manager.entity.system.Role;
import com.hy.manager.service.system.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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








}
