package com.pzq.socket;

public class DefaultObjectAction implements ObjectAction {
	@Override
	public void doAction(Object obj, Client client) {
		System.out.println("����\t" + obj.toString());
	}
}
