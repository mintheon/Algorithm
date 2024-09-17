class Solution {
    public int removeElement(int[] nums, int val) {
        int[] numsCopy = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            numsCopy[i] = nums[i];
        }

        int p = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(numsCopy[i] != val) {
                nums[p++] = numsCopy[i];
                count++;
            }
        }

        for(int i = nums.length - 1; i > count; i--) {
            nums[i] = '_';
        }

        return count;
    }
}