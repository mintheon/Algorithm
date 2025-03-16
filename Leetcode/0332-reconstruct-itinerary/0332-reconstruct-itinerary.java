// JFK -> MUC
// MUC -> LHR
// SFO -> SJC
// LHR -> SFO

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> answer = new LinkedList<>();
        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

        for(int i = 0; i < tickets.size(); i++) {
            List<String> ticket = tickets.get(i);
            String departure = ticket.get(0);
            String arrive = ticket.get(1);

            PriorityQueue<String> arrives = fromToMap.getOrDefault(departure, new PriorityQueue<>());
            arrives.add(arrive);

            fromToMap.put(departure, arrives);
        }

        dfs(answer, fromToMap, "JFK");

        return answer;
    }

    public void dfs(List<String> answer, Map<String, PriorityQueue<String>> fromToMap, String from) {
        while(fromToMap.containsKey(from) && !fromToMap.get(from).isEmpty()) {
            dfs(answer, fromToMap, fromToMap.get(from).poll());
        }

        answer.addFirst(from);
    }
}