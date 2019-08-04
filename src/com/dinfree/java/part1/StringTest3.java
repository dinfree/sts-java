package com.dinfree.java.part1;

public class StringTest3 {

	public static void main(String[] args) {
		String s1 = "Hello World";
		System.out.println(s1);
		System.out.printf("indexOf('l'): %s\n", s1.indexOf('l'));
		System.out.printf("lastIndexOf('l'): %s\n", s1.lastIndexOf('l'));
		System.out.printf("charAt(6): %s\n", s1.charAt(6));
		System.out.printf("startWith(\"He\"): %s\n", s1.startsWith("He"));
		System.out.printf("length(): %s\n", s1.length());
		
		StringBuffer sb = new StringBuffer();
		sb.append("Hello");
		sb.append(" World");
		String str = sb.toString();
		System.out.println(str);
	}
}