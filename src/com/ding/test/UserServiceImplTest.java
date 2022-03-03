package com.ding.test;

import com.ding.service.UserService;
import com.ding.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    UserService userservice = new UserServiceImpl();
    @Test
    public void registUser() {
    }

    @Test
    public void login() {
    }

    @Test
    public void existsUsername() {
        if(userservice.existsUsername("1231321")){
            System.out.println("用户名已存在");
        }else{
            System.out.println("可以注册---");
        }
    }
}