package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @see <a href="boj.kr/2504">괄호의 값</a>
 */
public class P02504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<String> stack = new Stack<>();
        String[] texts = br.readLine().split("");

        for (int i = 0; i < texts.length; i++) {
            int temp = 0;

            switch (texts[i]) {
                case "(":
                case "[":
                    stack.push(texts[i]);
                    break;
                case ")":
                    if (stack.isEmpty()) {
                        System.out.println(0);
                        return;
                    } else if (stack.peek().equals("(")) {
                        stack.pop();
                        stack.push("2");
                    } else {
                        while (!stack.isEmpty()) {
                            if (stack.peek().equals("(")) {
                                stack.pop();
                                temp *= 2;
                                stack.push(String.valueOf(temp));
                                break;
                            } else if (isNumeric(stack.peek())) {
                                temp += Integer.parseInt(stack.pop());
                            } else {
                                System.out.println(0);
                                return;
                            }
                        }
                    }
                    break;
                case "]":
                    if (stack.isEmpty()) {
                        System.out.println(0);
                        return;
                    } else if (stack.peek().equals("[")) {
                        stack.pop();
                        stack.push("3");
                    } else {
                        while (!stack.isEmpty()) {
                            if (stack.peek().equals("[")) {
                                stack.pop();
                                temp *= 3;
                                stack.push(String.valueOf(temp));
                                break;
                            } else if (isNumeric(stack.peek())) {
                                temp += Integer.parseInt(stack.pop());
                            } else {
                                System.out.println(0);
                                return;
                            }
                        }
                    }
                    break;
            }
        }

        int result = 0;

        while (!stack.isEmpty()) {
            if (!isNumeric(stack.peek())) {
                System.out.println(0);
                return;
            }
            result += Integer.parseInt(stack.pop());
        }

        System.out.println(result);
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}