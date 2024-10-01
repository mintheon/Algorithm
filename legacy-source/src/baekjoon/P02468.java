package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @see <a href="boj.kr/2468">안전영역</a>
 */
public class P02468 {
    static int n;
    static int[][] map;
    static boolean[][] visited;

    static Set<Integer> highs = new HashSet<>();

    static int maxSafeArea = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        highs.add(0);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                highs.add(map[i][j]);
            }
        }

        for (int rain : highs) {
            visited = new boolean[n][n];

            int safeAreaCount = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > rain && !visited[i][j]) {
                        dfs(i, j, rain);
                        safeAreaCount++;
                    }
                }
            }

            maxSafeArea = Math.max(maxSafeArea, safeAreaCount);
        }

        System.out.println(maxSafeArea);
    }

    private static void dfs(int x, int y, int rain) {
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};

        Queue<Node> queue = new LinkedList();

        visited[x][y] = true;
        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xx = current.x + dx[i];
                int yy = current.y + dy[i];

                if (xx < 0 || yy < 0 || xx >= n || yy >= n) {
                    continue;
                }
                if (map[xx][yy] <= rain || visited[xx][yy]) {
                    continue;
                }

                visited[xx][yy] = true;
                queue.offer(new Node(xx, yy));
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}