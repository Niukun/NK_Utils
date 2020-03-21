package com.niukun.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) {
		//创建一个服务器的socket
		try {
			ServerSocket server = new ServerSocket(6666);
			System.out.println("服务器已经启动，正在等待客户端的连接。。。");

			//等待客户端的连接，造成阻塞。如果有客户端连接成功，则会立即返回一个socket对象
			Socket socket = server.accept();



		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
