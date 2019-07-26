package com.dinfree.java.fpstream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class finalOpExamples {
	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1,2,3);
		List<String> strList = Arrays.asList("Hwang", "Hong", "Kang");

		System.out.println("## forEach() ##");
		intList.stream().forEach(System.out::println); // 1,2,3
		intList.stream().forEach(x -> System.out.printf("%d : %d\n",x,x*x)); // 1,4,9

		System.out.println("## reduce() ##");
		int sum = intList.stream().reduce((a,b) -> a+b).get();		
		System.out.println("sum: "+sum);  // 6
		
		System.out.println("## findFirst(), findAny() ##");
		strList.stream().filter(s -> s.startsWith("H")).findFirst().ifPresent(System.out::println);
		strList.parallelStream().filter(s -> s.startsWith("H")).findAny().ifPresent(System.out::println);

		System.out.println("## anyMatch(), allMatch(), noneMatch() ##");
		boolean result1 = strList.stream().anyMatch(s -> s.startsWith("H"));  //true
		boolean result2 = strList.stream().allMatch(s -> s.startsWith("H"));  //false
		boolean result3 = strList.stream().noneMatch(s -> s.startsWith("T")); //true
		System.out.printf("%b, %b, %b\n",result1,result2, result3);

		System.out.println("## count(), min(), max() ##");
		intList.stream().count();	// 3
		intList.stream().filter(n -> n !=2 ).count(); 	// 2
		intList.stream().min(Integer::compare).ifPresent(System.out::println);; 		// 1
		intList.stream().max(Integer::compareUnsigned).ifPresent(System.out::println);; // 3
		
		strList.stream().count();	// 3
		strList.stream().min(String::compareToIgnoreCase).ifPresent(System.out::println);	// Hong
		strList.stream().max(String::compareTo).ifPresent(System.out::println);	// Kang
		
		System.out.println("## sum(), average() ##");
		intList.stream().mapToInt(Integer::intValue).sum();	// 6
		intList.stream().reduce((a,b) -> a+b).ifPresent(System.out::println); // 6
		
		intList.stream().mapToInt(Integer::intValue).average();	// 2
		intList.stream().reduce((a,b) -> a+b).map(n -> n/intList.size()).ifPresent(System.out::println); // 2

		System.out.println("## collect() ##");
		strList.stream().map(String::toUpperCase).collect(Collectors.joining("/")); // HWANG/HONG/KANG
		strList.stream().collect(Collectors.toMap(k -> k, v -> v.length())); // {Hong=4, Hwang=5, Kang=4}
		
		intList.stream().collect(Collectors.counting());	// 3
		intList.stream().collect(Collectors.maxBy(Integer::compare)); 	// 3
		intList.stream().collect(Collectors.reducing((a,b) -> a+b));	// 6
		intList.stream().collect(Collectors.summarizingInt(x -> x));  	// count=3, max=3, min=1, sum=6

		Map<Boolean, List<String>> group = strList.stream().collect(Collectors.groupingBy(s -> s.startsWith("H")));
		group.get(true).forEach(System.out::println);
		
		Map<Boolean, List<String>> partition = strList.stream().collect(Collectors.partitioningBy(s -> s.startsWith("H")));
		partition.get(true).stream().forEach(System.out::println);
	}
}