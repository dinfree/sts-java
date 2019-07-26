package com.dinfree.java.fpstream;

import java.util.*;

public class IntermediateOpExamples {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1,2,3);
		List<String> strList = Arrays.asList("Hwang", "Hong", "Kang");

		// IntStream intList = IntStream.of(1,2,3);

		System.out.println("## filter(), distinct() ##");
		intList.stream().filter(x -> x<=2).forEach(System.out::println);  // 1,2
		Arrays.asList(1,2,3,2,5).stream().distinct().forEach(System.out::println); // 1,2,3,5
		intList.stream().map(x -> x*x).forEach(System.out::println); // 1,4,9		
		
		System.out.println("## flatMap() ##");
		Arrays.asList(intList,Arrays.asList(2,5)).stream()
		.flatMap(i -> i.stream())
		.forEach(System.out::println); // 1,2,3,2,5

		Arrays.asList(intList,Arrays.asList(2,5)).stream()
		.flatMap(i -> i.stream())
		.distinct().forEach(System.out::println); // 1,2,3,5
		
		strList.stream()
			.flatMap(message -> Arrays.stream(message.split("an")))
			.forEach(System.out::println);  // Hw, g, Hong, K, g
		
		System.out.println("## limit() ##");
		intList.stream().limit(2).forEach(System.out::println); // 1,2
		
		System.out.println("## skip() ##");
		intList.stream().skip(2).forEach(System.out::println); // 3
		
		System.out.println("## sorted() ##");
		Arrays.asList(1,4,3,2).stream().sorted().forEach(System.out::println); // 1,2,3,4
		Arrays.asList(1,4,3,2).stream().sorted((a,b) -> b.compareTo(a)).forEach(System.out::println); // 4,3,2,1
		Arrays.asList(1,4,3,2).stream().sorted( (a,b) -> -a.compareTo(b)).forEach(System.out::println);;  // 4,3,2,1
		Arrays.asList(1,4,3,2).stream().sorted( Comparator.reverseOrder()).forEach(System.out::println); // 4,3,2,1
		
		System.out.println("## peak() ##");
		int sum = intList.stream().filter(x -> x<=2).peek(System.out::println).mapToInt(Integer::intValue).sum();
		System.out.println("sum: "+sum);		
	}
}
