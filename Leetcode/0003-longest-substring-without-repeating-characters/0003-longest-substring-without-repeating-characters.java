class Solution {
    public int lengthOfLongestSubstring(String s) {
        //a b c a b c b b
        //a , 0
        //a,0 b,1
        //a,0 b,1 c,2
        //left -> 0
        //left -> 1
        //a,3 b,1 c,2

        int max = 0;
        int left = 0;
        Map<Character, Integer> indexs = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(indexs.containsKey(c) && left <= indexs.get(c)) {
                left = indexs.get(c) + 1;
            }

            indexs.put(c, i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}