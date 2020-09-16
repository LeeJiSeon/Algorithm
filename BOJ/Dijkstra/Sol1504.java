import java.util.*;
class Node implements Comparable<Node> {
    int end, weight;
    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node n) {
        return this.weight - n.weight;
    }
}

class Sol1504 {
    static List<Node>[] adj;
    static int[] dist;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        long r1 = 0, r2 = 0;
        adj = new ArrayList[n+1];
        dist = new int[n+1];

        for(int i = 1 ; i <= n ; i++)
            adj[i] = new ArrayList<>();
        for(int i = 0 ; i < e ; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            adj[start].add(new Node(end, weight));
            adj[end].add(new Node(start, weight));
        }
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        
        r1 += dijkstra(1, v1);
        r1 += dijkstra(v1, v2);
        r1 += dijkstra(v2, n);
        
        r2 += dijkstra(1, v2);
        r2 += dijkstra(v2, v1);
        r2 += dijkstra(v1, n);
        
        if(r1 >= Integer.MAX_VALUE && r2 >= Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(Math.min(r1, r2));
    }
    
    private static int dijkstra(int start, int end) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[dist.length];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            if(visited[curNode.end])    continue;
            visited[curNode.end] = true;
            
            for(Node n : adj[curNode.end]) {
                if(dist[n.end] > dist[curNode.end] + n.weight) {
                    dist[n.end] = dist[curNode.end] + n.weight;
                    pq.offer(new Node(n.end, dist[n.end]));
                }
            }
        }
        return dist[end];
    }
}
