package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @see <a href="boj.kr/16987">계란으로 계란치기</a>
 */
public class P16987 {
    static final int DURABILITY = 0;
    static final int WEIGHT = 1;
    static int answer;

    static int n;
    static int[][] eggs;
    static boolean[] isBreak;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        answer = 0;
        n = Integer.parseInt(br.readLine());
        eggs = new int[n][2];
        isBreak = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            eggs[i][DURABILITY] = Integer.parseInt(st.nextToken());
            eggs[i][WEIGHT] = Integer.parseInt(st.nextToken());
        }

        breakEgg(0, 0);
        System.out.println(answer);
    }

    private static void breakEgg(int index, int sumCount) {
        if (index == n) {
            return;
        }
        if (isBreak[index]) {
            breakEgg(index + 1, sumCount);
            return;
        }

        for (int i = 0; i < n; i++) {
            int tempCount = 0;

            if (isBreak[i] || i == index) {
                continue;
            }

            eggs[index][DURABILITY] -= eggs[i][WEIGHT];
            eggs[i][DURABILITY] -= eggs[index][WEIGHT];

            if (eggs[index][DURABILITY] <= 0) {
                isBreak[index] = true;
                tempCount++;
            }
            if (eggs[i][DURABILITY] <= 0) {
                isBreak[i] = true;
                tempCount++;
            }

            answer = Math.max(sumCount + tempCount, answer);
            breakEgg(index + 1, sumCount + tempCount);

            // 계란 복구
            if (eggs[index][DURABILITY] <= 0) {
                isBreak[index] = false;
            }
            if (eggs[i][DURABILITY] <= 0) {
                isBreak[i] = false;
            }
            eggs[index][DURABILITY] += eggs[i][WEIGHT];
            eggs[i][DURABILITY] += eggs[index][WEIGHT];
        }
    }
}