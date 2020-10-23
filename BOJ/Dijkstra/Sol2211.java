import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Sol2211 {
  static int N, cnt = -1;
  static List<Node>[] adj;
  static int[] parent;

  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      parent = new int[N+1];
      adj = new ArrayList[N+1];
      for(int i = 1; i <= N; i++)
          adj[i] = new ArrayList<>();

      for(int i = 0; i < M; i++) {
          st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          int c = Integer.parseInt(st.nextToken());

          adj[a].add(new Node(b, c));
          adj[b].add(new Node(a, c));
      }

      Dijkstra(1);

      System.out.println(cnt);
      for(int i = 2; i <= N; i++)
          System.out.println(i + " " + parent[i]);

      br.close();
  }

  private static void Dijkstra(int start) {
      boolean[] visited = new boolean[N+1];
      int[] dist = new int[N+1];
      Arrays.fill(dist, Integer.MAX_VALUE);

      PriorityQueue<Node> pq = new PriorityQueue<>();

      pq.offer(new Node(start, 0));
      dist[start] = 0;

      while(!pq.isEmpty()) {
          Node node = pq.poll();
          if(visited[node.next])   continue;
          visited[node.next] = true;
          cnt++;

          for(Node n : adj[node.next]) {
              if(dist[n.next] > dist[node.next] + n.weight) {
                  dist[n.next] = dist[node.next] + n.weight;
                  pq.offer(new Node(n.next, dist[n.next]));
                  parent[n.next] = node.next;
              }
          }
      }
  }
	
}

class Node implements Comparable<Node> {
    int next, weight;
    
    Node(int next, int weight) {
        this.next = next;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node n) {
        return this.weight - n.weight;
    }
}
