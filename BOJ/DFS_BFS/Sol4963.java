import java.util.*;
class Node {
    int x, y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Sol4963 {
    static int r, c;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int cnt = 0;
            c = sc.nextInt();
            r = sc.nextInt();
            if(c == 0 && r == 0)
                break;
            map = new int[r][c];
            visited = new boolean[r][c];
            for(int i = 0 ; i < r ; i++)
                for(int j = 0 ; j < c ; j++) {
                    map[i][j] = sc.nextInt();
                    if(map[i][j] == 0)    visited[i][j] = true;
                }
            
            for(int i = 0 ; i < r ; i++)
                for(int j = 0 ; j < c ; j++) {
                    if(!visited[i][j]) {
                        cnt++;
                        visited[i][j] = true;
                        bfs(new Node(i, j));
                    }
                }
            System.out.println(cnt);
        }
        sc.close();
    }
    
    private static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            Node curnode = queue.poll();
            for(int i = 0 ; i < 8 ; i++) {
                int nx = curnode.x + dx[i];
                int ny = curnode.y + dy[i];
                if(nx < 0 || nx >= r || ny < 0 || ny >= c)
                    continue;
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny));
                }
            }
        }
    }
}
