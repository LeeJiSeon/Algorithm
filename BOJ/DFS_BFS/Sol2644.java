import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Sol2644 {
    static int n;
    static int[][] relation;
    static int[] dist;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		relation = new int[n+1][n+1];
		dist = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(br.readLine());
	    
	    for(int i = 0; i < m; i++) {
	        st = new StringTokenizer(br.readLine());
	        int x = Integer.parseInt(st.nextToken());
	        int y = Integer.parseInt(st.nextToken());
	        
	        relation[x][y] = 1;     relation[y][x] = 1;
	    }
	    
	    bfs(start, end);
	    
	    System.out.println(dist[end] == 0 ? -1 : dist[end]);
	    br.close();
	}
	
	private static void bfs(int start, int end) {
	    boolean[] visited = new boolean[n+1];
	    Queue<Integer> queue = new LinkedList<>();
	    
	    queue.offer(start);
	    visited[start] = true;
	    
	    while(!queue.isEmpty()) {
	        int dep = queue.poll();
	        
	        for(int i = 1; i <= n; i++) {
	            if(relation[dep][i] == 1 && !visited[i]) {
	                queue.offer(i);
	                visited[i] = true;
	                dist[i] = dist[dep] + 1;
	            }
	        }
	    }
	}
}
