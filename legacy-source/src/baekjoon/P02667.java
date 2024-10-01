package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @see <a href="boj.kr/2667">단지번호붙이기</a>
 */
public class P02667 {
    static int houseCount = 0;
    static List<Integer> areas = new ArrayList<>();
    private static int n;
    private static String[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new String[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ("1".equals(map[i][j]) && !visited[i][j]) {
                    areas.add(dfs(i, j));
                    houseCount++;
                }
            }
        }

        System.out.println(houseCount);

        Collections.sort(areas);
        for (int area : areas) {
            System.out.println(area);
        }
    }

    private static int dfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        visited[x][y] = true;
        queue.offer(new Node(x, y));

        int area = 1;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xx = current.x + dx[i];
                int yy = current.y + dy[i];

                if (xx < 0 || yy < 0 || xx >= n || yy >= n) {
                    continue;
                }
                if ("0".equals(map[xx][yy]) || visited[xx][yy]) {
                    continue;
                }

                visited[xx][yy] = true;
                queue.offer(new Node(xx, yy));
                area++;
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