package com.tydic.annotation;

public class UserService {

    @DoSomething(key = "fancq", cacheName = "fancq_info", needLog = true)
    public void cache() {
        System.out.println("数据缓存至Redis");
    }

}
