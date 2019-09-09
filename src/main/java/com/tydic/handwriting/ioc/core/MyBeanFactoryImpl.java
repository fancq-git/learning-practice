package com.tydic.handwriting.ioc.core;

import com.tydic.handwriting.ioc.bean.BeanDefinition;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fancq
 * @date 2019/9/9 23:05
 */
public class MyBeanFactoryImpl implements MyBeanFactory {
    /**
     * 存储对象名称和已经实例化的对象映射
     */
    private static ConcurrentHashMap<String, Object> beanMap = new ConcurrentHashMap<>(16);
    /**
     * 存储对象名称和对应对象信息的映射
     */
    private static ConcurrentHashMap<String, BeanDefinition> beanDefineMap = new ConcurrentHashMap<>(16);
    /**
     * 存储在容器中对象的名称
     */
    private static Set<String> beanNameSet = Collections.synchronizedSet(new HashSet<>());

    @Override
    public Object getBeanByName(String name) throws Exception {
        Object object = beanMap.get(name);
        if (object != null) {
            return object;
        }
        object = getObject(beanDefineMap.get(name));
        if (object != null) {
            setField(object);
            beanMap.put(name, object);
        }
        return object;
    }

    public Object getObject(BeanDefinition beanDefinition) throws Exception {
        String className = beanDefinition.getClassName();
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw e;
        }
        return clazz;
    }

    public void setField(Object bean) throws Exception {
        Field[] declareFields = bean.getClass().getDeclaredFields();
        for (Field field : declareFields) {
            String fieldTypeName = field.getType().getName();
            if (beanNameSet.contains(fieldTypeName)) {
                Object findBean = getBeanByName(fieldTypeName);
                field.setAccessible(true);
                field.set(bean, findBean);
            }
        }
    }

    public static void setBeanDefineMap(ConcurrentHashMap<String, BeanDefinition> beanDefineMap) {
        MyBeanFactoryImpl.beanDefineMap = beanDefineMap;
    }

    public static void setBeanNameSet(Set<String> beanNameSet) {
        MyBeanFactoryImpl.beanNameSet = beanNameSet;
    }
}
