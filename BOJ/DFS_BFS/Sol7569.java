import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Sol7569 {
    static int n, m, h;
    static int[][][] box;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dz = {0, 0, -1, 1};
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    	
	    m = Integer.parseInt(st.nextToken());
	    n = Integer.parseInt(st.nextToken());
	    h = Integer.parseInt(st.nextToken());
	    
	    box = new int[h][n][m];
	    
	    for(int i = 0; i < h; i++) {
	        for(int j = 0; j < n; j++) {
	            st = new StringTokenizer(br.readLine());
	            for(int k = 0; k < m; k++) {
	                box[i][j][k] = Integer.parseInt(st.nextToken());
	            }
	        }
	    }
	    
	    System.out.println(bfs());

	    br.close();
	}
	
	private static int bfs() {
	    int cnt = 0;
	    Queue<Node> queue = new LinkedList<>();
	    
	    for(int i = 0; i < h; i++)
	        for(int j = 0; j < n; j++)
	            for(int k = 0; k < m; k++)
	                if(box[i][j][k] == 1)
	                    queue.offer(new Node(i, j, k));

	    while(!queue.isEmpty()) {
	        Node node = queue.poll();
	        int x = node.x, y = node.y, z = node.z;
	        
	        for(int d = 0; d < 4; d++) {
	            int ny = y + dy[d];
	            int nz = z + dz[d];
	            
	            if(ny < 0 || ny >= n || nz < 0 || nz >= m || box[x][ny][nz] != 0)
	                continue;
	                
	            box[x][ny][nz] = box[x][y][z] + 1;
	            cnt = box[x][y][z];
	            queue.offer(new Node(x, ny, nz));
	        }
	        
	        if(x - 1 >= 0 && x - 1 < h && box[x-1][y][z] == 0) {
	            box[x-1][y][z] = box[x][y][z] + 1;
	            cnt = box[x][y][z];
	            queue.offer(new Node(x-1, y, z));
	        }
	        if(x + 1 >= 0 && x + 1 < h && box[x+1][y][z] == 0) {
	            box[x+1][y][z] = box[x][y][z] + 1;
	            cnt = box[x][y][z];
	            queue.offer(new Node(x+1, y, z));
	        }
	    }
	    
	    for(int i = 0; i < h; i++)
	        for(int j = 0; j < n; j++)
	            for(int k = 0; k < m; k++)
	               if(box[i][j][k] == 0)   return -1;
	    return cnt;
	}
}

class Node {
    int x, y, z;
    
    Node(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
