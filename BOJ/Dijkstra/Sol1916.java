import java.util.*;
class Sol1916 {
    static List<Node>[] adj;
    static int[] dist;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        adj = new ArrayList[n+1];
        dist = new int[n+1];
        for(int i = 1 ; i <= n ; i++)
            adj[i] = new ArrayList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i = 0 ; i < m ; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            adj[start].add(new Node(end, weight));
        }
        
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        dijkstra(v1);
        System.out.println(dist[v2]);
        sc.close();
    }
    
    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dist[start] = 0;
        queue.offer(new Node(start, 0));
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(Node n : adj[node.end]) {
                if(dist[n.end] > dist[node.end] + n.weight) {
                    dist[n.end] = dist[node.end] + n.weight;
                    queue.offer(n.end, dist[n.end]);
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int end, weight;
    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node n) {
        return weight - n.weight;
    }
}
