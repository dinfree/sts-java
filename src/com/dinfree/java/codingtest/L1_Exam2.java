package com.dinfree.java.codingtest;
import java.util.*;
import java.util.stream.Stream;

public class L1_Exam2 {
	HashMap<String,String> userlist = new HashMap<>();
	ArrayList<String> logs = new ArrayList<>();

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] input = {2, 1, 2, 6, 2, 4, 3, 3};
		
		L1_Exam2 app = new L1_Exam2();
		int[] result = app.solution(5,input);
		for(int s : result) {
			System.out.println(s);
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000.0);
	}

	public int[] solution(int N, int[] stages) {
		int totalPlayer = stages.length;
		int[] countArr = new int[N];
		int[] sortedArr = new int[N];
		
		// build count array
		for(int i=0;i<stages.length;i++) {
			if(stages[i] != N+1)
				countArr[stages[i]-1]++;
		}
		
		String[] result = new String[N];
		
		// calculate fail rate
		int failPlayer=0;
		for(int i=0;i<N;i++) {
			int cnt = countArr[i];
			double failRate = (double)cnt/(totalPlayer-failPlayer);
			failPlayer += cnt;
			result[i] = i+1+" "+failRate;
		}
		
		// bubble sorting
		for(int i=0;i<result.length-1;i++) {
			for(int j=0;j<result.length-1;j++) {
				String left = result[j];
				String right = result[j+1];
				if(Double.valueOf(left.split(" ")[1]) < Double.valueOf(right.split(" ")[1])) {
					result[j] = right;
					result[j+1] = left;
				}
			}
		}

		// build return array
		for(int i=0;i<result.length;i++) {
			sortedArr[i] = Integer.parseInt(result[i].split(" ")[0]);
		}
			
		return sortedArr;
	}
}