import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Sol1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N];
        int[] indegree = new int[N];
        int[] result = new int[N];
        
        List<Integer>[] list = new ArrayList[N];
        for(int i = 0 ; i < N ; i++)
            list[i] = new ArrayList<>();
        
        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(true) {
                int v = Integer.parseInt(st.nextToken());
                if(v == -1)
                    break;
                list[v-1].add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < N ; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
                result[i] = time[i];
            }
        }
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int next : list[current]) {
                result[next] = Math.max(result[next], result[current] + time[next]);
                indegree[next]--;
                if(indegree[next] == 0)
                    queue.offer(next);
            }
        }
        
        for(int i = 0 ; i < N ; i++)
            System.out.println(result[i]);
            
        br.close();
    }
}
