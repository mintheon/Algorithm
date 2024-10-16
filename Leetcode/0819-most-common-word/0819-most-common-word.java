class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> counts = new HashMap<>();

        String[] texts = paragraph.toLowerCase().replaceAll("[!?',;.]", " ").split(" ");

        for(String text : texts) {
            if(text == "" || Arrays.asList(banned).indexOf(text) >= 0) {
                continue;
            }
            counts.put(text, counts.getOrDefault(text, 0) + 1);
        }

        List<String> keySet = new ArrayList<>(counts.keySet());
        Collections.sort(keySet, (o1, o2) -> counts.get(o2).compareTo(counts.get(o1)));

        return keySet.get(0);
    }
}