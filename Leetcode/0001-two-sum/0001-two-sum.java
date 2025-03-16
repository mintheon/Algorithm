//시간복잡도: O(n)
//공간복잡도: O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> positions = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            positions.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            if(!positions.containsKey(target - nums[i])) {
                continue;
            }

            int position = positions.get(target - nums[i]);
            
            if(position != i) {
                return new int[]{i, position};
            }
        }

        return new int[]{};
    }
}