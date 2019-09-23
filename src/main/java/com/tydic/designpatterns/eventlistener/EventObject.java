package com.tydic.designpatterns.eventlistener;

/**事件对象
 * @Author fancq
 * @Date 2019/9/23 9:00
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public class EventObject extends java.util.EventObject {
    public EventObject(Object sources) {
        super(sources);
    }

    public void doEvent() {
        System.out.println("通知一个事件源 source :" + this.getSource());
    }
}
