//시간복잡도: O(m * n)
//공간복잡도: O(m * n)
class Solution {
    private final char LAND = '1';
    private final char SEA = '0';
    private final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { -1, 0 },
            new int[] { 0, 1 },
            new int[] { 1, 0 },
            new int[] { 0, -1 });

    public int numIslands(char[][] grid) {
        int count = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == LAND && !visited[row][col]) {
                    count++;
                    Queue<int[]> queue = new LinkedList<>();

                    queue.add(new int[] {col, row});
                    visited[row][col] = true;

                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();

                        for(int[] directions : DIRECTIONS) {
                            int x = cur[0] + directions[0];
                            int y = cur[1] + directions[1];

                            if(x < 0 || y < 0 || x >= grid[0].length || y >= grid.length || visited[y][x]) {
                                continue;
                            }

                            if(grid[y][x] != LAND) {
                                continue;
                            }

                            visited[y][x] = true;
                            queue.add(new int[] {x, y});
                        }
                    }
                }
            }
        }

        return count;
    }
}