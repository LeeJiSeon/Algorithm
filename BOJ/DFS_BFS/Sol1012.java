import java.util.*;
class Sol1012 {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n, m;
    static int[][] farm;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < t ; i++) {
            int count = 0;
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();
            farm = new int[n][m];
            visited = new boolean[n][m];
            for(int j = 0 ; j < k ; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                farm[y][x] = 1;
            }

            for(int x = 0 ; x < n ; x++)
                for(int y = 0 ; y < m ; y++) {
                    if(!visited[x][y] && farm[x][y] == 1) {
                        visited[x][y] = true;
                        count++;
                        dfs(new Point(x, y));
                    }
                }
            list.add(count);
        }
        for(int i : list)
            System.out.println(i);
        sc.close();
    }

    static void dfs(Point point) {
        for(int i = 0 ; i < 4 ; i++) {
            int nx = point.x + dx[i];
            int ny = point.y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if(!visited[nx][ny] && farm[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    dfs(new Point(nx, ny));
                }
            }
        }
    }
}