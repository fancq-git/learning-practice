package com.tydic.designpatterns.eventlistener;

import java.util.Vector;

/**
 * @Author fancq
 * @Date 2019/9/23 9:03
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public class EventSource {
    /**
     * 监听器列表，监听器的注册则加入此列表
     */
    private Vector<EventListener> listenerList = new Vector<>();

    /**
     * 注册监听器
     * @param eventListener
     */
    public void addListener(EventListener eventListener) {
        listenerList.add(eventListener);
    }

    /**
     * 撤销监听器
     * @param eventListener
     */
    public void removeListener(EventListener eventListener){
        listenerList.remove(eventListener);
    }

    /**
     * 接受外部事件
     * @param event
     */
    public void notifyListenerEvents(EventObject event) {
        for (EventListener eventListener : listenerList) {
            eventListener.handleEvent(event);
        }
    }

    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        eventSource.addListener(new EventListener() {
            @Override
            public void handleEvent(EventObject eventObject) {
                eventObject.doEvent();
                if ("closeWindows".equals(eventObject.getSource())) {
                    System.out.println("doClose");
                }
            }
        });
        eventSource.notifyListenerEvents(new EventObject("closeWindows"));
    }
}
