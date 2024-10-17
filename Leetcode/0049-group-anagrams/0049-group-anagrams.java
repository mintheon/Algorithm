class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for(String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = String.valueOf(charArr);

            if(anagramsMap.containsKey(sortedStr)) {
                anagramsMap.get(sortedStr).add(str);
            } else {
                anagramsMap.put(sortedStr, new ArrayList<>());
                anagramsMap.get(sortedStr).add(str);
            }
        }

        return new ArrayList<>(anagramsMap.values());
    }
}