package baekjoon;

import java.util.*;

public class P01463 {
    public void solution() {
        int n;
        int[] countList;

        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        countList = new int[Math.max(n + 1, 4)];

        countList[1] = 0;
        countList[2] = 1;
        countList[3] = 1;

        for(int i = 4; i <= n; i++) {
            int minCount = Integer.MAX_VALUE;

            if(i % 3 == 0) {
                minCount = Math.min(minCount, (countList[i / 3]));
            }

            if(i % 2 == 0) {
                minCount = Math.min(minCount, (countList[i / 2]));
            }

            minCount = Math.min(minCount, countList[i - 1]);

            countList[i] = minCount + 1;
        }

        System.out.println(countList[n]);
    }
}