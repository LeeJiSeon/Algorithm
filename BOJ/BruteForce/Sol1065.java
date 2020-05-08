import java.util.Scanner;
class Sol1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1000)
            n = 999;
        if(n / 100 == 0)
            System.out.println(n);
        else {
            int count = 99;
            for(int i = 100 ; i <= n ; i++) {
                int a = i / 100;
                int b = (i % 100) / 10;
                int c = i % 10;
                if(b - a == c - b)
                    count++;
            }
            System.out.println(count);
        }
        sc.close();
    }
}