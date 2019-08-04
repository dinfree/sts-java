/**
* 연산자 기본 예제 - 비트시프트, XOR
*/

package com.dinfree.java.part1;

public class Operator2 {

	public static void main(String[] args) {
		int num1 = 50;
		System.out.printf("정수값 num1 : %d, %s\n", num1, Long.toBinaryString(num1));		

		int result1 = num1 >> 1;
		System.out.printf("num1 >> 2 : %d, %s\n", result1, Long.toBinaryString(result1));
		
		int result2 = num1 << 1;
		System.out.printf("num1 << 2 : %d, %s\n", result2, Long.toBinaryString(result2));
		
		System.out.println("------------------");
		
		int pwd = 123456;
		int encPwd, decPwd;
		int key = 0x1A253B65;
				
		System.out.println("암호화 전 비밀번호 : "+pwd);
		
		encPwd = pwd ^ key;
		
		System.out.println("암호화 후 비밀번호 : "+encPwd);
		
		decPwd = encPwd ^ key;
		
		System.out.println("복호화 후 비밀번호 : "+decPwd);
	}
}
