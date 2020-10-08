import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol17136
{
    static int[][] paper;
    static int[] use;
    static int min = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	    paper = new int[10][10];
	    use = new int[5];
	    
	    for(int i = 0 ; i < 10 ; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        for(int j = 0 ; j < 10 ; j++)
	            paper[i][j] = Integer.parseInt(st.nextToken());
	    }
	    
	    dfs(0);
	    System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	    
	    br.close();
	}
	
	private static void dfs(int idx) {
	    if(idx == 100 && allCover()) {
            int cnt = 0;
	        for(int i = 0 ; i < 5 ; i++)
	            cnt += use[i];
	        min = Math.min(min, cnt);
	        return;
	    }
	    
	    int i = idx / 10;
	    int j = idx % 10;
	    
        if(paper[i][j] == 1) {
            for(int u = 4 ; u >= 0 ; u--) {
                if(use[u] < 5 && canCover(i, j, u)) {
                    cover(i, j, u);
                    use[u]++;
                    dfs(idx + 1);
                    use[u]--;
                    uncover(i, j, u);
                }
            }
        } else  dfs(idx + 1);
	       
	}
	
	private static void cover(int r, int c, int u) {
	    for(int i = 0 ; i < u + 1 ; i++)
	        for(int j = 0 ; j < u + 1 ; j++) {
	            paper[r+i][c+j] = 0;
	        }
	}
	
	private static void uncover(int r, int c, int u) {
	    for(int i = 0 ; i < u + 1 ; i++)
	        for(int j = 0 ; j < u + 1 ; j++) {
	            paper[r+i][c+j] = 1;
	        }
	}
	
	private static boolean canCover(int r, int c, int u) {
	    if(r+u >= 10 || c+u >= 10)
	        return false;
	        
	    for(int i = 0 ; i < u + 1 ; i++)
	        for(int j = 0 ; j < u + 1 ; j++)
	            if(paper[r+i][c+j] == 0)
	                return false;
	    return true;
	}
	
	private static boolean allCover() {
	    for(int i = 0 ; i < 10 ; i++)
	        for(int j = 0 ; j < 10 ; j++)
	            if(paper[i][j] == 1)
	                return false;
	   return true;
	}
}
