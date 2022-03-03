package com.ding.service;

import com.ding.pojo.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     *
     * @param user
     * @return 如果返回null表示登录失败，返回有值就是成功
     */
    public User login(User user);

    /**
     * 判断用户名是否可用true表示已经存在，false表示用户名可用
     * @param username
     * @return
     */
    public boolean existsUsername(String username);

    /**
     * 更新用户信息
     * @param user
     */
    public void updateUser(User user);
}
