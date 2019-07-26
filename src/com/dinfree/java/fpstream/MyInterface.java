package com.dinfree.java.fpstream;

public interface MyInterface {
	void printMsg(String msg);
	default String getMsg() {
		return "msg from interface";
	}
	static void print(String msg) {
		System.out.println(msg);
	}
}
