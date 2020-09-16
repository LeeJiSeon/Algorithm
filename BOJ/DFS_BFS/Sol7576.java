import java.util.*;
class Sol7576 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] box = new int[n][m];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < m ; j++)
                box[i][j] = sc.nextInt();
        sc.close();
        
        bfs(box, n, m);
    }
    
    private static void bfs(int[][] box, int n, int m) {
        Queue<Dot> queue = new LinkedList<>();
        int max = 0;
        
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < m ; j++)
                if(box[i][j] == 1)
                    queue.offer(new Dot(i, j));
        
        while(!queue.isEmpty()) {
            Dot cur = queue.poll();
            for(int i = 0 ; i < 4 ; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if(box[nx][ny] == 0) {
                    box[nx][ny] = box[cur.x][cur.y] + 1;
                    queue.offer(new Dot(nx, ny));
                }
            }
        }
        
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < m ; j++) {
                if(box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, box[i][j]);
            }
        System.out.println(max - 1);
    }
}

class Dot {
    int x, y;
    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
