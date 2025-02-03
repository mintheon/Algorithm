//시간복잡도: O(m * n)
//공간복잡도: O(m * n)
class Solution {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int WALL = -1;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
        new int[] {-1,  0},
        new int[] { 0,  1},
        new int[] { 1,  0},
        new int[] { 0, -1}
    );

    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0) {
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        for(int row = 0; row < rooms.length; row++) {
            for(int col = 0; col < rooms[0].length; col++) {
                if(rooms[row][col] == GATE) {
                    queue.add(new int[] {col, row});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] point = queue.poll();

            int row = point[1];
            int col = point[0];

            for(int[] direction : DIRECTIONS) {
                int x = col + direction[0];
                int y = row + direction[1];

                if(x < 0 || y < 0 || x >= rooms[0].length || y >= rooms.length || rooms[y][x] != EMPTY) {
                    continue;
                }

                rooms[y][x] = rooms[row][col] + 1;
                queue.add(new int[] {x, y});
            }
        }

    }
}