import java.util.Scanner;
class Sol2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] binary = new long[n+1];
        binary[1] = 1;
        if(n != 1)
            binary[2] = 1;
        for(int i = 3 ; i <= n ; i++)
            binary[i] = binary[i-1] + binary[i-2];
        System.out.println(binary[n]);
        sc.close();
    }
}