import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int point, time;
    Node(int point, int time) {
        this.point = point;
        this.time = time;
    }
    
    @Override
    public int compareTo(Node n) {
        return this.time - n.time;
    }
}

class Sol13549 {
    static int n, k, min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        bfs();
        System.out.println(min);
    }
    
    private static void bfs() {
        boolean[] visited = new boolean[100001];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(n, 0));
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.point] = true;
            
            if(node.point == k) {
                min = Math.min(min, node.time);
                break;
            }
            
            if(node.point - 1 >= 0 && !visited[node.point - 1])
                queue.offer(new Node(node.point - 1, node.time + 1));
            if(node.point + 1 <= 100000 && !visited[node.point + 1])
                queue.offer(new Node(node.point + 1, node.time + 1));
            if(node.point * 2 <= 100000 && !visited[node.point * 2])
                queue.offer(new Node(node.point * 2, node.time));
        }
    }
}
