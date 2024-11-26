class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int pairCount = nums.length / 2;
        int sum = 0;

        for(int i = 0; i < pairCount; i++) {
            sum += nums[i * 2];
        }

        return sum;
    }
}