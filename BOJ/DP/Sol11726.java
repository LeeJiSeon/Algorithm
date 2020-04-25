import java.util.Scanner;
class Sol11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tile = new int[n];
        tile[0] = 1;
        if(n != 1)
            tile[1] = 2;
        for(int i = 2 ; i < n ; i++) {
            tile[i] = (tile[i-1] + tile[i-2]) % 10007;
        }
        System.out.println(tile[n-1]);
        sc.close();
    }
}