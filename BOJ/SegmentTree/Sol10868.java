import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol10868 {
    static int[] arr, tree;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    arr = new int[N+1];
	    tree = new int[N*4];
	    
	    for(int i = 1; i <= N; i++)
	        arr[i] = Integer.parseInt(br.readLine());
	    
	    init(1, N, 1);
        
        StringBuilder sb = new StringBuilder();
	    
	    for(int t = 0; t < M; t++) {
	        st = new StringTokenizer(br.readLine());
	        int left = Integer.parseInt(st.nextToken());
	        int right = Integer.parseInt(st.nextToken());
	        
            sb.append(findMin(1, N, 1, left, right) + "\n");
	    }
        System.out.println(sb.toString());
	    br.close();
	}
	
	private static int init(int start, int end, int node) {
	    if(start == end)    return tree[node] = arr[start];
	    int mid = (start + end) / 2;
	    return tree[node] = Math.min(init(start, mid, node*2), init(mid+1, end, node*2+1));
	}
	
	private static int findMin(int start, int end, int node, int left, int right) {
	    if(left > end || right < start)     return Integer.MAX_VALUE;
	    if(left <= start && right >= end)   return tree[node];
	    int mid = (start + end) / 2;
	    return Math.min(findMin(start, mid, node*2, left, right), findMin(mid+1, end, node*2+1, left, right));
	}
}
