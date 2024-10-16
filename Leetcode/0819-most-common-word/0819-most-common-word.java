class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> counts = new HashMap<>();

        String[] texts = paragraph.replaceAll("[!?',;.]", " ").toLowerCase().split(" ");

        for(String text : texts) {
            if(text == "" || Arrays.asList(banned).indexOf(text) >= 0) {
                continue;
            }
            counts.put(text, counts.getOrDefault(text, 0) + 1);
        }

        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}