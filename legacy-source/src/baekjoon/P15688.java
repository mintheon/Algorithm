package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @see <a href="boj.kr/15688"수 정렬하기5</a>
 */
public class P15688 {
    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int n = Integer.parseInt(br.readLine());
//
//        int[] numbers = new int[n];
//        for (int i = 0; i < n; i++) {
//            numbers[i] = Integer.parseInt(br.readLine());
//        }
//
//        Arrays.sort(numbers);
//
//        for (int i = 0; i < n; i++) {
//            sb.append(numbers[i] + "\n");
//        }
//
//        System.out.print(sb.toString());

        // Counting Sort 방식1
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int[] positiveNumbers = new int[1000001];
//        int[] negativeNumbers = new int[1000001];
//
//        int n = Integer.parseInt(br.readLine());
//
//        int inputNumber;
//        for (int i = 0; i < n; i++) {
//            inputNumber = Integer.parseInt(br.readLine());
//
//            if (inputNumber >= 0) {
//                positiveNumbers[inputNumber]++;
//            } else {
//                negativeNumbers[Math.abs(inputNumber)]++;
//            }
//        }
//
//        for (int i = 1000000; i > 0; i--) {
//            for (int j = 0; j < negativeNumbers[i]; j++) {
//                sb.append(-i).append("\n");
//            }
//        }
//
//        for (int i = 0; i <= 1000000; i++) {
//            for (int j = 0; j < positiveNumbers[i]; j++) {
//                sb.append(i).append("\n");
//            }
//        }
//
//        System.out.print(sb.toString());

        // Counting Sort 방식
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] numbers = new int[2_000_001];

        int n = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int inputNumber = Integer.parseInt(br.readLine()) + 1_000_000;
            numbers[inputNumber]++;
            max = Math.max(max, inputNumber);
        }

        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < numbers[i]; j++) {
                sb.append(i - 1_000_000).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}