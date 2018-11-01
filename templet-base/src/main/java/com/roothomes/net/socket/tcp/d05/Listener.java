package com.roothomes.net.socket.tcp.d05;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * 单例设计模式设计服务类,将服务类设计为线程
 * */
public class Listener extends Thread {

	private static Listener mListener = null;

	public static Listener getInstance() {
		if (mListener == null) {
			synchronized (Listener.class) {
				if (mListener == null)
					mListener = new Listener();
			}
		}

		return mListener;
	}

	// 线程池，用于支持并发。
	private ExecutorService mThreadPool;

	// 关闭标志
	private volatile boolean mStopFlag;

	private ServerSocket mServerSocket;

	/**
	 * 只能存在单实例
	 */
	private Listener() {
		mThreadPool = Executors.newCachedThreadPool();
		mStopFlag = false;
		mServerSocket = null;
	}

	/**
	 * stop
	 */
	public void setStopFlag() {
		mStopFlag = true;
	}

	@Override
	public void run() {
		try {
			mServerSocket = new ServerSocket(Consts.ServerPort);
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}

//		Logger.getLogger().log("服务器已经启动，等待连接");
		while (!mStopFlag) {
			try {
				Socket socket = null;

				socket = mServerSocket.accept();// which is connected to the
												// socket from client
				// break;
				if (!mStopFlag) {
					mThreadPool.execute(new ClientAcceptor(socket));
				} else {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("已经跳出循环了");
		try {
			mThreadPool.shutdown();
			mThreadPool.awaitTermination(30, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		Logger.getLogger().log("Listener准备退出");
		return;

	}
}
