package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a href="boj.kr/15655">N과 M(6)</a>
 */
public class P15655 {
    static int n, m;

    static int[] numbers;
    static int[] combinationNumbers;

    static boolean[] isVisited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[n];
        combinationNumbers = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int depth = 0;
        dfs(depth, 0);

        System.out.println(sb);
    }

    private static void dfs(int depth, int startNum) {
        if (depth == m) {
            for (int number : combinationNumbers) {
                sb.append(number).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = startNum; i < n; i++) {
            combinationNumbers[depth] = numbers[i];
            dfs(depth + 1, i + 1);
        }
    }
}