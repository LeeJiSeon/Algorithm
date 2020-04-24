import java.util.Scanner;
class Sol9095 {
    static int[] num = new int[11];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] test = new int[n];
        for(int i = 0 ; i < n ; i++)
            test[i] = sc.nextInt();
        num[1] = 1;
        num[2] = 2;
        num[3] = 4;
        for(int i = 0 ; i < n ; i++)
            System.out.println(DP(test[i]));
        sc.close();
    }

    static int DP(int n) {
        if(num[n] > 0)
            return num[n];
        num[n] = DP(n-1) + DP(n-2) + DP(n-3);
        return num[n];
    }

}