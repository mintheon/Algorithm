class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1,3 / 2,2 / 3,1
        // int[] -> o2 - o1

        //시간복잡도: nlogn
        //공간복잡도: n
        PriorityQueue<int[]> top = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        Map<Integer, Integer> counter = new HashMap<>();

        for(int num : nums) {
            int count = counter.getOrDefault(num, 0);
            counter.put(num, count + 1);
        }

        for(int key : counter.keySet()) {
            top.offer(new int[]{key, counter.get(key)});
        }

        int[] answer = new int[k];
        for(int i = 0; i < k; i++) {
            answer[i] = top.poll()[0];
        }

        return answer;
    }
}