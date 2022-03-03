package com.ding.service.impl;

import com.ding.dao.UserDao;
import com.ding.dao.impl.UserDaoImpl;
import com.ding.pojo.User;
import com.ding.service.UserService;

// 实现用户业务UserService接口
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    // 注册功能参数是一个User类
    public void registUser(User user) {
        userDao.svaeUser(user);
    }
    @Override
    // 登录功能
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
    @Override
    // 是否存在某个用户名
    public boolean existsUsername(String username) {
        if(userDao.queryUserByUsername(username) == null){
            return false;
        }
        return true;
    }
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
