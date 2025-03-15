//시간복잡도: O(2^n)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();

        dfs(answer, candidates, 0, target, new ArrayList<>());

        return answer;
    }

    public void dfs(List<List<Integer>> answer, int[] candidates, int index, int target, List<Integer> sumNums) {
        if(target == 0) {
            answer.add(new ArrayList<>(sumNums));
            return;
        }

        if(target < 0) {
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            sumNums.add(candidates[i]);
            dfs(answer, candidates, i, target - candidates[i], sumNums);
            sumNums.removeLast();
        }
    }
}