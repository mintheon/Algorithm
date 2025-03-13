class Solution {
    int length;
    int width;
    List<int[]> move = new LinkedList<>(Arrays.asList(new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, -1}, new int[]{0, 1}));
    boolean[][] visited;

    public int numIslands(char[][] grid) {
        length = grid.length;
        width = grid[0].length;
        visited = new boolean[length][width];

        int landCount = 0;
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < width; j++) {
                if(grid[i][j] == '0' || visited[i][j]) {
                    continue;
                }

                visitedIsland(grid, j, i);
                landCount++;
            }
        }

        return landCount;
    }

    private void visitedIsland(char[][]grid, int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{x, y});
        visited[y][x] = true;
        
        while(!queue.isEmpty()) {
            int[] p = queue.poll();

            for(int[] point : move) {
                int moveX = p[0] + point[0];
                int moveY = p[1] + point[1];

                if(moveX < 0 || moveY < 0 || moveX >= width || moveY >= length) {
                    continue;
                }
                if(grid[moveY][moveX] == '0' || visited[moveY][moveX]) {
                    continue;
                }

                queue.add(new int[]{moveX, moveY});
                visited[moveY][moveX] = true;
            }
        }
    }
}