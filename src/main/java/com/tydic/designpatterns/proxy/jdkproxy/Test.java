package com.tydic.designpatterns.proxy.jdkproxy;

import com.tydic.designpatterns.proxy.common.IHelloService;
import com.tydic.designpatterns.proxy.common.IHelloServiceImpl;

import java.lang.reflect.InvocationHandler;

/**
 * @Author fancq
 * @Date 2019/5/28 10:43
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public class Test {
    public static void main(String[] args) {
        IHelloService helloService = new IHelloServiceImpl();
        InvocationHandler helloServiceHandler = new IHelloServiceHandler(helloService);
        IHelloService helloServiceProxy = (IHelloService) ((IHelloServiceHandler) helloServiceHandler).getProxyInstance();
        helloServiceProxy.sayHello();
    }
}
