class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> counter = new HashMap<>();

        for(char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        for(char c: t.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) - 1);
        }

        for(int count : counter.values()) {
            if(count != 0) {
                return false;
            }
        }

        return true;
    }
}