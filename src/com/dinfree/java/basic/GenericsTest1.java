package com.dinfree.java.basic;

public class GenericsTest1 {
	public static void main(String[] args) {
		Storage<String> storage1 = new Storage<>();
		storage1.setItem("MyItem");
		System.out.println(storage1.getItem());

		Storage<Integer> storage2 = new Storage<>();
		storage2.setItem(20201121);
		System.out.println(storage2.getItem());
	}
}