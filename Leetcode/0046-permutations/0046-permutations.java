class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        permutations(nums, answer, new LinkedList<>());

        return answer;
    }

    public void permutations(int[] nums, List<List<Integer>> answer, List<Integer> permuteNums) {
        if(permuteNums.size() == nums.length) {
            answer.add(new ArrayList<>(permuteNums));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(permuteNums.contains(nums[i])) {
                continue;
            }

            permuteNums.add(nums[i]);
            permutations(nums, answer, permuteNums);
            permuteNums.remove(permuteNums.size() - 1);
        }
    }
}