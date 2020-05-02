import java.util.*;
class Sol6087 {
    static class Node {
        int x, y, dir, cnt;
        Node(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int w, h;
    static char[][] map;
    static int[][] visited;
    static Queue<Node> queue = new LinkedList<>();
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        w = sc.nextInt();
        h = sc.nextInt();
        map = new char[h][w];
        visited = new int[h][w];
        List<Node> lazer = new ArrayList<>();
        for(int i = 0 ; i < h ; i++) {
            String str = sc.next();
            for(int j = 0 ; j < w ; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'C')
                    lazer.add(new Node(i, j, -1, 0));
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs(lazer.get(0), lazer.get(1));
        System.out.println(min);
        sc.close();
    }

    static void bfs(Node start, Node end) {
        queue.add(start);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.x == end.x && node.y == end.y) {
                min = Math.min(min, node.cnt);
                continue;
            }
            for(int i = 0 ; i < 4 ; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int nc = node.cnt;
                if(nx < 0 || nx >= h || ny < 0 || ny >= w)  continue;
                if(map[nx][ny] == '*')  continue;
                if(node.dir != i && node.dir != -1) nc++;
                if(visited[nx][ny] < nc)    continue;
                visited[nx][ny] = nc;
                queue.offer(new Node(nx, ny, i, nc));
            }
        }
    }

}