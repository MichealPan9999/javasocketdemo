package com.pzq.socket;

public class DefaultObjectAction implements ObjectAction {
	@Override
	public Object doAction(Object obj, Server server) {
		System.out.println("����\t" + obj.toString());
		return obj;
	}
}
