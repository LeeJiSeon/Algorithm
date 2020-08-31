import java.util.*;
class Sol15649 {
    static boolean[] check;
    static int n, m;
    static int[] result;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        check = new boolean[n];
        result = new int[m];
        
        dfs(0);
    }
    private static void dfs(int depth) {
        if(depth == m) {
            for(int r : result)
                System.out.print(r + " ");
            System.out.println();
            return;
        }
            
        for(int i = 0 ; i < n ; i++) {
            if(!check[i]) {
                check[i] = true;
                result[depth] = i+1;
                dfs(depth + 1);
                check[i] = false;
            }
        }
    }
}
