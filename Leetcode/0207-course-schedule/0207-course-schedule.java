//시간복잡도: O(V + E)
//DFS나 BFS 탐색 시, 전체 노드를 한 번씩 방문해야 하므로 O(V) + 모든 간선을 한 번씩 탐색해야 하므로 O(E) + 따라서, 총 시간 복잡도는 **O(V + E)**가 된다.
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] visited = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int target = prerequisites[i][1];

            List<Integer> targets = map.getOrDefault(course, new ArrayList<>());
            targets.add(target);
            map.put(course, targets);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(map, visited, i)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(Map<Integer, List<Integer>> map, int[] visited, int curCourse) {
        if(!map.containsKey(curCourse)) {
            visited[curCourse] = 2;
            return true;
        }

        if(visited[curCourse] == 1) {
            return false;
        }

        if(visited[curCourse] == 2) {
            return true;
        }

        visited[curCourse] = 1;
        for(Integer target : map.get(curCourse)) {
            if(!dfs(map, visited, target)) {
                return false;
            }
        }

        visited[curCourse] = 2;
        return true;
    }
}