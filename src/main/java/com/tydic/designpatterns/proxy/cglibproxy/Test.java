package com.tydic.designpatterns.proxy.cglibproxy;

import com.tydic.designpatterns.proxy.common.IHelloService;
import com.tydic.designpatterns.proxy.common.IHelloServiceImpl;
import net.sf.cglib.proxy.Enhancer;

/**
 * @Author fancq
 * @Date 2019/5/28 14:50
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public class Test {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(IHelloServiceImpl.class); // cglib无需代理类实现接口，这点有别于静态代理和jdk动态代理
        enhancer.setCallback(new CglibProxy());
        IHelloServiceImpl helloServiceImpl = (IHelloServiceImpl) enhancer.create();
        helloServiceImpl.sayHello();
    }
}
