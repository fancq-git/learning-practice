package com.tydic.designpatterns.proxy.jdkproxy;

import com.tydic.designpatterns.proxy.common.IHelloService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 *@Author fancq
 *@Date 2019/5/28 10:37
 *@Version 1.0
 *@Email 1191071905@qq.com
 **/
public class IHelloServiceHandler implements InvocationHandler {

    private IHelloService helloService;

    public IHelloServiceHandler(IHelloService helloService) {
        this.helloService = helloService;
    }

    /**
     * 调用代理对象方法，实际执行invoke方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理 -> Before hello world");
        method.invoke(helloService, args);
        System.out.println("JDK动态代理 -> After hello world");
        return null;
    }

    /**
    　* 生成代理对象
      * 生成字节码文件到内存，从内存加载代理对象
    　* @author fancq
    　* @date 2019/5/28 10:46
      * @email 1191071905@qq.com
    　*/
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(helloService.getClass().getClassLoader(), helloService.getClass().getInterfaces(), this);
    }
}
