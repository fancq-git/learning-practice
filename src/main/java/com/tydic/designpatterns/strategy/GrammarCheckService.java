package com.tydic.designpatterns.strategy;

/**
 * sql语法校验服务接口
 * @author fancq
 * @date 2019/11/5 22:39
 */
public abstract class GrammarCheckService {
    /**
     * 校验sql语法
     * @param sql
     */
    public abstract void check(String sql);
}
