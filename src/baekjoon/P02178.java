package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a href="boj.kr/2178">미로탐색</a>
 */
public class P02178 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;

    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};

    public static void bfs() {
        Queue<Edge> queue = new LinkedList<>();

        queue.offer(new Edge(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xx = edge.x + dx[i];
                int yy = edge.y + dy[i];

                if (xx < 0 || yy < 0 || xx >= n || yy >= m) {
                    continue;
                } else if (map[xx][yy] == 0 || visited[xx][yy]) {
                    continue;
                }

                queue.offer(new Edge(xx, yy));
                visited[xx][yy] = true;
                map[xx][yy] = map[edge.x][edge.y] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }

        bfs();
        System.out.println(map[n - 1][m - 1]);
    }

    static class Edge {
        int x;
        int y;

        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}