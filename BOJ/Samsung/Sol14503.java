import java.util.Scanner;
public class Sol14503 {
    static int n, m;
    static int[][] map;
    static int count = 0;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] bx = {1, 0, -1, 0};
    static int[] by = {0, -1, 0, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        int x = sc.nextInt();
        int y = sc.nextInt();
        int dir = sc.nextInt();
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < m ; j++)
                map[i][j] = sc.nextInt();
        
        search(x, y, dir, 0);
        System.out.println(count);
        
        sc.close();
    }

    static void clean(int x, int y) {
        map[x][y] = 2;
        count++;
    }

    static void search(int x, int y, int dir, int check) {
        if(check == 4) {
            if(map[x+bx[dir]][y+by[dir]] == 2)
                search(x+bx[dir], y+by[dir], dir, 0);
            return;
        }
        if(map[x][y] == 0)
            clean(x, y);
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        dir = (dir == 0) ? 3 : dir-1;
        if(map[nx][ny] == 0) {
            search(nx, ny, dir, 0);
        }
        else {
            search(x, y, dir, check+1);
        }
    }
}