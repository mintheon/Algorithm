// 

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for(int num : nums) {
            numSet.add(num);
        }

        int max = 0;
        for(int num : numSet) {
            if(numSet.contains(num - 1)) {
                continue;
            }

            int curNum = num;
            int count = 1;
            while(numSet.contains(curNum + 1)) {
                curNum += 1;
                count += 1;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}