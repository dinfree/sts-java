package com.dinfree.java.part1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		// create new Set
		Set<String> s1 = new HashSet<>();
		Set<String> s2 = Set.of("three","four");
		
		// add element to Set
		s1.addAll(Arrays.asList("one","two"));
		s1.addAll(s2);
		s1.add("five");
		s1.add("two");
		s1.remove("five");
		
		System.out.println("## element in Set");
		System.out.println(s1);
	
		// print all elements using stream api
		s1.stream().forEach(System.out::println);
		
		System.out.println("## check exist element in Set");
		System.out.println(s1.contains("one"));

		// create new LinkedHashSet and add elements
		Set<String> lset = new LinkedHashSet<>();
		lset.addAll(Arrays.asList("one","two","three","four"));
		lset.add("five");
		
		System.out.println("\n## element in LinkedHashSet");
		System.out.println(lset);
		
		// get Iterator from LinkedHashSet
		System.out.println("## print element using Iterator");
		Iterator<String> iter = lset.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		// create new TreeSet and add elements
		Set<Integer> tset = new TreeSet<>();
		tset.addAll(Arrays.asList(50,10,60,20));

		System.out.println("\n## elements in TreeSet");
		System.out.println(tset);
		
		// Ascending sort with stream api
		System.out.println("## Ascending sort with stream api");
		tset.stream().sorted((o1, o2) -> o2.toString().compareTo(o1.toString())).forEach(System.out::println);	
	}
}