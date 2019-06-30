package com.tydic.handwriting.springmvc.servlet;

import com.tydic.handwriting.springmvc.annotation.Controller;
import com.tydic.handwriting.springmvc.annotation.RequestMapping;
import com.tydic.handwriting.springmvc.annotation.Service;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyDispatchServlet extends HttpServlet {
    private List<String> clzList = new LinkedList<>();

    private Map<String, Object> beansMap = new HashMap<>(); // 用来存储实例化的对象

    private void doInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (clzList != null && clzList.size() > 0) {
            for (String clzName : clzList) {
                Class<?> clz = Class.forName(clzName);
                if (clz.isAnnotationPresent(Controller.class)) {
                    RequestMapping annotation = clz.getAnnotation(RequestMapping.class);
                    beansMap.put(annotation.value(), clz.newInstance());
                } else if (clz.isAnnotationPresent(Service.class)) {
                    Service annotation = clz.getAnnotation(Service.class);
                    beansMap.put(annotation.value(), clz.newInstance());
                }
            }
        }
    }

}
