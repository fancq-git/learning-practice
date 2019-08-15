package com.tydic.lambda;

import org.junit.Test;

/**
 * @Author fancq
 * @Date 2019/8/15 11:11
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public class LamdaTest {

    public Integer operation(Integer num, MyFunction mf) {
        return mf.getValue(num);
    }

    @Test
    public void test() {
        Integer res = operation(200, x -> x + x);
        Integer res1 = operation(200, x -> x * x);
        System.out.println(res + ", " + res1);

        Converter<String, Integer> converter = param -> Integer.valueOf(param);
        Integer result = converter.convert("101");
        System.out.println(result);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello lambda");
            }
        }).start();
        new Thread(() -> System.out.println("hello lambda")).start();
    }
}
