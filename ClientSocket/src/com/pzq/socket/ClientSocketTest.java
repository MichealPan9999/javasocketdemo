package com.pzq.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketTest {
	private static Socket socket;
	private static OutputStream outputStream;
	private static InputStream inputStream;

	public static void main(String[] args) {
		// 要连接的服务端IP地址和端口
		String host = "127.0.0.1";
		int port = 55533;
		int i = 0;
		byte[] recData = null;
		try {
			// 与服务端建立连接
			socket = new Socket(host, port);
			// 建立连接后获得输出流
			outputStream = socket.getOutputStream();
			inputStream = socket.getInputStream();
			outputStream.write("send heart beat data package !".getBytes());
			outputStream.flush();
			while (true) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				recData = new byte[1024];
				int r = inputStream.read(recData);
				if (r > -1) {
					String data = new String(recData);
					if (data.trim().equals("over")) {
						socket.close();
					}
					System.out.println("读取到服务端发送的来数据：" + data);
					outputStream.write("send heart beat data package... !".getBytes());
					outputStream.flush();
				} else {
					System.out.println("数据读取完毕！");
					socket.close();
					System.exit(0);
					// ss.close();
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			try {
				socket.close();
				outputStream.close();
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.exit(0);
		}

	}
}
