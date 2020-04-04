import java.util.*;

class Network {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for(int i = 0 ; i < n ; i++) {
            if(!visited[i]) {
                bfs(i, computers);
                answer++;
            }
        }
        return answer;
    }

    static void bfs(int n, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(n);
        visited[n] = true;

        while(!queue.isEmpty()) {
            n = queue.poll();
            for(int i = 0 ; i < computers.length ; i++)
                if(!visited[i] && computers[n][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                }
        }
    }
}