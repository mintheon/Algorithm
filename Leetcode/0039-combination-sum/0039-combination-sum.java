class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new LinkedList<>();

        sum(candidates, target, 0, new ArrayList<>(), answer);

        return answer;
    }

    public void sum(int[] candidates, int remain, int index, List<Integer> nums, List<List<Integer>> answer) {
        if(remain == 0) {
            answer.add(new ArrayList<>(nums));
            return;
        }

        if(remain < 0) {
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            nums.add(candidates[i]);
            sum(candidates, remain - candidates[i], i, nums, answer);
            nums.remove(nums.size() - 1);
        }
    }
}