package com.tydic.designpatterns.proxy.staticproxy;

import com.tydic.designpatterns.proxy.common.IHelloService;

/**
 *
 *@Author fancq
 *@Date 2019/5/28 10:02
 *@Version 1.0
 *@Email 1191071905@qq.com
 **/
public class IHelloServiceProxy implements IHelloService {

    private IHelloService helloService;

    public IHelloServiceProxy(IHelloService helloService) {
        this.helloService = helloService;
    }

    public void sayHello() {
        System.out.println("静态代理 -> Before hello world...");
        helloService.sayHello();
        System.out.println("静态代理 -> After hello world...");
    }
}
