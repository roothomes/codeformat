package com.roothomes.net.socket.tcp.d05;

import java.io.IOException;
import java.net.Socket;

public class ClientAcceptor implements Runnable {
    private Socket mSocket = null;
	public ClientAcceptor(Socket socket) {
		this.mSocket = socket;
	}

	@Override
	public void run() {
		try {
			String resp= readSocket();
			writeResponse("服务器返回....");
		} catch (Exception e) {
		} finally {
			if (!mSocket.isClosed()) {
				try {
					mSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String readSocket() {
		if (null == mSocket) {
			return "";
		}
		String server_content="";
		try {
			 server_content=SocketUtil.Accept(mSocket);
			System.out.println("接收客户端数据为:"+server_content);
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return server_content;
	}
	private void writeResponse(String resp) throws Exception {
		SocketUtil.Send(resp,mSocket);
	}
}