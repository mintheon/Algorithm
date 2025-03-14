class Solution {
    //23
    // 2 -> abc
    // 3 -> def
    // ["ad","ae","af","bd","be","bf","cd","ce","cf"]

    // digits 2, 3
    // 2 -> abc for()
    // index = index + 1

    Map<Character, List<Character>> graph;

    public List<String> letterCombinations(String digits) {
        List<String> answer = new LinkedList<>();

        if(digits.length() == 0) {
            return answer;
        }

        graph = initNumText();

        dfs(answer, digits, 0, "");

        return answer;
    }

    public void dfs(List<String> answer, String digits, int index, String text) {
        if(digits.length() == text.length()) {
            answer.add(text);
            return;
        }

        char digit = digits.charAt(index);
            
        for(char c : graph.get(digit)) {
            dfs(answer, digits, index + 1, text + c);
        }
    }

    public Map<Character, List<Character>> initNumText() {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('2', List.of('a', 'b', 'c'));
        graph.put('3', List.of('d', 'e', 'f'));
        graph.put('4', List.of('g', 'h', 'i'));
        graph.put('5', List.of('j', 'k', 'l'));
        graph.put('6', List.of('m', 'n', 'o'));
        graph.put('7', List.of('p', 'q', 'r', 's'));
        graph.put('8', List.of('t', 'u', 'v'));
        graph.put('9', List.of('w', 'x', 'y', 'z'));

        return graph;
    }
}