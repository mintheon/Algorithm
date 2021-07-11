package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @see <a href="boj.kr/15650">N과 M(2)</a>
 */
public class P15650 {
    static boolean visited[];
    static int numbers[];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        numbers = new int[m];

        dfs(n, m, 0, 0);
        System.out.println(sb);
    }

    private static void dfs(int n, int m, int depth, int parent) {
        if (m == depth) {
            for (int number : numbers) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = parent; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                numbers[depth] = i + 1;
                dfs(n, m, depth + 1, i);

                visited[i] = false;
            }
        }
        return;
    }
}