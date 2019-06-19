package com.tydic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author fancq
 * @Date 2019/6/6 23:02
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
//        queryValue(args);
        testGC();
    }

    /**
     * 从启动配置中添加参数或者属性
     * @param args
     */
    public static void queryValue(String[] args) {
        System.out.println("从Program arguments获取参数 -> " + Arrays.toString(args));
        System.out.println("从VM options获取属性-Dcomputer.owner -> " + System.getProperty("computer.owner"));
    }

    /**
     * 启动程序后，使用jvisualvm查看visualgc情况
     * @throws InterruptedException
     */
    public static void testGC() throws InterruptedException {
        System.out.println("开始模拟GC，请打开jvisualvm visualgc查看！");
        byte[] bytes = new byte[1024 * 1000];
        List<byte[]> list = new LinkedList<>();
        while (true) {
            list.add(bytes);
            Thread.sleep(10);
        }
    }
}
