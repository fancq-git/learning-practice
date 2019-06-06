package com.tydic.nio;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author fancq
 * @Date 2019/6/6 9:00
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            System.out.println("客户端到服务端网络已连接");
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String txt = scanner.next();
                System.out.println("客户端发往服务端消息 -> " + txt);
                socket.getOutputStream().write(txt.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
