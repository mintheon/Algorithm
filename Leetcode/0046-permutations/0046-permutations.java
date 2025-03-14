//시간 복잡도: O(n! * n)
//공간 복잡도: O(n * n!)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        dfs(answer, new HashSet<>(), nums, new ArrayList<>());

        return answer;
    }

    public void dfs(List<List<Integer>> answer, Set<Integer> used, int[] nums, List<Integer> permuteNum) {
        if(permuteNum.size() == nums.length) {
            answer.add(new ArrayList<>(permuteNum));
            return;
        }

        for(int num : nums) {
            if(!used.contains(num)) {
                permuteNum.add(num);
                used.add(num);
                dfs(answer, used, nums, permuteNum);
                permuteNum.remove(permuteNum.size() - 1);
                used.remove(num);
            }
        }
    }
}