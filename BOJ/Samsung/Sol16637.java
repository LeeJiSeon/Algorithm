import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Sol16637 {
    static int[] nums;
    static char[] ops;
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        
        nums = new int[N/2 + 1];
        ops = new char[N/2];
        
        for(int i = 0 ; i < N ; i++) {
            if(i % 2 == 0)  nums[i/2] = input.charAt(i) - '0';
            else    ops[i/2] = input.charAt(i);
        }
        
        dfs(nums[0], 0);
        System.out.println(max);
        
        br.close();
        
    }
    
    private static void dfs(int result, int cnt) {
        if(cnt >= ops.length) {
            max = Math.max(max, result);
            return;
        }
        
        int res1 = calc(result, nums[cnt+1], ops[cnt]);
        dfs(res1, cnt+1);
        
        if(cnt < ops.length - 1) {
            int res2 = calc(nums[cnt+1], nums[cnt+2], ops[cnt+1]);
            dfs(calc(result, res2, ops[cnt]), cnt+2);
        }
    }
    
    private static int calc(int r1, int r2, char op) {
        if(op == '+')   return r1 + r2;
        else if(op == '-')  return r1 - r2;
        else if(op == '*')  return r1 * r2;
        return -1;
    }
}
