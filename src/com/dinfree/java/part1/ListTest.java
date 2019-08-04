package com.dinfree.java.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		// create new List
		List<String> l1 = new ArrayList<>();
		List<String> l2 = Arrays.asList("one", "two"); 
		List<String> l3 = List.of("three", "four");
		
		// add data to List
		l1.addAll(l2);
		l1.addAll(1,l3);
		l1.add("five");
		
		System.out.println("## element in List");
		System.out.println(l1);
		
		// create new LinkedList and add data
		LinkedList<String> llist = new LinkedList<>();
		llist.addAll(l2);
		llist.addAll(1,l3);
		llist.add("five");

		System.out.println("## element in LinkedList");
		System.out.println(l1);
		
		// access data with index
		System.out.println("## first element: "+l1.get(0));
		System.out.println("## last index of three: "+l1.lastIndexOf("three"));
		
		// change data in List
		l1.set(0, "zero");
		System.out.println("## after set(): element in LinkedList");
		System.out.println(l1);
		
		// Descending sort 
		Collections.sort(l1);
		System.out.println("## Descending sort of l1");
		System.out.println(l1);
		
		// Ascending sort
		l1.sort(new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				return o2.toString().compareTo(o1.toString());
			}
			
		});
		System.out.println("## Ascending sort of l1");
		System.out.println(l1);
		
		// Ascending sort with stream api
		System.out.println("## Ascending sort with stream api");
		l1.stream().sorted((o1, o2) -> o2.toString().compareTo(o1.toString())).forEach(System.out::println);	
	}
}