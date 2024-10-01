package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class P04949 {
    static final String YES = "yes";
    static final String NO = "no";

    public void solution() {
        String sentence;
        Stack<Character> stack = new Stack<>();

        Scanner input = new Scanner(System.in);

        while(true) {
            sentence = input.nextLine();
            if(sentence.equals(".")) break;

            boolean isBalanced = true;
            char text;

            for(int i = 0; i < sentence.length(); i++) {
                text = sentence.charAt(i);

                if(text == '(' || text == '[') {
                    stack.push(text);
                } else if (text == ')') {
                    if(stack.isEmpty() || stack.pop() != '(') {
                        isBalanced = false;
                        break;
                    }
                } else if (text == ']') {
                    if(stack.isEmpty() || stack.pop() != '[') {
                        isBalanced = false;
                        break;
                    }
                }
            }

            if(!stack.isEmpty()) isBalanced = false;
            System.out.println(isBalanced ? YES : NO);
            stack.clear();
        }
    }
}