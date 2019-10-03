package com.dinfree.java.part1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MapListTest {

	public static void main(String[] args) {
		List<Integer> s1 = Arrays.asList(95,89,93,87,94);
		List<Integer> s2 = Arrays.asList(99,79,91,89,91);
		List<Integer> s3 = Arrays.asList(93,81,95,88,99);
		
		Map<String, List<Integer>> student = new HashMap<>();
		student.put("홍길동", s1);
		student.put("김사랑", s2);
		student.put("아무개", s3);
		
		Scanner scan = new Scanner(System.in);
		System.out.print("## 성적 조회할 이름을 입력하세요: ");
		String input = scan.next();
		
		int total = 0;
		for(int s : student.get(input)) {
			total += s;
		}
		
		System.out.printf("총점: %d, 평균: %d",total, total/5);
	}
}