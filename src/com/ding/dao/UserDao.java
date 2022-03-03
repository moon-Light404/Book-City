package com.ding.dao;

import com.ding.pojo.User;

public interface UserDao {

    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return 如果返回null，说明没有这个用户，反之亦然
     */
    public User queryUserByUsername(String username);

    /**
     * 根据账号和密码查找信息
     * @param username 用户名
     * @param password 密码
     * @return 如果返回null，说明用户名或密码错误
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     * @param user
     * @return 返回-1 表示操作失败，其他是 sql 语句影响的行数
     */
    public int svaeUser(User user);

    // 更行用户信息
    public int updateUser(User user);
}
