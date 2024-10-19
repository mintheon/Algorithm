class Solution {
    int maxLength = 0;
    int startIndex;

    public String longestPalindrome(String s) {
        char[] texts = s.toCharArray();

        if (texts.length < 2) {
            return s;
        }

        for(int i = 0; i < s.length() - 1; i++) {
            check(texts, i, i + 1);
            check(texts, i, i + 2);
        }

        return s.substring(startIndex, startIndex + maxLength);
    }

    private void check(char[] texts, int start, int end) {
        while(
            start >= 0 
            && end < texts.length
            && texts[start] == texts[end]) {
                start--;
                end++;
        }

        if(maxLength < end - start - 1) {
            startIndex = start + 1;
            maxLength = end - start - 1;
        } 
    }
}