package com.tydic.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 分布式配置中心
 * @Author fancq
 * @Date 2019/7/11 12:14
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public class ZooKeeperProSync implements Watcher {
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    private static ZooKeeper zk = null;

    private static Stat stat = new Stat();

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) { // zk连接成功通知事件
            System.out.println("成功连接ZK！");
            if (Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()) {
                connectedSemaphore.countDown();
            } else if (watchedEvent.getType() == Event.EventType.NodeDataChanged) { // zk目录节点数据变化通知事件
                try {
                    System.out.println("配置已修改，新值为：【" + new String(zk.getData(watchedEvent.getPath(), true, stat)) + "】");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        System.out.println("开始连接ZK...");
        // zookeeper配置数据存放路径
        String path = "/username";
        // 连接zookeeper并且注册一个默认的监听器
        zk = new ZooKeeper("192.168.129.116:3181", 5000, new ZooKeeperProSync());
        // 等待zk连接成功的通知
        connectedSemaphore.await();
        // 获取path目录节点的配置数据，并注册默认的监听器
        System.out.println("获取【" + path + "】目录节点配置数据【" + new String(zk.getData(path, true, stat)) + "】");
        System.out.println("输入任何内容按下回车键结束程序！");
        System.in.read(); // 阻塞，防止程序退出
        zk.close();
    }
}
