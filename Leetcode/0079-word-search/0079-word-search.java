class Solution {
    private String word;
    private int row;
    private int col;

    private char[][] board;
    private boolean[][] visited;
    private int[] moveX = {0, 0, -1, 1};
    private int[] moveY = {1, -1, 0, 0};

    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.row = board.length;
        this.col = board[0].length;

        this.board = board;
        this.visited = new boolean[row][col];

        char firstWord = word.charAt(0);
        for(int y = 0; y < row; y++) {
            for(int x = 0; x < col; x++) {
                if(board[y][x] == firstWord) {
                    if(findWord(x, y, 0)) {
                        return true;
                    }
                }
            }
        }    

        return false;
    }

    private boolean findWord(int x, int y, int index) {
        if(index >= word.length()) {
            return true;
        }

        if(x < 0 || y < 0 || x >= col || y >= row) {
            return false;
        }

        if(visited[y][x] || board[y][x] != word.charAt(index)) {
            return false;
        }

        visited[y][x] = true;
        for(int i = 0; i < 4; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];

            if(findWord(nextX, nextY, index + 1)) {
                return true;
            }
        }

        visited[y][x] = false;
        return false;
    }
}