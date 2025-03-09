class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Boolean> visited = new HashMap<>();
        Map<Character, Integer> index = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            index.put(s.charAt(i), i);
        }

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(visited.get(c) != null && visited.get(c)) {
                continue;
            }

            while(!stack.isEmpty() 
                && stack.peek() > c
                && index.get(stack.peek()) > i) {
                visited.put(stack.pop(), false);
            }

            stack.push(c);
            visited.put(c, true);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}