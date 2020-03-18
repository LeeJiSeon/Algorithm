//Line
import java.math.BigInteger;
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
        System.out.println(factorial(koni_x + koni_y).divide(factorial(koni_x).multiply(factorial(koni_y))));
        
    }

    static BigInteger factorial(int n) { 
        BigInteger fac = BigInteger.ONE;
        for(int i = 0 ; i < n ; i++)
            fac = fac.multiply(BigInteger.valueOf(i+1));
        return fac;
    }
}