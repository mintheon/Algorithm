class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> answer = new ArrayList<>();

        for(String word : words) {
            String[] texts = word.split("[" + separator + "]");

            for(String text : texts) {
                if(text.isEmpty()) {
                    continue;
                }

                answer.add(text);
            }
        }

        return answer;
    }
}