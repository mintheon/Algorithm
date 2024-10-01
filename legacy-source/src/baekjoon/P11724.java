package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P11724 {
    public void solution() {
        Scanner input = new Scanner(System.in);
        int answer = 0;

        int n = input.nextInt(),
                m = input.nextInt();

        boolean canVisit[][] = new boolean[n + 1][n + 1];

        for(int i = 0; i < m; i++) {
            int u = input.nextInt(),
                    v = input.nextInt();
            canVisit[u][v] = canVisit[v][u] = true;
        }

        Queue<Integer> queue = new LinkedList();
        boolean visited[] = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            if(visited[i]) {
                continue;
            }

            queue.add(i);

            while(!queue.isEmpty()) {
                int idx = queue.poll();

                for(int j = i; j <= n; j++) {
                    if(!visited[j] && canVisit[idx][j]) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
            answer++;
        }

        System.out.println(answer);
    }
}