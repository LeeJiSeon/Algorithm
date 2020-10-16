import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Sol2357 {
    static int[] arr, mintree, maxtree;
    
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        arr = new int[N+1];
        mintree = new int[N*4];     maxtree = new int[N*4];
        
        for(int i = 1 ; i <= N ; i++)
            arr[i] = Integer.parseInt(br.readLine());
            
        init_min(1, N, 1);
        init_max(1, N, 1);
        
        //solve    
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            System.out.print(getmin(1, N, 1, a, b) + " ");
            System.out.println(getmax(1, N, 1, a, b));
        }
        
        br.close();
    }
    
    private static int init_min(int start, int end, int node) {
        if(start == end)    return mintree[node] = arr[start];
        int mid = (start + end) / 2;
        return mintree[node] = Math.min(init_min(start, mid, node*2), init_min(mid+1, end, node*2+1));
    }
    
    private static int init_max(int start, int end, int node) {
        if(start == end)    return maxtree[node] = arr[start];
        int mid = (start + end) / 2;
        return maxtree[node] = Math.max(init_max(start, mid, node*2), init_max(mid+1, end, node*2+1));
    }
    
    private static int getmin(int start, int end, int node, int left, int right) {
        if(left > end || right < start)     return Integer.MAX_VALUE;
        if(left <= start && right >= end)   return mintree[node];
        int mid = (start + end) / 2;
        return Math.min(getmin(start, mid, node*2, left, right), getmin(mid+1, end, node*2+1, left, right));
    }
    
    private static int getmax(int start, int end, int node, int left, int right) {
        if(left > end || right < start)     return Integer.MIN_VALUE;
        if(left <= start && right >= end)   return maxtree[node];
        int mid = (start + end) / 2;
        return Math.max(getmax(start, mid, node*2, left, right), getmax(mid+1, end, node*2+1, left, right));
    }
}
