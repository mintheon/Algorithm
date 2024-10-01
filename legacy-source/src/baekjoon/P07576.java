package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a href="boj.kr/7576">토마토</a>
 */
public class P07576 {
    static int n, m;

    static int[][] map;
    static int[][] costMap;
    static boolean[][] visited;

    static int dayCount = 0;

    static void bfs() {
        Queue<Edge> queue = new LinkedList<>();

        costMap = new int[n][m];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1) {
                    visited[i][j] = true;
                    queue.offer(new Edge(i, j));
                }
            }
        }

        while(!queue.isEmpty()) {
            Edge current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int xx = current.x + dx[i];
                int yy = current.y + dy[i];

                if(xx < 0 || yy < 0 || xx > n - 1 || yy > m -1) {
                    continue;
                }
                if(visited[xx][yy] || map[xx][yy] != 0) {
                    continue;
                }

                costMap[xx][yy] = costMap[current.x][current.y] + 1;
                visited[xx][yy] = true;
                dayCount = Math.max(dayCount, costMap[xx][yy]);
                queue.offer(new Edge(xx, yy));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        System.out.println(isAllRipen() ? dayCount : -1);
    }

    static boolean isAllRipen() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0 && costMap[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
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