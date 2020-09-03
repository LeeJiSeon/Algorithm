import java.util.*;
class IslanConnect {
    class Edge implements Comparable<Edge>{
        int v1, v2, cost;
        Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }
    int[] parent;
    PriorityQueue<Edge> adj;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        adj = new PriorityQueue<>();
        
        for(int[] cost : costs)
            adj.offer(new Edge(cost[0], cost[1], cost[2]));
        for(int i = 0 ; i < n ; i++)    parent[i] = i;
        
        while(!adj.isEmpty()) {
            Edge edge = adj.poll();
            if(find(edge.v1) != find(edge.v2)) {
                union(edge.v1, edge.v2);
                answer += edge.cost;
            }
        }
        return answer;
    }
    
    private int find(int v) {
        if(parent[v] == v)  return v;
        return parent[v] = find(parent[v]);
    }
    
    private void union(int v1, int v2) {
        int f1 = find(v1);
        int f2 = find(v2);
        if(f1 != f2)    parent[f2] = f1;
    }
}
