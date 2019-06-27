package com.pzq.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {
	private static byte[] recData = null;
	private static InputStream in;
	private static OutputStream out;
	private static Socket socket;

	public static void main(String[] args) {
		// 监听指定的端口
		int port = 55533;
		try {
			ServerSocket server = new ServerSocket(port);
			System.out.println("server将一直等待连接的到来");
			socket = server.accept();
			System.out.println("这是服务端，监听本机" + port + "端口");
			in = socket.getInputStream();
			out = socket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 如果使用多线程，那就需要线程池，防止并发过高时创建过多线程耗尽资源
		/*
		 * ExecutorService threadPool = Executors.newFixedThreadPool(100);
		 * threadPool.submit(new Runnable() { public void run() {
		 */
		while (true) {
			recData = new byte[1024];
			try {
				int r = in.read(recData);
				if (r > -1) {
					String data = new String(recData);
					if (data.trim().equals("over")) {
						socket.close();
					}
					System.out.println("读取到客户端发送的来数据：" + data);
					out.write("这是服务端发给客户端的数据：".getBytes());
					out.flush();
				} else {
					System.out.println("数据读取完毕！");
					socket.close();
					System.exit(0);
					// ss.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				try {
					socket.close();
					in.close();
					out.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		}
		// }
		// });

	}

}
