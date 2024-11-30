class Solution {
    public int[] productExceptSelf(int[] nums) {
        int answer[] = new int [nums.length];

        int result = 1;
        for(int i = 0; i < nums.length; i++) {
            answer[i] = result;
            result *= nums[i];
        }

        result = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= result;
            result *= nums[i];
        }

        return answer;
    }
}