class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Deque<Integer> nums = new ArrayDeque<>();

        backtracking(candidates, answer, nums, target, 0, 0);
        
        return answer;
    }

    protected void backtracking(int[] candidates, List<List<Integer>> answer, Deque<Integer> nums, int target, int start, int total) {
        if(total > target) {
            return;
        }

        if (total == target) {
            answer.add(new ArrayList<>(nums));
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            nums.push(num);

            backtracking(candidates, answer, nums, target, i, total + num);
            nums.pop();
        }
    }
}