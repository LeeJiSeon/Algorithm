import java.util.*;
class Sol2178 {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n, m;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        maze = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0 ; i < n ; i++) {
            String str = sc.next();
            for(int j = 0 ; j < m ; j++)
                maze[i][j] = str.charAt(j) - '0';
        }

        bfs(0, 0);

        System.out.println(maze[n-1][m-1]);
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            for(int i = 0 ; i < 4 ; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(!visited[nx][ny] && maze[nx][ny] != 0) {
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                        maze[nx][ny] = maze[point.x][point.y] + 1;
                    }
                }
            }
        }
    }
}