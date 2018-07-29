package com.niukun.socket;

import java.net.Socket;
import java.util.Scanner;

public class SocketClient {

	public static void main(String[] args) throws Exception {

		Socket client = new Socket("localhost",12345);
		Scanner scan = new Scanner(client.getInputStream());
		scan.useDelimiter("\n");
		if(scan.hasNext()) {
			System.out.println("回应数据");
		}
		scan.close();
		client.close();
	}

}
