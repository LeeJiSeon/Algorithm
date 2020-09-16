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

class Sol1238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        List<Node>[] go = new ArrayList[n+1];
        List<Node>[] back = new ArrayList[n+1];
        int[] dist_go = new int[n+1];
        int[] dist_back = new int[n+1];
        Arrays.fill(dist_go, Integer.MAX_VALUE);
        Arrays.fill(dist_back, Integer.MAX_VALUE);
        for(int i = 1 ; i <= n ; i++) {
            go[i] = new ArrayList<>();
            back[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            go[b].add(new Node(a, w));
            back[a].add(new Node(b, w));
        }
        
        dijkstra(x, go, dist_go);
        dijkstra(x, back, dist_back);
        
        for(int i = 1 ; i <= n ; i++) {
            max = Math.max(max, dist_go[i] + dist_back[i]);
        }
        System.out.println(max);
    }
    
    private static void dijkstra(int start, List<Node>[] adj, int[] dist) {
        boolean[] visited = new boolean[dist.length+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(visited[node.end])
                continue;
            visited[node.end] = true;
            for(Node n : adj[node.end]) {
                if(dist[n.end] > dist[node.end] + n.weight) {
                    dist[n.end] = dist[node.end] + n.weight;
                    pq.offer(new Node(n.end, dist[n.end]));
                }
            }
        }
    }
}
