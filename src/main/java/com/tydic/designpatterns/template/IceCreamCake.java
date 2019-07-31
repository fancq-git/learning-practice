package com.tydic.designpatterns.template;

/**
 * @Author fancq
 * @Date 2019/7/30 9:03
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public class IceCreamCake extends Cake {
    @Override
    protected void make() {
        System.out.println("制作冰淇淋蛋糕");
    }

    @Override
    protected void buy() {
        System.out.println("买冰淇淋蛋糕");
    }

    @Override
    protected void eat() {
        System.out.println("吃冰淇淋蛋糕");
    }

    @Override
    protected boolean shouldBuy() {
        return true;
    }
}
