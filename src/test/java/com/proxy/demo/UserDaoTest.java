package com.proxy.demo;


import org.testng.annotations.Test;
import java.lang.reflect.Proxy;

import java.lang.reflect.Proxy;

public class UserDaoTest {

    @Test
    private void DaoSave(){
        User user = new User();
        user.setName("张三");
        user.setAge(10);

        UserDao dao = new UserDaoImpl();
        dao.Save(user);
    }

    @Test
    private void DaoSaveProxy(){
        User user = new User();
        user.setName("张三");
        user.setAge(-10);

        UserDao proxy = new UserDaoImpl();
        UserDao dao = new UserDaoProxy(proxy);
        dao.Save(user);
    }

    @Test
    public void DaoSaveDynamicProxy() {
        User user = new User();
        user.setName("张三");
        user.setAge(10);
        UserDao dao = new UserDaoImpl();

        ClassLoader classLoader = dao.getClass().getClassLoader();
        Class[] interfaces = dao.getClass().getInterfaces();
        UserDaoDynamicProxy daoDynamicProxy = new UserDaoDynamicProxy(dao);

        UserDao proxy = (UserDao) Proxy.newProxyInstance(classLoader,interfaces,daoDynamicProxy);
        proxy.Save(user);
        proxy.Println();
    }


    public static void DaoSaveCglib() {
        UserDaoCglib daoCglib = new UserDaoCglib();
        User user = new User();
        user.setName("张三");
        user.setAge(-10);

        UserDaoCglib proxy = (UserDaoCglib) new UserDaoCgligProxy(daoCglib).getProxyInstance();
        proxy.Save(user);
        proxy.Println();

    }

    public static void main(String[] args) {
        UserDaoTest.DaoSaveCglib();
    }
}
