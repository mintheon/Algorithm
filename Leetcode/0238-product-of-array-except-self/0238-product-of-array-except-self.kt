class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val answer = IntArray(nums.size)

        var result = 1
        for (i in nums.indices) {
            answer[i] = result
            result *= nums.get(i)
        }

        result = 1
        for (i in nums.indices.reversed()) {
            answer[i] *= result
            result *= nums.get(i)
        }

        return answer
    }
}