package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P14889 {
    private static int n;
    private static int[][] statMap;
    private static boolean[] visited;
    private static int answer = Integer.MAX_VALUE;

    public void solution() {
        Scanner input = new Scanner (System.in);
        n = input.nextInt();
        statMap = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                statMap[i][j] = input.nextInt();
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int idx, int visitCount) {
        if(n / 2 == visitCount) {
            setTeam();
        }
        else {
            for (int i = idx + 1; i <= n; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    dfs(i, visitCount + 1);
                }
            }
        }
        visited[idx] = false;
    }

    public static void setTeam() {
        int[] a = new int[(n / 2) + 1];
        int[] b = new int[(n / 2) + 1];

        int ap = 1, bp = 1;
        for(int i = 1; i <= n; i++) {
            if(visited[i]) {
                a[ap++] = i;
            } else {
                b[bp++] = i;
            }
        }

        int diff = Math.abs(getStat(a) - getStat(b));

        if(answer > diff) {
            answer = diff;
        }
    }

    public static int getStat(int[] teamList) {
        int stat = 0;
        int count = n / 2;

        for(int i = 1; i <= count; i++) {
            for(int j = i + 1; j <= count; j++) {
                stat += statMap[teamList[i]][teamList[j]];
                stat += statMap[teamList[j]][teamList[i]];
            }
        }

        return stat;
    }
}