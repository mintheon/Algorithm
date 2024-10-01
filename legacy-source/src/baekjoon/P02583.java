package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @see <a href="boj.kr/2583">영역 구하기</a>
 */
public class P02583 {
    static int m;
    static int n;
    static int k;

    static int map[][];
    static boolean visited[][];

    static List<Integer> areas = new ArrayList<>();
    static int squareCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    map[j][k] = 1;
                    visited[j][k] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 && visited[i][j] == false) {
                    areas.add(dfs(i, j));
                    squareCount++;
                }
            }
        }

        Collections.sort(areas);
        for (int area : areas) {
            sb.append((area == 0 ? 1 : area) + " ");
        }

        System.out.println(squareCount);
        System.out.println(sb.toString().trim());
    }

    private static int dfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int area = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xx = current.x + dx[i];
                int yy = current.y + dy[i];

                if (xx < 0 || yy < 0 || xx >= m || yy >= n) {
                    continue;
                }
                if (map[xx][yy] != 0 || visited[xx][yy]) {
                    continue;
                }

                visited[xx][yy] = true;
                area++;
                queue.offer(new Node(xx, yy));
            }
        }

        return area;
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}