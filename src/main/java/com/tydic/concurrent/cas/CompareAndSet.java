package com.tydic.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模拟CAS
 * @Author fancq
 * @Date 2019/7/30 8:46
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public class CompareAndSet {
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public void cas(Integer expectVal) {
        for (;;) {
            Integer currentVal = atomicInteger.get();
            boolean success = atomicInteger.compareAndSet(currentVal, expectVal);
            if (success)
                break;
        }
    }
}
