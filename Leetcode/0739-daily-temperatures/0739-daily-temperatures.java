//시간복잡도: O(n)
//공간복잡도: O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> lastDays = new ArrayDeque<>();

        for(int day = 0; day < temperatures.length; day++) {
            while(!lastDays.isEmpty() && temperatures[lastDays.peek()] < temperatures[day]) {
                int lastDay = lastDays.pop();
                answer[lastDay] = day - lastDay;
            }

            lastDays.push(day);
        }

        return answer;
    }
}