package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @see <a href="boj.kr/11729">하노이 탑 이동 순서</a>
 */
public class P11729 {
    static int n;
    static int moveCount;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        hanoi(n, 1, 2, 3);

        System.out.println(moveCount);
        System.out.println(sb.toString());
    }

    private static void hanoi(int plateCount, int start, int temp, int end) {
        if(plateCount == 1) {
            move(start, end);
            return;
        }

        hanoi(plateCount - 1, start, end, temp);
        move(start, end);
        hanoi(plateCount - 1, temp, start, end);
    }

    private static void move(int a, int b) {
        moveCount++;
        sb.append(a)
                .append(" ")
                .append(b)
                .append("\n");
    }
}