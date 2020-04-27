import java.util.Scanner;
class Sol17070 {
    static int n;
    static int[][] home;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        home = new int[n][n];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                home[i][j] = sc.nextInt();
        dfs(0, 1, 1);
        System.out.println(count);
        sc.close();
    }

    /**
     * 
     * @param vector : 1(가로), 2(세로), 3(대각선)
     */
    static void dfs(int x, int y, int vec) {
        if(x == n-1 && y == n-1) {
            count++;
            return;
        }

        if(vec != 1) {
            if(x+1 < n && home[x+1][y] == 0)
                dfs(x+1, y, 2);
        }
        if(vec != 2) {
            if(y+1 < n && home[x][y+1] == 0)
                dfs(x, y+1, 1);
        }
        if(x+1 < n && y+1 < n)
            if(home[x][y+1] == 0 && home[x+1][y] == 0 && home[x+1][y+1] == 0)
                dfs(x+1, y+1, 3);


    }
}