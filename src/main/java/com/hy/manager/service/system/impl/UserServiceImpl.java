package com.hy.manager.service.system.impl;

import com.hy.manager.entity.system.User;
import com.hy.manager.mapper.system.UserMapper;
import com.hy.manager.service.system.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
