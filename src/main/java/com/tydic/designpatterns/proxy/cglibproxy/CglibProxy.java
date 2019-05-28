package com.tydic.designpatterns.proxy.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author fancq
 * @Date 2019/5/28 14:19
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public class CglibProxy implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB动态代理 -> Before hello world");
        methodProxy.invokeSuper(o, objects);
        System.out.println("CGLIB动态代理 -> After hello world");
        return null;
    }
}
