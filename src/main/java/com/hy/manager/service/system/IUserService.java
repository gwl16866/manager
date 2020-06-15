package com.hy.manager.service.system;

import com.hy.manager.entity.system.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
public interface IUserService extends IService<User> {

    public List<User> listselect();
    public void userupd(User user);
    public void del(String uid);
    public void add(User user);
    public int count();
    public int returnmonry();
    public int sales();
    public int ordercount();
    public ArrayList<String> selectSumUsers();
    public ArrayList<String> selectMessage();
    public ArrayList<String> selectMoney();
    public ArrayList<String> selectShopping();

}
