package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 * @see <a href="boj.kr/15666">N과 M(12)</a>
 */
public class P15666 {
    static int n, m;

    static int[] numbers;
    static int[] combinations;
    static boolean[] isVisited;

    static StringBuilder sb = new StringBuilder();
    static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[n];
        combinations = new int[m];
        isVisited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        dfs(0, 0);

        for (String text : set) {
            sb.append(text);
        }
        System.out.println(sb);
    }

    private static void dfs(int depth, int start) {
        if (depth == m) {
            for (int number : combinations) {
                sb.append(number).append(" ");
            }
            sb.append("\n");

            set.add(sb.toString());
            sb.setLength(0);

            return;
        }

        for (int i = start; i < n; i++) {
            if (isVisited[i]) {
                continue;
            }

            combinations[depth] = numbers[i];
            dfs(depth + 1, i);
        }
    }
}