package com.tydic.handwriting.ioc.bean;

/**
 * 保存实体类信息
 * @author fancq
 * @date 2019/9/9 22:24
 */
public class BeanDefinition {
    private String className;
    private String alias;
    private String superName;

    public String getClassName() {
        return className;
    }

    public BeanDefinition setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getAlias() {
        return alias;
    }

    public BeanDefinition setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public String getSuperName() {
        return superName;
    }

    public BeanDefinition setSuperName(String superName) {
        this.superName = superName;
        return this;
    }
}
