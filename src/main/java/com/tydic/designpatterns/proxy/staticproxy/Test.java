package com.tydic.designpatterns.proxy.staticproxy;

import com.tydic.designpatterns.proxy.common.IHelloService;
import com.tydic.designpatterns.proxy.common.IHelloServiceImpl;

/**
 *
 *@Author fancq
 *@Date 2019/5/28 10:07
 *@Version 1.0
 *@Email 1191071905@qq.com
 **/
public class Test {
    public static void main(String[] args) {
        IHelloService helloService = new IHelloServiceImpl();
        IHelloService helloServiceProxy = new IHelloServiceProxy(helloService);
        helloServiceProxy.sayHello();
    }
}
