import java.io.*;
import java.util.*;
class Sol2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertex = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
 
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < vertex ; i++)
            graph.add(new ArrayList<Integer>());
        for(int i = 0 ; i < edge ; i++) {
            String[] connect = br.readLine().split(" ");
            int v1 = Integer.parseInt(connect[0]);
            int v2 = Integer.parseInt(connect[1]);
            graph.get(v1-1).add(v2-1);
            graph.get(v2-1).add(v1-1);
        }
        
        System.out.println(bfs(graph, 0));
    }
    
    private static int bfs(List<ArrayList<Integer>> graph, int start) {
        int count = 0;
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int virus = queue.poll();
            for(int vertex : graph.get(virus))
                if(!visited[vertex]) {
                    visited[vertex] = true;
                    queue.offer(vertex);
                    count++;
                }
        }
        return count;
    }
}
