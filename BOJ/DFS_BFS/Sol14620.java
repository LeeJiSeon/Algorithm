import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Sol14620 {
	static int N, min = Integer.MAX_VALUE;
	static int[][] area;
	static boolean[][] visited;
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		area = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				area[i][j] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		
		System.out.println(min);
		br.close();
	}
	
	private static void dfs(int depth, int cost) {
		if(depth == 3) {
			min = Math.min(min, cost);
			return;
		}
		
		for(int i = 1; i < N-1; i++) {
			for(int j = 1; j < N-1; j++) {			
				if(visited[i][j] || visited[i-1][j] || visited[i+1][j] || visited[i][j-1] || visited[i][j+1])
					continue;
				int sum = 0;
				for(int d = 0; d < 5; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					sum += area[nx][ny];
					visited[nx][ny] = true;
				}
				dfs(depth+1, cost+sum);
				for(int d = 0; d < 5; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];;
					visited[nx][ny] = false;
				}
			}
		}
	}
}
