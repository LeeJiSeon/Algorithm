//
import java.util.*;
class Sol2252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] indegree = new int[n + 1];
        List<Integer>[] list = new ArrayList[n + 1];
        for(int i = 1 ; i <= n ; i++)
            list[i] = new ArrayList<Integer>();
        
        for(int i = 0 ; i < m ; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list[x].add(y);
            indegree[y]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++)
            if(indegree[i] == 0)
                queue.offer(i);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            
            for(int next : list[current]) {
                indegree[next]--;
                if(indegree[next] == 0)
                    queue.offer(next);
            }
        }
    }
}
