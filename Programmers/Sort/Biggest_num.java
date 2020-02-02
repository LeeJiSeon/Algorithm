import java.util.Arrays;
import java.util.Collection;

class Biggest_num {
    public static String solution(int[] numbers) {
        String answer = "";
        String[] num = new String[numbers.length];

        for(int i = 0 ; i < num.length ; i++)
            num[i] = Integer.toString(numbers[i]);
        
        Arrays.sort(num);
        

        for(String s : num)
            System.out.print(s.valueOf + " ");

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        solution(numbers);
    }
}