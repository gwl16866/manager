package com.hy.manager.service.system.impl;

import com.hy.manager.entity.system.User;
import com.hy.manager.mapper.system.UserMapper;
import com.hy.manager.service.system.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> listselect() {
        return userMapper.listselect();
    }

    @Override
    public void userupd(User user) {
        userMapper.userupd(user);
    }

    @Override
    public void del(String uid) {
         userMapper.del(uid);
    }

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public int count() {
        return userMapper.count();
    }

    @Override
    public int returnmonry() {
        return userMapper.returnmonery();
    }

    @Override
    public int sales() {
        return userMapper.sales();
    }

    @Override
    public int ordercount() {
        return userMapper.ordercount();
    }
}
