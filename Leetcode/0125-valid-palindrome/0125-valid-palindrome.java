class Solution {
    public boolean isPalindrome(String s) {
        String text = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int left = 0;
        int right = text.length() - 1;

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