package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a href="boj.kr/15656">N과 M(7)</a>
 */
public class P15656 {
    static int n, m;

    static int[] numbers;
    static int[] combinations;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[n];
        combinations = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int depth = 0;
        dfs(depth);

        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            for (int number : combinations) {
                sb.append(number).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 0; i < n; i++) {
            combinations[depth] = numbers[i];
            dfs(depth + 1);
        }
    }
}