

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        dfs(answer, nums, 0, new ArrayList<>());

        return answer;
    }

    public void dfs(List<List<Integer>> answer, int[] nums, int index, List<Integer> numSubsets) {
        answer.add(new ArrayList<>(numSubsets));

        for(int i = index; i < nums.length; i++) {
            numSubsets.add(nums[i]);
            dfs(answer, nums, i + 1, numSubsets);
            numSubsets.removeLast();
        }
    }
}