package com.pzq.socket;

public class Main {
	public static void main(String[] args) {
		int port = 5533;
		Server server = new Server(port);
		server.start();
	}
}
