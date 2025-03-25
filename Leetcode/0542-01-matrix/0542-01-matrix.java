class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Deque<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int y = cell[0];
            int x = cell[1];

            for(int[] move : moves) {
                int newY = y + move[0];
                int newX = x + move[1];

                if(newY < 0 || newX < 0 || newY >= row || newX >= col) {
                    continue;
                }

                if(mat[y][x] <= mat[newY][newX] + 1) {
                    continue;
                }

                mat[newY][newX] = mat[y][x] + 1;
                queue.add(new int[]{newY, newX});
            }
        }

        return mat;
    }
}