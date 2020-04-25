import java.util.Scanner;
class Sol1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] home = new int[n][3];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < 3 ; j++)
                home[i][j] = sc.nextInt();
        for(int i = 1 ; i < n ; i++) {
            home[i][0] += Math.min(home[i-1][1], home[i-1][2]);
            home[i][1] += Math.min(home[i-1][0], home[i-1][2]);
            home[i][2] += Math.min(home[i-1][0], home[i-1][1]);
        }
        System.out.println(Math.min(Math.min(home[n-1][0], home[n-1][1]), home[n-1][2]));
        sc.close();
    }
}