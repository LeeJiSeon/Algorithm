import java.util.Scanner;
class Sol2798 {
    static int[] card, sum;
    static int max = 0, m, n;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        card = new int[n];
        sum = new int[3];
        for(int i = 0 ; i < n ; i++)
            card[i] = sc.nextInt();
        sc.close();
        
        dfs(0, 0);
        System.out.println(max);  
    }
    
    private static void dfs(int start, int depth) {
        if(depth == 3) {
            int result = 0;
            for(int s : sum)
                result += s;
            if(result <= m)
                max = Math.max(max, result);
            return;
        }
        
        for(int i = start ; i < n ; i++) {
            sum[depth] = card[i];
            dfs(i+1, depth+1);
        }
    }
}
