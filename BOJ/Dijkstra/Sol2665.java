import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Sol2665 {
    static int N;
    static int[][] room, maze;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		room = new int[N][N];
		maze = new int[N][N];
		
		for(int i = 0; i < N; i++) {
		    String input = br.readLine();
		    for(int j = 0; j < N; j++) {
		        room[i][j] = input.charAt(j) - '0';
		        maze[i][j] = Integer.MAX_VALUE;
		    }
		}
		
		bfs();
		
		System.out.println(maze[N-1][N-1]);
		
		br.close();
	}
	
	private static void bfs() {
	    Queue<Node> queue = new LinkedList<>();
	    queue.offer(new Node(0, 0));
	    maze[0][0] = 0;
	    
	    while(!queue.isEmpty()) {
	        Node node = queue.poll();
	        for(int d = 0; d < 4; d++) {
	            int nx = node.x + dx[d];
	            int ny = node.y + dy[d];

	            if(nx < 0 || nx >= N || ny < 0 || ny >= N)  continue;
	            
	            if(maze[nx][ny] > maze[node.x][node.y]) {
	                if(room[nx][ny] == 1)   maze[nx][ny] = maze[node.x][node.y];
	                else    maze[nx][ny] = maze[node.x][node.y] + 1;
	                queue.offer(new Node(nx, ny));
	            }
	        }
	    }
	}
}

class Node {
    int x, y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
