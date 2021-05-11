package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @see <a href="boj.kr/10799">쇠막대기</a>
 */
public class P10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String brackets = br.readLine();
        Stack<Boolean> stack = new Stack<>();

        int pipeCount = 0;

        if (brackets.charAt(0) == '(') {
            stack.push(true);
        }

        for (int i = 1; i < brackets.length(); i++) {
            switch (brackets.charAt(i)) {
                case '(':
                    stack.push(true);
                    break;
                case ')':
                    if (brackets.charAt(i - 1) == '(') {
                        stack.pop();
                        pipeCount += stack.size();
                    } else {
                        stack.pop();
                        pipeCount += 1;
                    }
                    break;
            }
        }

        System.out.println(pipeCount);
    }
}