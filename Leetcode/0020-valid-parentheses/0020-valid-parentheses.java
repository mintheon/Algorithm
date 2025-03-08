class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }

                char other = stack.pop();

                if((other == '(' && c != ')') || (other == '[' && c != ']') || (other == '{' && c != '}')) {
                    return false;
                }
            }
        }

        return stack.isEmpty() ? true : false;
    }
}