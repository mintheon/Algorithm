package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @see <a href="boj.kr/6198">옥상 정원 꾸미기</a>
 */

// 처음 코드
//public class P06198 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int answer = 0;
//        Stack<Integer> buildings = new Stack<>();
//        Stack<Integer> rightBuildings = new Stack<>();
//        Stack<Integer> tempStack = new Stack<>();
//
//        int n = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < n; i++) {
//            buildings.push(Integer.parseInt(br.readLine()));
//        }
//
//        int building, rightBuilding;
//        for (int i = 0; i < n; i++) {
//            building = buildings.pop();
//
//            while (!rightBuildings.isEmpty()) {
//                rightBuilding = rightBuildings.pop();
//
//                if (building > rightBuilding) {
//                    answer++;
//                    tempStack.push(rightBuilding);
//                } else {
//                    tempStack.push(rightBuilding);
//                    break;
//                }
//            }
//
//            while (!tempStack.isEmpty()) {
//                rightBuildings.push(tempStack.pop());
//            }
//
//            rightBuildings.push(building);
//        }
//
//        System.out.println(answer);
//    }
//}

public class P06198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long answer = 0;
        Stack<Long> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        long building = 0;
        for (int i = 0; i < n; i++) {
            building = Long.parseLong(br.readLine());

            while (!stack.isEmpty() && building >= stack.peek()) {
                stack.pop();
            }

            answer += stack.size();
            stack.push(building);
        }

        System.out.println(answer);
    }
}