package com.proxy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserDaoDynamicProxy implements InvocationHandler {
    private Object target;

    public  UserDaoDynamicProxy(Object object) {
        this.target = object;
    }
    private boolean checkSaveUserParam(String methodName, Object[] args){
        if (!(target instanceof UserDao)){
            System.out.println("协议类型不对");
            return false;
        }
        if (!(methodName.equals("Save"))){
            System.out.println("调用方法不对");
            return false;
        }
        if (args == null || args.length < 1 || !(args[0] instanceof User)){
            System.out.println("传入参数不对");
            return false;
        }
        User user = (User) args[0];
        if (user.getName() == null || user.getName().length() == 0) {
            System.out.println("name 为空，不保存 ");
            return false;
        }
        if(user.getAge() == null || user.getAge()<0){
            System.out.println("age 不在有效范围内0 ~ 200，不保存。 ");
            return false;
        }
        return true;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(checkSaveUserParam(method.getName(),args)){
            return method.invoke(target,args);
        }
        return null;
    }
}
