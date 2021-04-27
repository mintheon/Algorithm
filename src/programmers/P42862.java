package programmers;

import java.util.Arrays;

public class P42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] hasCloth = new int[n + 1];
        Arrays.fill(hasCloth, 0);

        for (int reservePerson : reserve) {
            hasCloth[reservePerson] = 1;
        }
        Arrays.sort(reserve);

        answer += (n - lost.length);

        for(int i = 0; i < lost.length; i++) {
            if(hasCloth[lost[i]] == 1) {
                hasCloth[lost[i]] = 0;
                answer += 1;
            } else if (hasCloth[lost[i] - 1] == 1) {
                hasCloth[lost[i] - 1] = 0;
                answer += 1;
            } else if (i != lost.length -1 && hasCloth[lost[i] + 1] == 1) {
                hasCloth[lost[i] + 1] = 0;
                answer += 1;
            }
        }

        return answer;
    }
}
