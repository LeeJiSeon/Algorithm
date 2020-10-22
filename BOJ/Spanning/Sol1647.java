import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Sol1647 {
    static int[] parent;
    static PriorityQueue<Edge> pq;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int ans = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        parent = new int[N+1];
        pq = new PriorityQueue<>();
        
        for(int i = 1 ; i <= N ; i++)
            parent[i] = i;
            
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        while(!pq.isEmpty()) {
            if(N == 2)  break;
            
            Edge e = pq.poll();
            
            if(find(e.v1) != find(e.v2)) {
                union(e.v1, e.v2);
                ans += e.cost;
                N--;
            }
        }
        
        System.out.println(ans);
    }
    
    private static int find(int v) {
        if(parent[v] == v)  return v;
        return parent[v] = find(parent[v]);
    }
    
    private static void union(int v1, int v2) {
        int p1 = parent[v1], p2 = parent[v2];
        parent[p2] = p1;
    }
}

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
