class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numsMap = mutableMapOf<Int, Int>()

        for ((i, num) in nums.withIndex()) {
            if(numsMap.containsKey(target - num)) {
                return intArrayOf(i, numsMap[target - num] ?: 0)
            }

            numsMap[num] = i
        }

        return intArrayOf(0, 0)
    }
}