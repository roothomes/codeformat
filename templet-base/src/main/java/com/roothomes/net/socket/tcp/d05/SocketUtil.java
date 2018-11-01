package com.roothomes.net.socket.tcp.d05;

import java.io.*;
import java.net.Socket;

public class SocketUtil {
    //发送数据
     public static  void Send(String obj,Socket socket) throws Exception{
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				socket.getOutputStream(), "UTF-8"));
		writer.append(obj);
		writer.newLine();
		writer.flush();
	}
//接受数据
public static String Accept(Socket socket) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
	String line = reader.readLine();
	return line;
}
}