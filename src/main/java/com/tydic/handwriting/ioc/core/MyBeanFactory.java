package com.tydic.handwriting.ioc.core;

/**
 * 自定义统一容器管理类
 * @author fancq
 * @date 2019/9/9 23:03
 */
public interface MyBeanFactory {
    /**
     * 根据bean名称获取bean
     * @param name
     * @return
     * @throws Exception
     */
    Object getBeanByName(String name) throws Exception;
}
