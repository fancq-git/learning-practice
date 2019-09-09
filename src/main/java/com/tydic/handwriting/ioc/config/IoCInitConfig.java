package com.tydic.handwriting.ioc.config;

import com.tydic.handwriting.ioc.annotation.MyIoc;
import com.tydic.handwriting.ioc.bean.BeanDefinition;
import org.reflections.Reflections;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 存储类信息到Map中
 * @author fancq
 * @date 2019/9/9 22:27
 */
@Component
@Order(value = 1)
public class IoCInitConfig implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        ConcurrentHashMap<String, BeanDefinition> concurrentHashMap = new ConcurrentHashMap<>(16);
        Reflections reflections = new Reflections();
        // 获得项目中所有被MyIoc标记的类
        Set<Class<?>> typeAnnotatedWith =  reflections.getTypesAnnotatedWith(MyIoc.class);
        for (Class clazz : typeAnnotatedWith) {
            String className = clazz.getName();
            String superClassName = clazz.getSuperclass().getName();
            BeanDefinition beanDefinition = new BeanDefinition()
                    .setClassName(className).setSuperName(superClassName).setAlias(getClassName(className));
            concurrentHashMap.put(className, beanDefinition);
        }
    }

    /**
     * 别名，首字母小写
     * @param beanClassName
     * @return
     */
    private String getClassName(String beanClassName) {
        String className= beanClassName.substring(beanClassName.lastIndexOf(".") + 1);
        className = className.substring(0, 1).toLowerCase() + className.substring(1);
        return className;
    }
}
