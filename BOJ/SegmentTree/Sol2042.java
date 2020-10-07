import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static long[] arr, tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        arr = new long[N + 1];
        for(int i = 1 ; i <= N ; i++)
            arr[i] = Long.parseLong(br.readLine());
        
        tree = new long[N * 4];
        init(1, N, 1);
        
        for(int i = 0 ; i < M+K ; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if(a == 1) {
                long diff = c - arr[b];
                arr[b] = c;
                update(1, N, 1, b, diff);
            } else if(a == 2) {
                System.out.println(sum(1, N, 1, b, c));
            }
        }
        
        br.close();
    }
    
    private static long init(int start, int end, int node) {
        if(start == end)    return tree[node] = arr[start];
        int mid = (start  + end) / 2;
        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }
    
    private static long sum(int start, int end, int node, int left, int right) {
        if(left > end || right < start)    return 0;
        if(left <= start && right >= end)    return tree[node];
        
        int mid = (start + end) / 2;
        return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
    }
    
    private static void update(int start, int end, int node, int idx, long diff) {
        if(idx < start || idx > end)    return;
        tree[node] += diff;
        if(start == end)    return;
        int mid = (start + end) / 2;
        update(start, mid, node*2, idx, diff);
        update(mid+1, end, node*2+1, idx, diff);
    }
}
