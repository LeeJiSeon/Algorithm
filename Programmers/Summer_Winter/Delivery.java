import java.util.*;
class Delivery {
    class Node implements Comparable<Node> {
        int end, weight;
        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
    
    List<Node>[] adj;
    int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        adj = new ArrayList[N+1];
        dist = new int[N+1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i = 1 ; i <= N ; i++)
            adj[i] = new ArrayList<>();
        
        for(int[] edge : road) {
            adj[edge[0]].add(new Node(edge[1], edge[2]));
            adj[edge[1]].add(new Node(edge[0], edge[2]));
        }

        dijkstra(1);
        
        for(int i = 1 ; i <= N ; i++)
            if(dist[i] <= K)    answer++;
        
        return answer;
    }
    
    private void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dist[start] = 0;
        queue.offer(new Node(start, 0));
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(Node n : adj[node.end]) {
                if(dist[n.end] > dist[node.end] + n.weight) {
                    dist[n.end] = dist[node.end] + n.weight;
                    queue.offer(n);
                }
            }
        }
    }
}
