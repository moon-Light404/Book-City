package com.ding.test;

import com.ding.pojo.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserServletTest {
    public void login() {
        System.out.println("这是login方法");
    }

    public void regist(){
        System.out.println("这是regist方法");
    }

    public void addUser(){
        System.out.println("这是addUser方法");
    }

    public void updateUserPassowrd(){
        System.out.println("这是修改方法");
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String action = "addUser";

        // 获得action字符串获取相应的业务 方法反射对象
        Method method = UserServletTest.class.getDeclaredMethod(action); // 得到字符串对应的方法
        // 调用目标业务方法
        method.invoke(new UserServletTest());
        System.out.println(method);

    }
}

