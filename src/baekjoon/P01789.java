package baekjoon;

import java.util.Scanner;

public class P01789 {
    public void solution() {
        Scanner input = new Scanner(System.in);

        long s = input.nextLong();

        long left = 1,
                right = s,
                answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = mid * (mid + 1) / 2;
            if(sum <= s) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}