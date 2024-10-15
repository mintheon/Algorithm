class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> texts = new LinkedList<>();
        List<String> numbers = new LinkedList<>();

        for(int i = 0; i < logs.length; i++) {
            int index = logs[i].indexOf(" ");

            if(Character.isAlphabetic(logs[i].charAt(index + 1))) {
                texts.add(logs[i]);
            } else {
                numbers.add(logs[i]);
            }
        }

        texts.sort((text1, text2) -> {
            String[] t1 = text1.split(" ", 2);
            String[] t2 = text2.split(" ", 2);

            int compared = t1[1].compareTo(t2[1]);
            if(compared == 0) {
                return t1[0].compareTo(t2[0]);
            }

            return compared;
        });

        texts.addAll(numbers);

        return texts.toArray(new String[0]);
    }
}