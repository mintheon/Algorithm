package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @see <a href="boj.kr/4889">안정적인 문자열</a>
 */
public class P04889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int index = 0;
        Stack<String> stack = new Stack<>();

        while (true) {
            int answer = 0;
            String[] texts = br.readLine().split("");

            if (texts[0].equals("-")) {
                break;
            }

            sb.append(++index + ". ");

            for (String text : texts) {
                if (stack.isEmpty()) {
                    stack.push(text);
                } else if (stack.peek().equals("{") && text.equals("}")) {
                    stack.pop();
                } else {
                    stack.push(text);
                }
            }

            while (!stack.isEmpty()) {
                switch (stack.pop()) {
                    case "}":
                        if (stack.pop().equals("}")) {
                            answer++;
                        }
                        break;
                    case "{":
                        if (stack.pop().equals("}")) {
                            answer++;
                        }
                        answer++;
                        break;
                }
            }

            sb.append(answer + "\n");
        }

        System.out.println(sb.toString());
    }
}