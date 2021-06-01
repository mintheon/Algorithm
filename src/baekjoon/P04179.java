package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a href="boj.kr/4179">불!</a>
 */
public class P04179 {
    static int r, c;

    static String[][] map;
    static int[][] cost;
    static boolean[][] visited;
    static Edge jihoon;
    static Edge fire;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new String[r][c];
        cost = new int[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().split("");
        }

        dfs();
    }

    public static void dfs() {
        Queue<Edge> jihoonQueue = new LinkedList<>();
        Queue<Edge> fireQueue = new LinkedList<>();

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        findJihoonAndFire();

        jihoonQueue.offer(new Edge(jihoon.r, jihoon.c));
        fireQueue.offer(new Edge(fire.r, fire.c));

        while (!jihoonQueue.isEmpty()) {
            Edge current = jihoonQueue.poll();

            for (int i = 0; i < 4; i++) {
                int rr = current.r + dr[i];
                int cc = current.c + dc[i];

                if (map[rr][cc].equals("#")) {
                    continue;
                }
            }
        }
    }

    public static void findJihoonAndFire() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j].equals("J")) {
                    jihoon = new Edge(i, j);
                    continue;
                }
                if (map[i][j].equals("F")) {
                    fire = new Edge(i, j);
                    continue;
                }
            }
        }
    }

    static class Edge {
        int r;
        int c;

        public Edge(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}