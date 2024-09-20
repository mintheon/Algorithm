class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        Map<Integer, List<Integer>> numberMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            List<Integer> values = numberMap.getOrDefault(nums[i], new LinkedList<>());
            values.add(i);

            numberMap.put(nums[i], values);
        }

        for(int key : numberMap.keySet()){
            List<Integer> pair = numberMap.get(target - key);
            if(pair == null) {
                continue;
            }

            if(key != (target - key)) {
                answer[0] = numberMap.get(key).getFirst();
                answer[1] = pair.getFirst();

                return answer;
            } else {
                answer[0] = numberMap.get(key).getFirst();
                answer[1] = numberMap.get(key).getLast();

                return answer;
            }
        }

        return answer;
    }
}