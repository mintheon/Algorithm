class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();

        int volume = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer top = stack.pop();

                if(stack.isEmpty()) {
                    break;
                }

                // 3 - 1 - 1
                int distance = i - stack.peek() - 1;

                // 2 or 1 중에 작은거 -> 1
                // 1 - 0 = 1
                int waters = Math.min(height[i], height[stack.peek()]) - height[top];

                volume += distance * waters;
            }

            stack.push(i);
        }

        return volume;
    }
}