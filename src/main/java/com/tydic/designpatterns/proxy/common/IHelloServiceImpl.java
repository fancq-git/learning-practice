package com.tydic.designpatterns.proxy.common;/**
 * @author fancq
 * @date 2019/5/28 10:01
 * @email 1191071905@qq.com
 */

/**
 *
 *@Author fancq
 *@Date 2019/5/28 10:01
 *@Version 1.0
 *@Email 1191071905@qq.com
 **/
public class IHelloServiceImpl implements IHelloService{
    public void sayHello() {
        System.out.println("Hello world!");
    }
}
