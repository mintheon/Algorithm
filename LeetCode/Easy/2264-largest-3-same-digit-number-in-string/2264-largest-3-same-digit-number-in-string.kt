class Solution {
    fun largestGoodInteger(num: String): String {
        var maxDigit: Char? = null

        for(i in 0 until num.length - 2) {
            println(i)
            if(num[i] == num[i + 1] && num[i] == num[i + 2]) {
                val currentDigit = num[i]

                if (maxDigit == null || currentDigit > maxDigit) {
                    maxDigit = currentDigit
                }
            }
        }

        return if (maxDigit == null) "" else maxDigit.toString().repeat(3)
    }
}