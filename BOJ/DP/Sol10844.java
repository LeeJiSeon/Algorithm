import java.util.Scanner;
class Sol10844 {
    public static void main(String[] args) {
        final int mod = 1000000000;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] stair = new long[n+1][11];
        long sum = 0;
        for(int i = 1 ; i < 10 ; i++)
            stair[1][i] = 1;
        for(int i = 2 ; i <= n ; i++) {
            stair[i][0] = stair[i-1][1];
            for(int j = 1 ; j < 10 ; j++) {
                stair[i][j] = stair[i-1][j-1] + stair[i-1][j+1];
                stair[i][j] %= mod;
            }
        }
        for(int i = 0 ; i < 10 ; i++)
            sum += stair[n][i];
        System.out.println(sum % mod);
        sc.close();
    }
}