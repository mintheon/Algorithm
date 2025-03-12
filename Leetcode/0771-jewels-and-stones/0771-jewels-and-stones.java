//시간복잡도: n
//공간복잡도: n
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> counts = new HashMap<>();

        for(char stone : stones.toCharArray()) {
            int count = counts.getOrDefault(stone, 0);

            counts.put(stone, count + 1);
        }

        int answer = 0;
        for(char jewel : jewels.toCharArray()) {
            answer += counts.getOrDefault(jewel, 0);
        }

        return answer;
    }
}