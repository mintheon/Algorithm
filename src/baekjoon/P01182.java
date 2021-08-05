package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a href="boj.kr/1182">부분수열의 합</a>
 */
public class P01182 {
    static int answer;

    static int n, s;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = 0;
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        dfs(0, 0);

        System.out.println(s == 0 ? --answer : answer);
    }

    private static void dfs(int index, int sum) {
        if (index == n) {
            if (sum == s) {
                answer++;
            }
            return;
        }

        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum);
    }
}