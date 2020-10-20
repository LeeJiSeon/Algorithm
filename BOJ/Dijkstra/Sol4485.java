import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Sol4485 {
    static int N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 1;
	    while(true) {
	        N = Integer.parseInt(br.readLine());
	        if(N == 0)  break;
	        
	        map = new int[N][N];
	        
	        for(int i = 0 ; i < N ; i++) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            for(int j = 0 ; j < N ; j++)
	                map[i][j] = Integer.parseInt(st.nextToken());
	        }
	        
	        System.out.println("Problem " + cnt + ": " + bfs());
            	cnt++;
	    }
	    br.close();
	}
	
	private static int bfs() {
	    Queue<Node> queue = new LinkedList<>();
	    int[][] dist = new int[N][N];
	    for(int i = 0 ; i < N ; i++)
	        for(int j = 0 ; j < N ; j++)
	            dist[i][j] = Integer.MAX_VALUE;
	    dist[0][0] = map[0][0];
	    queue.offer(new Node(0, 0));
	    
	    while(!queue.isEmpty()) {
	        Node node = queue.poll();
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = node.x + dx[d];
	            int ny = node.y + dy[d];
	            
	            if(nx < 0 || nx >= N || ny < 0 || ny >= N)  continue;
	            
	            if(dist[nx][ny] > dist[node.x][node.y] + map[nx][ny]) {
	                dist[nx][ny] = dist[node.x][node.y] + map[nx][ny];
	                queue.offer(new Node(nx, ny));
	            }
	        }
	    }
	    
	    return dist[N-1][N-1];
	}
}

class Node {
    int x, y;
    
    Node(int x, int y) { 
        this.x = x;
        this.y = y;
    }
}
