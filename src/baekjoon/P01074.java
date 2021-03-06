package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @see <a href="boj.kr/1074">Z</a>
 */
public class P01074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(search(n, r, c));
    }

    private static int search(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }

        int half = 1 << (n - 1);

        if (r < half && c < half) {
            return search(n - 1, r, c);
        }
        if (r < half && c >= half) {
            return (half * half) + search(n - 1, r, c - half);
        }
        if (r >= half && c < half) {
            return (2 * half * half) + search(n - 1, r - half, c);
        }

        return (3 * half * half) + search(n - 1, r - half, c - half);
    }
}