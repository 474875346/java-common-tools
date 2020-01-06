package com.proxy.demo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserDaoCgligProxy implements MethodInterceptor {

    private Object target;

    public UserDaoCgligProxy(Object object) {
        this.target = object;
    }

    private boolean checkSaveUserParam(String methodName, Object[] args) {

        if (!(target instanceof UserDaoCglib)) {
            System.out.println("协议类型不对");
            return false;
        }
        if (!(methodName.equals("Save"))) {
            System.out.println("调用方法不对");
            return false;
        }
        if (args == null || args.length < 1 || !(args[0] instanceof User)) {
            System.out.println("传入参数不对");
            return false;
        }
        User user = (User) args[0];
        if (user.getName() == null || user.getName().length() == 0) {
            System.out.println("name 为空，不保存 ");
            return false;
        }
        if (user.getAge() == null || user.getAge() < 0) {
            System.out.println("age 不在有效范围内0 ~ 200，不保存。 ");
            return false;
        }
        return true;
    }

    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (checkSaveUserParam(method.getName(), objects)) {
            return method.invoke(target, objects);
        }
        return null;
    }
}
