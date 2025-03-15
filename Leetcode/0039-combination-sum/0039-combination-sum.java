//2,3,6,7 -> 7
//2 2 3 -> 7
//2 2 6,7 -> sorting
//7 -> 7

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();

        dfs(answer, candidates, 0, target, new ArrayList<>());

        return answer;
    }

    public void dfs(List<List<Integer>> answer, int[] candidates, int index, int target, List<Integer> sumNums) {
        int sumNum = sum(sumNums);
        if(sumNum == target) {
            answer.add(new ArrayList<>(sumNums));
            return;
        }

        if(sumNum > target) {
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            sumNums.add(candidates[i]);
            dfs(answer, candidates, i, target, sumNums);
            sumNums.removeLast();
        }
    }

    public int sum(List<Integer> nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        return sum;
    }
}