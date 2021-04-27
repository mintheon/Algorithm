package baekjoon;

import java.util.*;

public class P11399 {
    public void solution() {
        int n;

        Scanner input = new Scanner (System.in);
        n = input.nextInt();

        int[] bankTime = new int[n];
        for (int i = 0; i < n; i++) {
            bankTime[i] = input.nextInt();
        }

        Arrays.sort(bankTime);

        int sum = 0, prevSum = 0;
        for (int i = 0; i < n; i++) {
            prevSum += bankTime[i];
            sum += prevSum;
        }

        System.out.println(sum);
    }
}