package com.pzq.socket;

import java.io.IOException;
import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) {
		String serverIp = "127.0.0.1";
		int port = 5533;
		Client client = new Client(serverIp, port);
		try {
			client.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
