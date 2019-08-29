package com.tydic.designpatterns.proxy.jdkproxy;

import com.tydic.designpatterns.proxy.common.IHelloService;
import com.tydic.designpatterns.proxy.common.IHelloServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 手写JDK动态代理
 */
public class DynamicProxy implements InvocationHandler {
    private static final Logger LOG = LoggerFactory.getLogger(DynamicProxy.class);

    private IHelloService helloService;

    public DynamicProxy(IHelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LOG.info("~~~~~~~~~~代理前~~~~~~~~~~");
        method.invoke(helloService, args);
        LOG.info("~~~~~~~~~~代理后~~~~~~~~~~");
        return null;
    }

    public <T> T getProxyInst(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(helloService.getClass().getClassLoader(), helloService.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        IHelloService helloService = new IHelloServiceImpl();
        DynamicProxy proxy = new DynamicProxy(helloService);
        ((IHelloService) proxy.getProxyInst(DynamicProxy.class)).sayHello();
    }
}
