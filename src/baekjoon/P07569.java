package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a href="boj.kr/7569">토마토</a>
 */
public class P07569 {
    static int x;
    static int y;
    static int z;

    static Queue<Node> queue = new LinkedList<>();
    static int[][][] box;
    static boolean[][][] visited;

    static int days = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = Integer.parseInt(st.nextToken());

        box = new int[z][y][x];
        visited = new boolean[z][y][x];

        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < x; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        visited[i][j][k] = true;
                        queue.offer(new Node(i, j, k, 0));
                    }
                }
            }
        }

        dfs();
        System.out.println(isAllCheck() ? days : -1);
    }

    public static void dfs() {
        int[] dz = {0, 0, 0, 0, 1, -1};
        int[] dy = {0, 1, 0, -1, 0, 0};
        int[] dx = {1, 0, -1, 0, 0, 0};

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 6; i++) {
                int zz = current.z + dz[i];
                int yy = current.y + dy[i];
                int xx = current.x + dx[i];

                if (zz < 0 || yy < 0 || xx < 0 || zz >= z || yy >= y || xx >= x) {
                    continue;
                }
                if (box[zz][yy][xx] != 0 || visited[zz][yy][xx]) {
                    continue;
                }

                visited[zz][yy][xx] = true;
                queue.offer(new Node(zz, yy, xx, current.cost + 1));
                days = Math.max(days, current.cost + 1);
            }
        }
    }

    public static boolean isAllCheck() {
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if (box[i][j][k] == 0 && !visited[i][j][k]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    static class Node {
        int z;
        int y;
        int x;
        int cost;

        public Node(int z, int y, int x, int cost) {
            this.z = z;
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }
}