import java.util.Scanner;
class Sol1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int max;
        for(int i = 0 ; i < n ; i++)
            num[i] = sc.nextInt();
        
        max = num[0];
        for(int i = 1 ; i < n ; i++) {
            num[i] = Math.max(num[i], num[i-1]+num[i]);
            max = Math.max(max, num[i]);
        }
        System.out.println(max);
        sc.close();
    }
}