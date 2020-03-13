import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

class Biggest_num {
    public static String solution(int[] numbers) {
        String answer = "";
        String[] num = new String[numbers.length];

        for(int i = 0 ; i < num.length ; i++)
            num[i] = Integer.toString(numbers[i]);
        
        Arrays.sort(num, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2.concat(o1)).compareTo(o1.concat(o2));
            }
        });

        return String.join("", num);
        
        // for(String s : num)
        //     System.out.print(s + " ");

        // return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }
}