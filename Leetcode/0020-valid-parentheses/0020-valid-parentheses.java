class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.offerLast(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }

                char last = stack.pollLast();
                if((c == ')' && last != '(')
                    || (c == ']' && last != '[')
                    || (c == '}' && last != '{')) {
                        return false;
                    }
            }
        }

        return stack.isEmpty();
    }
}