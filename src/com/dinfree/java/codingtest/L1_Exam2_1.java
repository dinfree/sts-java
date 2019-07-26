package com.dinfree.java.codingtest;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class L1_Exam2_1 {
	HashMap<String,String> userlist = new HashMap<>();
	ArrayList<String> logs = new ArrayList<>();

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] input = {2, 1, 2, 6, 2, 4, 3, 3};
		L1_Exam2_1 app = new L1_Exam2_1();
		int[] result = app.solution(5,input);
		for(int s : result) {
			System.out.println(s);
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000.0);
	}

    private class ClearInfo {
        public long failedCount;
        public long challengedCount;
        public int stageId;

        public ClearInfo(int stageId) {
            this.stageId = stageId;
        }
    }

    public int[] solution(int N, int[] stages) {
        ClearInfo[] clearInfoList = new ClearInfo[N];

        for (int i = 0; i < N; i++) {
            clearInfoList[i] = new ClearInfo(i + 1);
        }

        for (int stage : stages) {
            int endStage = stage > N ? N : stage;

            for (int i = 0; i < endStage; i++) {
                clearInfoList[i].challengedCount++;
            }

            if(stage <= N) {
                clearInfoList[stage - 1].failedCount++;
            }

        }

        return Arrays.stream(clearInfoList)
                .sorted((a, b) -> -Long.compare(a.failedCount * b.challengedCount, b.failedCount * a.challengedCount))
                .mapToInt(info -> info.stageId)
                .toArray();
    }
}