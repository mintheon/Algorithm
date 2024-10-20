class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            Integer other = numMap.get(target - nums[i]);

            if(other == null || other == i) {
                continue;
            } else {
                return new int[] {i, other};
            }
        }

        return null;
    }
}