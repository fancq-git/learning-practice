package com.tydic.handwriting.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

/**
 * 数据库连接池的实现
 * @Author fancq
 * @Date 2019/7/25 8:55
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public class DBPool {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBPool.class);

    private static final LinkedList<Connection> connList = new LinkedList<Connection>();

    // 初始化池的大小
    public DBPool(int size) {
        if (size <= 0)
            throw new IllegalArgumentException("数据库连接池大小必须大于0");
        for (int i = 0; i < size; i++) {
            connList.addLast(DBConnection.getConnection());
        }
    }

    // 从池中取连接
    public Connection getConn(long waitTime) {
        synchronized (connList) {
            if (waitTime <= 0) {
                while (connList.isEmpty()) {
                    try {
                        connList.wait(waitTime);
                    } catch (InterruptedException e) {
                        LOGGER.error(e.getMessage(), e);
                    }
                }
                return connList.removeFirst();
            } else {
                long future = System.currentTimeMillis() + waitTime;
                long remainTime = waitTime;
                while (connList.isEmpty() && remainTime > 0) {
                    try {
                        connList.wait(remainTime);
                        remainTime = future - System.currentTimeMillis(); // 唤醒一次，重新计算剩余等待时间
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (!connList.isEmpty())
                    return connList.removeFirst();
                return null;
            }
        }
    }

    // 归还连接到池
    public void releaseConn(Connection conn) {
        if (conn != null) {
            synchronized (connList) {
                connList.addLast(conn);
                connList.notifyAll();
            }
        }
    }

}
