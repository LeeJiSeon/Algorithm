import java.util.Scanner;
class Sol11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int[] dp = new int[n];
        int max = 0;
        for(int i = 0 ; i < n ; i++) {
            num[i] = sc.nextInt();
            dp[i] = 1;
        }

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j <= i ; j++) {
                if(num[i] > num[j] && dp[i] <= dp[j])
                    dp[i] = dp[j] + 1;
            }
            max = Math.max(max, dp[i]);
        }
        
        System.out.println(max);
        sc.close();
    }
}