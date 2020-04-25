import java.util.Scanner;
class Sol2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stair = new int[n];
        int[][] max = new int[n + 1][2];
        for(int i = 0 ; i < n ; i++)
            stair[i] = sc.nextInt();
        max[1][0] = stair[0];
        max[1][1] = stair[0];
        for(int i = 2 ; i <= n ; i++) {
            max[i][0] = Math.max(max[i-2][0], max[i-2][1]) + stair[i-1];
            max[i][1] = max[i-1][0] + stair[i-1];
        }
        System.out.println(Math.max(max[n][0], max[n][1]));
        sc.close();
    }
}