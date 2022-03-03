package com.ding.test;

import com.ding.dao.UserDao;
import com.ding.dao.impl.UserDaoImpl;
import com.ding.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
    }

    @Test
    public void queryUserByUsernameAndPassword() {
    }

    @Test
    public void svaeUser() {
        System.out.println(userDao.svaeUser(new User(null,"小明","1231321","123456789","12313@qq.com")));
    }
}