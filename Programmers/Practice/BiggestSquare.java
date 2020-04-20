class BiggestSquare {
    public int solution(int [][]board)
    {
        return DP(board);
    }

    static int DP(int[][] board) {
        int max = 0;
        for(int i = 0 ; i < board.length ; i++)
            for(int j = 0 ; j < board[0].length ; j++) {
                int count = 1000;
                if(i >= 1 && j >=1 && board[i][j] == 1) {
                    count = Math.min(count, board[i-1][j]);
                    count = Math.min(count, board[i][j-1]);
                    count = Math.min(count, board[i-1][j-1]);
                    board[i][j] = count+1;
                }
                max = Math.max(max, board[i][j]);
            }
        return max * max;
    }
}