import java.util.*;

class Edge implements Comparable<Edge> {
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

class Sol1197 {
    static int[] parent;
    static PriorityQueue<Edge> adj;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int answer = 0;
        parent = new int[v];
        adj = new PriorityQueue<>();
        for(int i = 0 ; i < e ; i++) {
            int v1 = sc.nextInt() - 1;
            int v2 = sc.nextInt() - 1;
            int cost = sc.nextInt();
            adj.offer(new Edge(v1, v2, cost));
        }
        for(int i = 0 ; i < v ; i++)
            parent[i] = i;
        
        while(!adj.isEmpty()) {
            Edge edge = adj.poll();
            if(find(edge.v1) != find(edge.v2)) {
                union(edge.v1, edge.v2);
                answer += edge.cost;
            }
        } 
        System.out.println(answer);
    }
    
    private static int find(int v) {
        if(parent[v] == v)    return v;
        return parent[v] = find(parent[v]);
    }
    
    private static void union(int v1, int v2) {
        int f1 = find(v1);
        int f2 = find(v2);
        if(f1 != f2)    parent[f2] = f1;
    }
}
