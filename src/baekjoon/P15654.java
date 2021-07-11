package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a href="boj.kr/15654">N과 M(5)</a>
 */
public class P15654 {
    static int[] numbers;
    static int[] combinationNumbers;

    static boolean[] isVisited;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        numbers = new int[n];
        combinationNumbers = new int[m];
        isVisited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        sb = new StringBuilder();

        int dep = 1;
        dfs(n, m, dep);

        System.out.println(sb);
    }

    private static void dfs(int n, int m, int dep) {
        if (dep - 1 == m) {
            for (int storage : combinationNumbers) {
                sb.append(storage).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 0; i < n; i++) {
            if (isVisited[i]) {
                continue;
            }

            combinationNumbers[dep - 1] = numbers[i];
            isVisited[i] = true;

            dfs(n, m, dep + 1);
            isVisited[i] = false;
        }
    }
}