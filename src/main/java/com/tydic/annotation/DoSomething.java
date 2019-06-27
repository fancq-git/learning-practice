package com.tydic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 运行期注解类型，一直存在
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DoSomething {

    String key();

    String cacheName();

    boolean needLog() default false;
}
