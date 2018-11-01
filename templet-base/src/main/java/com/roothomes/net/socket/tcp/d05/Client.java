package com.roothomes.net.socket.tcp.d05;

import java.io.IOException;
import java.net.Socket;

public class Client {
	public static Socket socket = null;

	public static void openSocket() {
		try {
			socket = new Socket(Consts.ServerIP, Consts.ServerPort);
		} catch (Exception e) {
			System.out.println("客户端未连接...");
		}
	}

	public static void close() {
		try {
			socket.close();
		} catch (IOException e) {
			System.out.println("客户端关闭异常...");
		}
	}

	public static void main(String[] args) throws Exception {
		Listener.getInstance().start();
		System.out.println("客户端等待10秒");
//    #为了使服务进程先启动....
		Thread.sleep(1000 * 10);
		openSocket();
		SocketUtil.Send("hello world", socket);
		System.out.println("------------waitting for response------------------");
		String respstr = SocketUtil.Accept(socket);
		System.out.println(respstr);
		close();
	}
}