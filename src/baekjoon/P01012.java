package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @see <a href="boj.kr/1012">유기농 배추</a>
 */
public class P01012 {
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    static boolean[][] visited;
    static int[][] map;

    static int t;
    static int n, m, k;
    static int fieldCount;

    static void dfs(int x, int y) {
        int xx, yy;

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            xx = x + dx[i];
            yy = y + dy[i];

            if (xx < 0 || yy < 0 || xx > m - 1 || yy > n - 1) {
                continue;
            }
            if (map[yy][xx] != 1 || visited[yy][xx]) {
                continue;
            }

            dfs(xx, yy);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            fieldCount = 0;

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            visited = new boolean[n][m];
            map = new int[n][m];

            int x, y;
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[j][k] != 1 || visited[j][k]) {
                        continue;
                    }

                    dfs(k, j);
                    fieldCount++;
                }
            }

            System.out.println(fieldCount);
        }
    }
}