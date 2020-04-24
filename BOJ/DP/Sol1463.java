import java.util.*;
class Sol1463 {
    static int x;
    static int[] num;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        num = new int[x+1];

        System.out.println(DP(x));
        sc.close();
    }

    static int DP(int n) {
        if(n == 1)
            return 0;

        if(num[n] > 0)
            return num[n];
        
        num[n] = DP(n-1) + 1;
        if(n % 2 == 0)
            num[n] = Math.min(num[n], DP(n/2) + 1);
        if(n % 3 == 0)
            num[n] = Math.min(num[n], DP(n/3) + 1);

        return num[n];
    }
}