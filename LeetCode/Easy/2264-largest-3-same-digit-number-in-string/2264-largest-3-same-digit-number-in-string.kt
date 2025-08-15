class Solution {
    fun largestGoodInteger(num: String): String {
        var maxDigit: Char? = null

        for(i in 0 until num.length - 2) {
            if(num[i] == num[i + 1] && num[i] == num[i + 2]) {
                println("maxDigit: ${maxDigit}, num[i]: ${num[i]}")
                maxDigit = if (maxDigit == null) {
                    num[i]
                } else {
                    maxOf(maxDigit.digitToInt(), num[i].digitToInt()).digitToChar()
                }
            }
        }

        return if (maxDigit == null) "" else maxDigit.toString().repeat(3)
    }
}