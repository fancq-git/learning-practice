package com.tydic.designpatterns.proxy.jdkproxy;

import com.tydic.designpatterns.proxy.common.IHelloService;
import com.tydic.designpatterns.proxy.common.IHelloServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理增强类
 * @Author fancq
 * @Date 2019/9/17 13:36
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public class MyInvocationHandler implements InvocationHandler {

    private IHelloService helloService;

    public MyInvocationHandler(IHelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前...");
        Object returnValue = method.invoke(helloService, args);
        System.out.println("代理后...");
        return returnValue;
    }

    public static void main(String[] args) {
        IHelloService helloService = new IHelloServiceImpl();
        InvocationHandler handler = new MyInvocationHandler(helloService);
        IHelloService helloServiceProxy = (IHelloService) Proxy.newProxyInstance(
                helloService.getClass().getClassLoader(), helloService.getClass().getInterfaces(), handler);
        helloServiceProxy.sayHello();
    }
}
