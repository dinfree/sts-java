package com.dinfree.java.part1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionTest {
	public static void main(String[] args) {
		// Create a new HashSet and add data
		Collection<String> c1 = new HashSet<>();
		c1.add("one");
		c1.add("two");
		
		// Create a new List with two values
		Collection<String> c2 = Arrays.asList("three", "four");
		Collection<String> c3 = Collections.singleton("five");
		
		// add all data in c2, c3 to c1
		c1.addAll(c2);
		c1.addAll(c3);
		
		// get size of collection
		System.out.println("Size of c1 : "+c1.size());
		
		// convert collection to array
		Object[] converted1 = c1.toArray();
		String[] converted2 = c1.toArray(new String[c1.size()]);
		
		// print all data in collection using for loop
		for(String s : c1) {
			System.out.println(s);			
		}
		
		// access and print all data in the array which converted from collection
		for(int i=0;i<converted2.length;i++) {
			System.out.println(converted2[i]);			
		}
				
		// get Iterator object from collection and access the data
		Iterator iter = c1.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		// run specific code using every elements in the collection 
		c1.forEach(System.out::println);
		//c1.stream().map(s -> s += "#").forEach(System.out::println);
	}
}