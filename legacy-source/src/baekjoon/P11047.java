package baekjoon;

import java.util.*;

public class P11047 {
    public void solution() {
        int n, k;
        int currentIdx;
        int coinCount = 0;
        Integer[] coins;

        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        coins = new Integer[n];
        currentIdx = n - 1;

        k = input.nextInt();

        for(int i = 0; i < n; i++) {
            coins[i] = input.nextInt();
        }

        while (k > 0) {
            for(int i = currentIdx; i > 0; i--) {
                if(coins[i] <= k) {
                    k -= coins[i];
                    currentIdx = i;
                    coinCount++;
                    break;
                }
            }
        }

        System.out.println(coinCount);
    }
}
