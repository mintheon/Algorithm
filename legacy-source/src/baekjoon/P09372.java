package baekjoon;

import java.util.Scanner;

public class P09372 {
    private void visitCountry(int[][] map, int countryCount) {
//        int min

        for(int i = 0; i < countryCount; i++) {
            for(int j = 1; j < countryCount; j++) {
//                map[i][j]
            }
        }
    }

    public void solution() {
        int countryCount, planeCount, testCount;
        int departmentIdx, arriveIdx;
        int answer = 0;

        Scanner input = new Scanner (System.in);

        testCount = input.nextInt();
        for(int i = 0; i < testCount; i++) {
            countryCount = input.nextInt();
            planeCount = input.nextInt();

            for(int j = 0; j < planeCount; j++) {
                departmentIdx = input.nextInt();
                arriveIdx = input.nextInt();
            }

//            int[][] map = new int[countryCount][countryCount];
//            for(int j = 0; j < planeCount; j++) {
//                departmentIdx = input.nextInt();
//                arriveIdx = input.nextInt();
//
//                map[departmentIdx][arriveIdx] = 1;
//                map[arriveIdx][departmentIdx] = 1;
//            }

//            visitCountry(map, countryCount);

            answer = countryCount - 1;
            System.out.println(answer);
        }
    }
}