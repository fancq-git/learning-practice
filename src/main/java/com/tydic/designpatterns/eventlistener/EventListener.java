package com.tydic.designpatterns.eventlistener;

/**监听器接口
 * @Author fancq
 * @Date 2019/9/23 8:58
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public interface EventListener extends java.util.EventListener {
    /**
     * 事件处理
     * @param eventObject
     */
    void handleEvent(EventObject eventObject);
}
