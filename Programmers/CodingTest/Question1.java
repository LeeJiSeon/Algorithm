//Line
import java.util.*;
class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int message[] = new int[sc.nextInt()];
        int consumer[] = new int[sc.nextInt()];

        for(int i = 0 ; i < message.length ; i++)
            message[i] = sc.nextInt();

        for(int m : message){
            consumer[0] += m;
            Arrays.sort(consumer);
        }
        
        System.out.println(consumer[consumer.length - 1]);
    }
}