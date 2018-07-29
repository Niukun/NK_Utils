package com.niukun.socket;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketInServer {

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(12345);
		System.out.println("Wait for client....");
		Socket socket = server.accept();
		PrintStream out = new PrintStream(socket.getOutputStream());
		out.println("Hello world....");
		out.close();
		socket.close();
		server.close();
	}

}
