package com.tydic.annotation;

import java.lang.reflect.Method;

public class TestAnnotation {

    public static void main(String[] args) {
        Class userServiceClazz = UserService.class;
        Class anno = DoSomething.class;
        Method[] methods = userServiceClazz.getMethods();
        if (userServiceClazz.isAnnotationPresent(anno)) {

        } else {
            for (Method method : methods) {
                if (method.isAnnotationPresent(anno)) {
                    DoSomething doSomething = (DoSomething) method.getAnnotation(anno);
                    System.out.println("方法[" + anno.getSimpleName() + "]含有注解[@" + anno.getSimpleName() + "]，获取注解信息如下：");
                    System.out.println(doSomething.key());
                    System.out.println(doSomething.cacheName());
                    System.out.println(doSomething.needLog());
                    System.out.println("该方法注解信息获取成功");
                }
            }
        }
    }
}
