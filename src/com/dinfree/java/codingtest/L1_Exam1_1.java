package com.dinfree.java.codingtest;
import java.util.stream.*;
import java.util.*;

class L1_Exam1_1 {
    private static final String FORMAT_ENTER_MESSAGE = "%s님이 들어왔습니다.";
    private static final String FORMAT_LEAVE_MESSAGE = "%s님이 나갔습니다.";
    // Enter [유저 아이디] [닉네임]
    // Leave [유저 아이디]
    // Change [유저 아이디] [닉네임]

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String[] input = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan" };
		//String[] input = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Enter uid7890 Hwang", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan", "Change uid7890 Kang" };
		L1_Exam1_1 app = new L1_Exam1_1();
		String[] result = app.solution(input);
		for(String s : result) {
			System.out.println(s);
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000.0);
	}
	
    public String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap();

        // register user id and nickname
        Stream.of(record)
            .filter(o -> o.startsWith("Enter") || o.startsWith("Change"))
            .forEach(o -> createOrUpdateUser(userMap, o));

        List<String> records = new ArrayList<>();

        // answer 
        return Stream.of(record)
            .map(o -> getFormattedMessage(userMap, o))
            .filter(o -> !"".equals(o))
            .toArray(String[]::new);
    }

    private void createOrUpdateUser(Map<String, String> userMap, 
                                    String messages) {
        String userId = messages.split(" ")[1];
        String nickname = messages.split(" ")[2];
        userMap.put(userId, nickname);
    }

    private String getFormattedMessage(Map<String, String> userMap, String message) {
        String userId = message.split(" ")[1];
        switch (message.split(" ")[0]) {
            case "Enter":
                return String.format(FORMAT_ENTER_MESSAGE, userMap.get(userId));
            case "Leave":
                return String.format(FORMAT_LEAVE_MESSAGE, userMap.get(userId));
            default:
                return "";
        }
    }
}