package com.tydic.handwriting.springmvc.servlet;

import com.tydic.handwriting.springmvc.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyDispatchServlet extends HttpServlet {
    private List<String> clzList = new LinkedList<>();

    private Map<String, Object> beansMap = new HashMap<>(); // 用来存储实例化的对象

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        String url = requestURI.replace(contextPath, ""); // eg: /hello/sayHello
        Method method = (Method) urlMappings.get(url);
        try {
            Object invoke = method.invoke(beansMap.get("/" + url.split("/")[1]));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

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

    private void ioc() throws IllegalAccessException {
        if (beansMap != null && beansMap.size() > 0) {
            for (Map.Entry<String, Object> entry : beansMap.entrySet()) {
                Field[] fields = entry.getValue().getClass().getDeclaredFields(); // 得到实例对象的所有属性的定义
                for (Field field : fields) {
                    field.setAccessible(true); // 设置访问权限
                    if (field.isAnnotationPresent(Autowired.class)) {
                        Qualifier annotation = field.getAnnotation(Qualifier.class);
                        field.set(entry.getValue(), beansMap.get(annotation.value()));
                    }
                }

            }
        }
    }

    private Map<String, Object> urlMappings = new HashMap<>();
    private void setMappings() {
        if (beansMap != null && beansMap.size() > 0) {
            for (Map.Entry<String, Object> entry : beansMap.entrySet()) {
                Class<? extends Object> clz = entry.getValue().getClass();
                if (clz.isAnnotationPresent(Controller.class)) {
                    Method[] methods = clz.getDeclaredMethods();
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(RequestMapping.class)) {
                            // 拼装url，/hello/sayHello
                            String url = entry.getKey() + method.getAnnotation(RequestMapping.class);
                            urlMappings.put(url, method);
                        }
                    }
                }
            }
        }
    }

}
