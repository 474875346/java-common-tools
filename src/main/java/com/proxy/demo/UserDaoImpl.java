package com.proxy.demo;

public class UserDaoImpl implements UserDao {
    @Override
    public void Save(User user) {
        System.out.println("保存用户信息"+user.toString());
    }

    @Override
    public void Println() {

    }
}
