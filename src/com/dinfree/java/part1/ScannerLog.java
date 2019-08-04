/**
 * 키보드 입력과 로깅 기본 예제
 */

package com.dinfree.java.part1;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScannerLog {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		int num = scan.nextInt();
		
		System.out.println(name);
		System.out.println(num);
		
		Logger logger = Logger.getLogger("MyLogger");        
		logger.info("Main program started !!");
		logger.log(Level.WARNING, "Data file size too big");
		
		logger.setLevel( Level.FINE );
		ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.FINE);
        logger.addHandler(ch);

        logger.fine("Shutdown main program !!");
	}
}