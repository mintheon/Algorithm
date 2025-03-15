//1 2 4
//124
//1 2 + 4
//1 + 2
//1

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        dfs(answer, nums, new ArrayList<>());

        return answer;
    }

    public void dfs(List<List<Integer>> answer, int[] nums, List<Integer> permuteNums) {
        if(permuteNums.size() == nums.length) {
            answer.add(new ArrayList<>(permuteNums));
            return;
        }

        for(Integer num : nums) {
            if(permuteNums.contains(num)) {
                continue;
            }

            permuteNums.add(num);
            dfs(answer, nums, permuteNums);
            permuteNums.remove(num);
        }
    }
}