package com.dinfree.java.fpstream;

public class MyApp {

	public MyApp() {
		/* 일반구현 
		 MyClass mc = new MyClass();
		 print(mc);
		*/
		
		/* 익명 이너클래스로 구현
		print(new MyInterface() {
			@Override
			public void printMsg(String msg) {
				System.out.println(msg);
			}
		});
		*/
		
		// 람다로 구현
		print(msg -> System.out.println(msg));
		print(System.out::print);
	}
	
	public void print(MyInterface mi) {
		mi.printMsg("Hello");
	}
	
	public static void main(String[] args) {
		MyApp app = new MyApp();
	}

}
