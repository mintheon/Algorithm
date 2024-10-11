class Solution {
    public boolean isPalindrome(String s) {
        String text = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int length = text.length() - 1;
        if(length == -1) {
            return true;
        }

        for(int i = 0; i <= length / 2; i++) {
            if(text.charAt(i) != text.charAt(length - i)) {
                return false;
            }
        }
        return true;
    }
}