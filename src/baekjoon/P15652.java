package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @see <a href="boj.kr/15652">N과 M(4)</a>
 */
public class P15652 {
    static int[] numbers;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        numbers = new int[m];

        sb = new StringBuilder();

        int dep = 1;
        int start = 1;
        dfs(n, m, dep, start);

        System.out.println(sb);
    }

    private static void dfs(int n, int m, int dep, int start) {
        if (dep - 1 == m) {
            for (int storage : numbers) {
                sb.append(storage).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = start; i <= n; i++) {
            numbers[dep - 1] = i;
            dfs(n, m, dep + 1, i);
        }
    }
}