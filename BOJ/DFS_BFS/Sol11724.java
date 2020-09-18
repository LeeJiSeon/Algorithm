import java.util.*;
class Sol11724 {
    static boolean[] visited;
    static List<Integer>[] list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();
        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i = 1 ; i <= n ; i++)
            list[i] = new ArrayList<>();
        for(int i = 0 ; i < m ; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            list[v1].add(v2);
            list[v2].add(v1);
        }
        
        for(int i = 1 ; i <= n ; i++) {
            if(!visited[i]) {
                cnt++;
                visited[i] = true;
                dfs(i);
            }
        }
        
        System.out.println(cnt);
    }
    
    private static void dfs(int v) {
        for(int l : list[v]) {
            if(!visited[l]) {
                visited[l] = true;
                dfs(l);
            }
        }
    }
}
