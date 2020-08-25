import java.util.*;
class TheFarthestNode {
    boolean[] visited;
    int[] shortest;
    List<ArrayList<Integer>> graph;
    public int solution(int n, int[][] edge) {
        int answer = 1;
        shortest = new int[n];
        visited = new boolean[n];
        graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            graph.add(new ArrayList<Integer>());
        }        
        for(int[] e : edge) {
            graph.get(e[0]-1).add(e[1]-1);
            graph.get(e[1]-1).add(e[0]-1);
        }
        
        visited[0] = true;
        bfs(0);
    
        Arrays.sort(shortest);
        int index = n - 1;
        while(index > 0 && shortest[index] == shortest[index-1]) {
            answer++;
            index--;
        }
        
        return answer;
    }
    
    private void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            for(int e : graph.get(vertex)) {
                if(!visited[e]) {
                    visited[e] = true;
                    queue.offer(e);
                    shortest[e] = shortest[vertex] + 1;
                }  
            }
        }
    }
}
