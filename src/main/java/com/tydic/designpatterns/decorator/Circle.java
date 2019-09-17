package com.tydic.designpatterns.decorator;

/**
 * @Author fancq
 * @Date 2019/9/17 15:50
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("画圆圈");
    }
}
