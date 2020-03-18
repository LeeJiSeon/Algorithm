//Line
import java.util.*;
class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int width = sc.nextInt();
        int height = sc.nextInt();

        if((width < 1 || width > 24) || (height < 1 || height > 24)) {
            System.out.println("fail");
            return;
        }

        int koni_x = sc.nextInt();
        int koni_y = sc.nextInt();

        if((koni_x < 1 || koni_x > width) || (koni_y < 1 || koni_y > height)) {
            System.out.println("fail");
            return;
        }

        System.out.println(koni_x + koni_y);
        System.out.println(factorial(koni_x + koni_y) / (factorial(koni_x) * factorial(koni_y)));
        
    }

    static long factorial(int n) { 
        if(n <= 1)
            return n;
        else
            return factorial(n-1) * n;
    }
}