package com.tydic.designpatterns.template;

/**
 * @Author fancq
 * @Date 2019/7/30 8:57
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public abstract class Cake {
    protected abstract void make();

    protected abstract void buy();

    protected abstract void eat();

    protected abstract boolean shouldBuy();

    public void run() {
        make();
        if (shouldBuy())
            buy();
        eat();
    }
}
