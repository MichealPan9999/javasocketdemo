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
		// ����ָ���Ķ˿�
		int port = 55533;
		try {
			ServerSocket server = new ServerSocket(port);
			System.out.println("server��һֱ�ȴ����ӵĵ���");
			socket = server.accept();
			System.out.println("���Ƿ���ˣ���������" + port + "�˿�");
			in = socket.getInputStream();
			out = socket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ���ʹ�ö��̣߳��Ǿ���Ҫ�̳߳أ���ֹ��������ʱ���������̺߳ľ���Դ
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
					System.out.println("��ȡ���ͻ��˷��͵������ݣ�" + data);
					out.write("���Ƿ���˷����ͻ��˵����ݣ�".getBytes());
					out.flush();
				} else {
					System.out.println("���ݶ�ȡ��ϣ�");
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
