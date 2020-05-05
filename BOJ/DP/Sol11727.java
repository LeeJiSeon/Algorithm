import java.util.Scanner;
class Sol11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] square = new int[n+1];
        square[1] = 1;
        if(n > 1)
            square[2] = 3;
        for(int i = 3 ; i <= n ; i++) {
            square[i] = square[i-2] * 2 + square[i-1];
            square[i] %= 10007;
        }
        System.out.println(square[n]);
        sc.close();
    }
}