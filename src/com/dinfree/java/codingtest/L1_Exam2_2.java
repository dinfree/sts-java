package com.dinfree.java.codingtest;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class L1_Exam2_2 {
	HashMap<String,String> userlist = new HashMap<>();
	ArrayList<String> logs = new ArrayList<>();

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] input = {2, 1, 2, 6, 2, 4, 3, 3};
		L1_Exam2_2 app = new L1_Exam2_2();
		int[] result = app.solution(5,input);
		for(int s : result) {
			System.out.println(s);
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000.0);
	}

    private class StageInfo {
        public long failCount;
        public long challengeCount;
        public int stageId;

        public StageInfo(int stageId) {
            this.stageId = stageId;
        }
    }

    public int[] solution(int N, int[] stages) {
        StageInfo[] stageInfoList = new StageInfo[N];

        for (int i = 0; i < N; i++) {
            stageInfoList[i] = new StageInfo(i + 1);
        }

        for (int stage : stages) {
            int endStage = stage > N ? N : stage;

            for (int i = 0; i < endStage; i++) {
                stageInfoList[i].challengeCount++;
            }

            if(stage <= N) {
                stageInfoList[stage - 1].failCount++;
            }

        }
        // cnt/(totalPlayer-failPlayer
        
        Arrays.stream(stageInfoList).forEach(x -> System.out.printf("%d:%d,%d\n", x.stageId,x.failCount, x.challengeCount));
        return Arrays.stream(stageInfoList)
                .sorted((a, b) -> -Double.compare(a.failCount*b.challengeCount , b.failCount*a.challengeCount))
                .mapToInt(info -> info.stageId)
                .toArray();
    }
}