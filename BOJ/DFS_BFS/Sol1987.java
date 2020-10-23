import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1987 {
    static int R, C, max = 0;
    static int[][] map;
    static boolean[][] visited;
    static boolean[] alpha;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        alpha = new boolean[26];
        map = new int[R][C];
        visited = new boolean[R][C];
        
        for(int i = 0; i < R; i++) {
            String input = br.readLine();
            for(int j = 0; j < C; j++)
                map[i][j] = input.charAt(j) - 'A';
        }
        
        dfs(0, 0, 1);
        
        System.out.println(max);
        br.close();
	}
	
	private static void dfs(int x, int y, int cnt) {
	    alpha[map[x][y]] = true;
	    for(int d = 0; d < 4; d++) {
	        int nx = x + dx[d];
	        int ny = y + dy[d];
	        if(nx < 0 || nx >= R || ny < 0 || ny >= C || alpha[map[nx][ny]])  continue;
	        dfs(nx, ny, cnt+1);
	    }
	    alpha[map[x][y]] = false;
	    max = Math.max(max, cnt);
	}
}
