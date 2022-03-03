package com.ding.dao.impl;

import com.ding.dao.UserDao;
import com.ding.pojo.User;

// 实现UserDao接口,操作数据库中表的数据
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from t_user where username=? ";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username = ? and password =?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int svaeUser(User user) {
        String sql = "insert into t_user(sname,username,password,email) values(?,?,?,?)";
        return update(sql,user.getSname(),user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public int updateUser(User user) {
        String sql = "update t_user set sname = ?,password= ?,email = ? where username = ?";
        return update(sql,user.getSname(),user.getPassword(),user.getEmail(),user.getUsername());
    }
}
