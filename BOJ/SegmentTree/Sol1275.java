import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1275
{
    static long[] arr, tree;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int Q = Integer.parseInt(st.nextToken());
	    
	    arr = new long[N+1];
	    tree = new long[N*4];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i = 1; i <= N; i++)
	        arr[i] = Long.parseLong(st.nextToken());
	    
	    init(1, N, 1);
        
        StringBuilder sb = new StringBuilder();
	    
	    for(int t = 0; t < Q; t++) {
	        st = new StringTokenizer(br.readLine());
	        int x = Integer.parseInt(st.nextToken());
	        int y = Integer.parseInt(st.nextToken());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        
            sb.append(sum(1, N, 1, Math.min(x, y), Math.max(x, y)) + "\n");
            
            long diff = b - arr[a];
            arr[a] = b;
            update(1, N, 1, a, diff);
	    }
	    
        System.out.println(sb.toString());
	    br.close();
	}
	
	private static long init(int start, int end, int node) {
	    if(start == end)    return tree[node] = arr[start];
	    int mid = (start + end) / 2;
	    return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
	}
	
	private static long sum(int start, int end, int node, int left, int right) {
	    if(left > end || right < start)     return 0;
	    if(left <= start && right >= end)   return tree[node];
	    int mid = (start + end) / 2;
	    return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
	}
	
	private static void update(int start, int end, int node, int idx, long diff) {
	    if(idx > end || idx < start)    return;
	    tree[node] += diff;
	    if(start == end)    return;
	    int mid = (start + end) / 2;
	    update(start, mid, node*2, idx, diff);
	    update(mid+1, end, node*2+1, idx, diff);
	}
}
