package com.pzq.socket;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KeepAlive implements Serializable {
	private static final long serialVersionUID = -2813120366138988480L;

	/*
	 * ���Ǹ÷����������ڲ���ʹ�á�
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\tά�����Ӱ�";
	}
}
