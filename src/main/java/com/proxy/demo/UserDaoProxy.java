package com.proxy.demo;

public class UserDaoProxy implements UserDao {
    private UserDao target;

    public UserDaoProxy(UserDao userDao) {
        this.target = userDao;
    }
    @Override
    public void Save(User user) {
        if (user.getName() == null || user.getName().length() == 0) {
            System.out.println("name 为空，不保存 ");
            return;
        }
        if(user.getAge() == null || user.getAge()<0){
            System.out.println("age 不在有效范围内0 ~ 200，不保存。 ");
            return;
        }
        target.Save(user);
    }

    @Override
    public void Println() {

    }
}
