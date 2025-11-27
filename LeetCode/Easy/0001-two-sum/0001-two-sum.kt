class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = nums.withIndex().associateBy({it.value}, {it.index})

        for((index, value) in nums.withIndex()) {
            val diff = target - value

            if(map.containsKey(diff) && map[diff] != index) {
                return intArrayOf(index , map[diff]!!)
            }
        }

        return intArrayOf()
    }
}