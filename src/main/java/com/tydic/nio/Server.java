package com.tydic.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author fancq
 * @Date 2019/6/6 9:12
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public class Server {
    static byte[] bytes = new byte[1024];
    static List<SocketChannel> list = new ArrayList<SocketChannel>();
    static ByteBuffer byteBuffer = ByteBuffer.allocate(512);

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            serverSocketChannel.configureBlocking(false); // 设置socket非阻塞
            System.out.println("服务端启动成功，等待客户端连接...");
            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel == null) {
                    System.out.println("服务端没有收到连接，继续等待...");
                    Thread.sleep(1000L);
                    for (SocketChannel client : list) {
                        int k = client.read(byteBuffer);
                        if (k > 0) {
                            byteBuffer.flip();
                            System.out.println("收到客户端发来的消息 -> " + byteBuffer.toString());
                        }
                    }
                } else {
                    System.out.println("服务端收到客户端连接");
                    socketChannel.configureBlocking(false);
                    list.add(socketChannel);
                    for (SocketChannel client : list) {
                        int i = client.read(byteBuffer);
                        if (i > 0) {
                            byteBuffer.flip();
                            System.out.println("收到客户端发来的消息 -> " + byteBuffer.toString());
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
