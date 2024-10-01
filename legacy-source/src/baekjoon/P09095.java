package baekjoon;

import java.util.Scanner;

public class P09095 {
    public void solution() {
        int[] arr = new int[11];
        int t, n;

        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        Scanner input = new Scanner(System.in);
        t = input.nextInt();

        for(int i = 0; i < t; i++) {
            n = input.nextInt();

            for(int j = 3; j <= n; j++) {
                arr[j] = arr[j - 1] + arr [j - 2] + arr[j - 3];
            }

            System.out.println(arr[n]);
        }
    }
}