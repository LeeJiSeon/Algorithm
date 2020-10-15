import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Stack;

public class Sol11779 {
    static int n, m;
    static List<Node>[] adj;
    static int[] dist, parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        dist = new int[n + 1];
        parent = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        adj = new ArrayList[n + 1];
        for(int i = 1 ; i <= n ; i++)
            adj[i] = new ArrayList<>();
            
        for(int i = 0 ; i < m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[s].add(new Node(e, w));
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        dijkstra(start, end);
        
        System.out.println(dist[end]);
        printRoad(end);
        
        br.close();
    }
    
    private static void printRoad(int end) {
        Stack<Integer> stack = new Stack<>();
        int cnt = 0, p = end;
        while(p != 0) {
            stack.push(p);
            p = parent[p];
            cnt++;
        }
        
        System.out.println(cnt);
        while(!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }
    
    private static void dijkstra(int start, int end) {
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            Node dep = pq.poll();
            
            if(visited[dep.end])  continue;
            visited[dep.end] = true;
            
            for(Node des : adj[dep.end]) {
                if(dist[des.end] > dist[dep.end] + des.weight) {
                    dist[des.end] = dist[dep.end] + des.weight;
                    pq.offer(new Node(des.end, dist[des.end]));
                    
                    parent[des.end] = dep.end;
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
        return this.weight - n.weight;
    }
}
