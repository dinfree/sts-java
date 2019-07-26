package com.dinfree.java.codingtest;
import java.util.*;

public class L1_Exam1 {
	HashMap<String,String> userlist = new HashMap<>();
	ArrayList<String> logs = new ArrayList<>();

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String[] input = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan" };
		L1_Exam1 app = new L1_Exam1();
		String[] result = app.solution(input);
		for(String s : result) {
			System.out.println(s);
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000.0);
	}

	public String[] solution(String[] record) {		
		// build userlist
		for(String msg : record) {
			StringTokenizer st = new StringTokenizer(msg," ");
			String cmd = st.nextToken();
			String id = st.nextToken();
			if(cmd.equals("Enter") || cmd.equals("Change")) {
				String name = st.nextToken();
				userlist.put(id, name);
			}
		}
		
		// build message
		for(String msg : record) {
			String cmd = msg.split(" ")[0];
			String id = msg.split(" ")[1];
			if(cmd.equals("Enter")) {
				logs.add(String.format("%s님이 들어왔습니다.", userlist.get(id)));
			} else if(cmd.equals("Leave")) {
				logs.add(String.format("%s님이 나갔습니다.", userlist.get(id)));
			}
		}		
		return logs.toArray(String[]::new);
		//return logs.toArray(new String[logs.size()]);
	}
}