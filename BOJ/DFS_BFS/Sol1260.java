import java.util.*;
class Sol1260 {
    static List<Integer>[] graph;
    static boolean[] visited_d;
    static boolean[] visited_b;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt() - 1;

        graph = new ArrayList[n];
        visited_d = new boolean[n];
        visited_b = new boolean[n];

        for(int i = 0 ; i < n ; i++)
            graph[i] = new ArrayList<Integer>();

        for(int i = 0 ; i < m ; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 0 ; i < n ; i++)
            Collections.sort(graph[i]);

        dfs(v);
        System.out.println();
        bfs(v);
    }

    static void dfs(int start) {
        visited_d[start] = true;
        System.out.print((start+1) + " ");

        for(int next : graph[start]) {
            if(!visited_d[next])
                dfs(next);
        }
    }

    static void bfs(int start) {
        visited_b[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()) {
            int p = queue.poll();
            System.out.print((p+1) + " ");
            for(int i : graph[p]) {
                if(!visited_b[i]) {
                    visited_b[i] = true;
                    queue.add(i);
                }
            }    
        }
    }
}