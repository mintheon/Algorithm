class Solution {
    /**
    시간복잡도: O(n^2)
    공간복잡도: O(1)
     */
    public int countSubstrings(String s) {
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                if(isPalindrom(s, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isPalindrom(String text, int left, int right) {
        while(left < right) {
            if(text.charAt(left) != text.charAt(right)) {
                return false;
            }
            
            left++;
            right--;
        }

        return true;
    }
}