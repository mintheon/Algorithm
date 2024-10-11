class Solution {
    public void reverseString(char[] s) {
        char[] reversed = new char[s.length];

        int index = 0;
        for(int i = s.length - 1; i >= 0; i--) {
            reversed[index] = s[i];
            index++;
        }

        for(int i = 0; i <= s.length - 1; i++) {
            s[i] = reversed[i];
        }
    }
}