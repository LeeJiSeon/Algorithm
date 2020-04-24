import java.util.Scanner;
class Sol1003 {
    static int[][] fib = new int[41][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int max = 0;;
        for(int i = 0 ; i < n ; i++) {
            num[i] = sc.nextInt();
            max = Math.max(max, num[i]);
        }

        DP(max);
        for(int i : num)
            System.out.println(fib[i][0] + " " + fib[i][1]);
        sc.close();
    }

    static void DP(int n) {
        fib[0][0] = 1;
        fib[1][1] = 1;
        for(int i = 2 ; i <= n ; i++) {
            fib[i][0] = fib[i-1][0] + fib[i-2][0];
            fib[i][1] = fib[i-1][1] + fib[i-2][1];
        }
    }
}