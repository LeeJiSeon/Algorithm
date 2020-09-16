import java.util.*;
class Node implements Comparable<Node> {
    int x, y, weight;
    Node(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node n) {
        return this.weight - n.weight;
    }
}

class Sol1261 {
    static int[][] maze;
    static int[][] dist;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        maze = new int[n+1][m+1];
        dist = new int[n+1][m+1];
        for(int[] d : dist)
            Arrays.fill(d, Integer.MAX_VALUE);
        for(int i = 1 ; i <= n ; i++) {
            String[] arr = sc.next().split("");
            for(int j = 1 ; j <= m ; j++)
                maze[i][j] = Integer.parseInt(arr[j-1]);
        }
        bfs(m, n);
    }
    
    private static void bfs(int m, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 1, 0));
        dist[1][1] = 0;
        
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            for(int i = 0 ; i < 4 ; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx <= 0 || nx > n || ny <= 0 || ny > m)
                    continue;
                if(dist[nx][ny] > dist[node.x][node.y] + maze[nx][ny]) {
                    dist[nx][ny] = dist[node.x][node.y] + maze[nx][ny];
                    pq.offer(new Node(nx, ny, dist[nx][ny]));
                }
            }
        }
        
        System.out.println(dist[n][m]);
    }
}
