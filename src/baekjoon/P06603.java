package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @see <a href="boj.kr/6603">로또</a>
 */
public class P06603 {
    static final int MAX_COUNT = 6;

    static int k;
    static int[] inputs;
    static int[] numbers;
    static boolean[] isVisited;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                return;
            }

            sb = new StringBuilder();
            inputs = new int[k];
            numbers = new int[MAX_COUNT];
            isVisited = new boolean[k];

            for (int i = 0; i < k; i++) {
                inputs[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            System.out.println(sb);
        }
    }

    private static void dfs(int start, int depth) {
        if (depth == MAX_COUNT) {
            for (int i = 0; i < MAX_COUNT; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            if (isVisited[i]) {
                continue;
            }

            isVisited[i] = true;
            numbers[depth] = inputs[i];
            dfs(i + 1, depth + 1);
            isVisited[i] = false;
        }
    }
}