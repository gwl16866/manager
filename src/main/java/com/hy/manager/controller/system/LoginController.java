package com.hy.manager.controller.system;

import com.hy.manager.Date.ResultData;
import com.hy.manager.entity.system.LoginData;
import com.hy.manager.entity.system.LoginForm;
import com.hy.manager.service.system.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/login")
@RestController
public class LoginController {
    //日志
    UsernamePasswordToken token=null;


    /**
     * 登录
     * @param loginForm
     * @return
     */
    @PostMapping("/login")
    public LoginData login(@RequestBody LoginForm loginForm) {
        LoginData resultData = new LoginData();
        resultData.setCode(20000);
        resultData.setMsg("登录成功");
         token = new UsernamePasswordToken(loginForm.getUsername(), loginForm.getPassword());
        resultData.setData(token);
        Subject subject = SecurityUtils.getSubject();
          //shiro框架进行登录验证
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            resultData.setMsg("用户名不存在");
            return resultData;
        } catch (IncorrectCredentialsException e) {
            resultData.setMsg("密码错误");
            return resultData;
        }
        return resultData;
    }


    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "退出成功";
    }

    /**
     * 获取登陆用户信息
     * @return
     */
    @RequestMapping("/info")
    public LoginData info(){
        LoginData resultData = new LoginData();
        resultData.setCode(200);
        resultData.setMsg("获取信息");
        resultData.setData(token);
        return resultData;
    }

    /**
     * 未登录跳转的页面
     * @return
     */
    @RequestMapping("/needLogin")
    public LoginData needLogin(){
        LoginData resultData = new LoginData();
        resultData.setCode(500);
        resultData.setMsg("您需要登录");
        return resultData;
    }

    /**
     * 没有权限跳转的页面
     * @return
     */
    @RequestMapping("/needPerms")
    public LoginData needPerms(){
        LoginData resultData = new LoginData();
        resultData.setCode(500);
        resultData.setMsg("您没有这个权限");
        return resultData;
    }


}

