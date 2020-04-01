import java.util.Stack;
class ColoringBook {
    static boolean[][] visited;

    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        return bfs(m, n, picture);
    }

    static int[] bfs(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        Stack<Integer> sx = new Stack<>();
        Stack<Integer> sy = new Stack<>();

        for(int i = 0 ; i < m ; i ++)
            for(int j = 0 ; j < n ; j++) {
                int count = 0;
                if(picture[i][j] != 0 && !visited[i][j]) {
                    addStack(sx, sy, i, j);
                    count++;
                    answer[0]++;
                }
                while(!sx.isEmpty()) {
                    int x = sx.pop();
                    int y = sy.pop();

                    if(x > 0 && !visited[x-1][y] && picture[i][j] == picture[x-1][y]) {
                        addStack(sx, sy, x-1, y);
                        count++;
                    }
                    if(x < m-1 && !visited[x+1][y] && picture[i][j] == picture[x+1][y]) {
                        addStack(sx, sy, x+1, y);
                        count++;
                    }
                    if(y > 0 && !visited[x][y-1] && picture[i][j] == picture[x][y-1]) {
                        addStack(sx, sy, x, y-1);
                        count++;
                    }
                    if(y < n-1 && !visited[x][y+1] && picture[i][j] == picture[x][y+1]) {
                        addStack(sx, sy, x, y+1);
                        count++;
                    }
                }
                if(count > answer[1])
                    answer[1] = count;
            }
        return answer;
    }

    static void addStack(Stack<Integer> sx, Stack<Integer> sy, int x, int y) {
        sx.add(x);
        sy.add(y);
        visited[x][y] = true;
    }
}