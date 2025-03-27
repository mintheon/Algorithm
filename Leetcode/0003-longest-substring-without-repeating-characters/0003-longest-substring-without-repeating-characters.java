class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1) {
            return 1;
        }

        int answer = 0;

        Map<Character, Integer> indexMap = new HashMap<>();

        int lastIndex = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(indexMap.containsKey(c)) {
                lastIndex = Math.max(lastIndex, indexMap.get(c));
            }

            answer = Math.max(answer, i - lastIndex + 1);
            indexMap.put(c, i + 1);
        }

        return answer;
    }
}