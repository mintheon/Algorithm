package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a href="boj.kr/7562">나이트의 이동</a>
 */
public class P07562 {
    static int l;
    static int[][] map;
    static boolean[][] visited;

    static Edge start;
    static Edge end;

    static int moveCount;

    static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void bfs() {
        int xx, yy;
        Edge current;

        Queue<Edge> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            current = queue.poll();

            if (current.x == end.x && current.y == end.y) {
                return;
            }

            for (int i = 0; i < 8; i++) {
                xx = current.x + dx[i];
                yy = current.y + dy[i];

                if (inMap(xx, yy)) {
                    map[yy][xx] = map[current.y][current.x] + 1;
                    visited[yy][xx] = true;
                    queue.offer(new Edge(yy, xx));
                }
            }
        }
    }

    private static boolean inMap(int xx, int yy) {
        if (xx < 0 || yy < 0 || xx > l - 1 || yy > l - 1) {
            return false;
        }
        if (visited[yy][xx]) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());

            map = new int[l][l];
            visited = new boolean[l][l];

            moveCount = 0;

            st = new StringTokenizer(br.readLine());
            start = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            end = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            bfs();
            System.out.println(map[end.y][end.x]);
        }
    }

    static class Edge {
        private int y;
        private int x;

        public Edge(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}