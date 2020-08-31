class NQueen {
    boolean[][] board;
    int count, N;
    
    public int solution(int n) {
        board = new boolean[n][n];
        count = 0;
        N = n;
        
        for(int i = 0 ; i < n ; i++) {
            board[0][i] = true;
            dfs(0, i);
            board[0][i] = false;
        }
        return count;
    }
    
    private void dfs(int row, int col) {
        if(row == N - 1) {
            count++;
            return;
        }
        for(int i = 0 ; i < N ; i++) {
            if(isPromising(row+1, i)) {
                board[row+1][i] = true;
                dfs(row+1, i);
                board[row+1][i] = false;
            }
        }
        
    }
    
    private boolean isPromising(int row, int col) {
        for(int i = 0 ; i < row ; i++) {
            if(board[i][col]) return false;
        }
        for(int i = 1 ; i <= row ; i++) {
            if(col - i >= 0 && board[row - i][col - i]) return false;
			if(col + i < N && board[row - i][col + i]) return false;
        }
        return true;
    }
    
}
