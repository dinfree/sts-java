package com.dinfree.java.basic;

public class ExceptionTest2 {
	int num;
	
	public void doExeption() throws MyException{
		if(num == 1)
			System.out.println("OK");
		else
			throw new MyException("doException");
	}
	
	public static void main(String[] args) {
		ExceptionTest2 app = new ExceptionTest2();
		app.num = 2;
		
		try {
			app.doExeption();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}