package com.tydic.designpatterns.template;

/**
 * @Author fancq
 * @Date 2019/7/30 9:01
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public class ChocolateCake extends Cake {
    @Override
    protected void make() {
        System.out.println("制作巧克力蛋糕");
    }

    @Override
    protected void buy() {
        System.out.println("买巧克力蛋糕");
    }

    @Override
    protected void eat() {
        System.out.println("吃巧克力蛋糕");
    }

    @Override
    protected boolean shouldBuy() {
        return false;
    }
}
