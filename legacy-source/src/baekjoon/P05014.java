package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a href="boj.kr/5014">스타트링크</a>
 */
public class P05014 {
    static int f, s, g, u, d;

    static int[] floors;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        floors = new int[f + 1];
        visited = new boolean[f + 1];

        bfs();
        if (g == s) {
            System.out.println(0);
        } else {
            System.out.println(floors[g] - floors[s] > 0
                    ? floors[g] - floors[s]
                    : "use the stairs");
        }

    }

    private static void bfs() {
        int[] move = {u, -d};
        Queue<Node> queue = new LinkedList();
        visited[s] = true;
        queue.offer(new Node(s, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 2; i++) {
                int x = current.floor + move[i];

                if (x < 1 || x > f) {
                    continue;
                }
                if (visited[x]) {
                    continue;
                }

                visited[x] = true;
                floors[x] = current.cost + 1;
                queue.offer(new Node(x, floors[x]));
            }
        }
    }

    static class Node {
        int floor;
        int cost;

        public Node(int floor, int cost) {
            this.floor = floor;
            this.cost = cost;
        }
    }
}