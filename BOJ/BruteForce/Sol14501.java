import java.util.Scanner;
class Sol14501 {
    static int[] time, pay;
    static int n, max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        time = new int[n];
        pay = new int[n];
        for(int i = 0 ; i < n ; i++) {
            time[i] = sc.nextInt();
            pay[i] = sc.nextInt();
        }
        calmaxpay(0, 0);
        System.out.println(max);
    }
    
    private static void calmaxpay(int start, int sum) {
        for(int i = start ; i < n ; i++) {
            if(i + time[i] < n)    calmaxpay(i+time[i], sum+pay[i]);
            else if(i + time[i] == n)   max = Math.max(max, sum+pay[i]);
            else    max = Math.max(max, sum);
        }
    }
}
