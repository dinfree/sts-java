package com.dinfree.java.basic;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest2 {
	public <T> List<Character> convert(Storage<T> storage) {
		ArrayList<Character> list = new ArrayList<>();
		
		String s = String.valueOf(storage.getItem());
		int size = s.length();
		for(int i=0; i<size; i++) {
			list.add(s.charAt(i));
		}
		return list;
	}
	
	public static void main(String[] args) {
		Storage<String> s1 = new Storage<>();
		s1.setItem("MyItem");
		
		Storage<Integer> s2 = new Storage<>();
		s2.setItem(20201121);
		
		GenericsTest2 gt2 = new GenericsTest2();
		
		System.out.println(gt2.convert(s1));
		System.out.println(gt2.convert(s2));
	}
}