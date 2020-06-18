package com.hy.manager.realm;


import com.hy.manager.entity.system.User;
import com.hy.manager.service.system.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Iterator;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;


    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 先拿到用户名

 String userName = (String) principalCollection.getPrimaryPrincipal();
//        User u = userService.selectDengLuRen(userName);
//        Integer uid = u.getUid();
//
//       // 根据用户uid查询 角色 和 权限
//
//        // 用户角色
//        HashSet<String> userRoleList = userService.selectRoleByUid(uid);
//
//        // 用户权限
//        HashSet<String> userHandList = userService.selectHandNameByUid(uid);
//
//        // 角色权限
//        HashSet<String> userRoleHandList = userService.selectRoleHandNameByUid(uid);
//
//        //把角色权限放入用户权限
//        Iterator roleHand=userRoleHandList.iterator();
//        while (roleHand.hasNext()){
//           userHandList.add((String) roleHand.next());
//        }
//
//        Iterator it=userHandList.iterator();
//        while (it.hasNext()){
//            System.out.println("全部权限---------------"+it.next());
//        }
//
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        authorizationInfo.setRoles(userRoleList);
//        authorizationInfo.addStringPermissions(userHandList);

        return null;
    }


    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

       UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String username = usernamePasswordToken.getUsername();
        // 根据用户名查询数据库
        User user=userService.login(username);

        if(user == null){
            throw new UnknownAccountException("此用户不存在");
        }
         //变成盐
       // ByteSource salt=ByteSource.Util.bytes(user.getUserName());
         //加盐
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),getName());
         //返回校验
        return authenticationInfo;
    }


}

