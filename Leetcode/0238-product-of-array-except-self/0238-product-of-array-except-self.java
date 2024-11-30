class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer1 = new int[nums.length];
        int[] answer2 = new int[nums.length];

        answer1[0] = 1;
        answer2[nums.length - 1] = 1;

        for(int i = 1; i < nums.length; i++) {
            answer1[i] = answer1[i - 1] * nums[i - 1];
        }

        for(int i = nums.length - 2; i >= 0; i--) {
            answer2[i] = answer2[i + 1] * nums[i + 1];
        }

        int[] answer = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            answer[i] = answer1[i] * answer2[i];
        }

        return answer;
    }
}