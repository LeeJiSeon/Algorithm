import java.util.*;
class Sol2667 {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static int[][] home;
    static boolean[][] visited;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        home = new int[n][n];
        visited = new boolean[n][n];
        int count = 0;
        for(int i = 0 ; i < n ; i++) {
            String str = sc.next();
            for(int j = 0 ; j < n ; j++)
                home[i][j] = str.charAt(j) - '0';
        }
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++) {
                if(!visited[i][j] && home[i][j] == 1) {
                    visited[i][j] = true;
                    count++;
                    bfs(new Point(i, j));
                }
            }
        System.out.println(count);
        Collections.sort(list);
        for(int i : list)
            System.out.println(i);
        sc.close();
    }

    static void bfs(Point point) {
        int count = 0;
        queue.offer(point);

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            count++;
            for(int i = 0 ; i < 4 ; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n)
                    if(!visited[nx][ny] && home[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
            }
        }
        list.add(count);
    }
}