package com.tydic.designpatterns.template;

/**
 * @Author fancq
 * @Date 2019/7/30 9:05
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public class Test {
    public static void main(String[] args) {
        Cake chocolateCake = new ChocolateCake();
        Cake iceCreamCake = new IceCreamCake();
        chocolateCake.run();
        iceCreamCake.run();
    }
}
