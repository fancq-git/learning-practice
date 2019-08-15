package com.tydic.lambda;

@FunctionalInterface // 函数式接口声明：接口中只有一个抽象方法
public interface MyFunction {
    Integer getValue(Integer num);
}
