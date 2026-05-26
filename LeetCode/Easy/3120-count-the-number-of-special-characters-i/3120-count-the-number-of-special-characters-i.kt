class Solution {
    fun numberOfSpecialChars(word: String): Int {
        val words = word.toHashSet()

        var count = 0

        for(c in 'a'..'z') {
            if (c in words && c.uppercaseChar() in words){
                count++
            }
        }

        return count
    }
}